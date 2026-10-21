package az.ingress.java43spring.service;

import az.ingress.java43spring.exception.CityOperationException;
import az.ingress.java43spring.mapper.CityMapper;
import az.ingress.java43spring.model.dto.CityCustomerCount;
import az.ingress.java43spring.model.dto.CityDto;
import az.ingress.java43spring.model.entity.City;
import az.ingress.java43spring.model.entity.Customer;
import az.ingress.java43spring.repository.CityRepository;
import az.ingress.java43spring.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CityService {

    CityRepository cityRepository;
    CustomerRepository customerRepository;
    CityMapper cityMapper;
    PlatformTransactionManager transactionManager;

    public City findById(Integer id){
        City city = cityRepository.findById(id).orElseThrow(NullPointerException::new);
        log.info("city customers : {}", city.getCustomers().get(0).getName());
        return city;
    }

    public List<CityDto> findAll(){
        return cityMapper.toCityDtoList(cityRepository.findAll());
    }

    public List<CityDto> findAllWithCustomersJpql(){
        return cityMapper.toCityDtoList(cityRepository.findAllWithCustomersJpql());
    }

    public CityDto findByIdWithCustomersJpql(Integer id){
        return cityMapper.toCityDto(cityRepository.findByIdWithCustomersJpql(id)
                .orElseThrow(NullPointerException::new));
    }

    public List<CityDto> findAllByCustomerNameJpql(String customerName){
        return cityMapper.toCityDtoList(cityRepository.findAllByCustomerNameJpql(customerName));
    }

    // Mapper customers-e transaction daxilinde muraciet edir -> LazyInitializationException olmur
    @Transactional(readOnly = true)
    public List<CityDto> findAllByNameNative(String name){
        return cityMapper.toCityDtoList(cityRepository.findAllByNameNative(name));
    }

    public List<CityCustomerCount> findCityCustomerCountsNative(){
        return cityRepository.findCityCustomerCountsNative();
    }

    // ---------- @Transactional numuneleri ----------

    // 1) @Transactional YOXDUR: her save() oz transaction-inda commit olunur.
    //    Exception atilsa da city ve customer bazada QALIR.
    public void saveWithoutTransaction(String cityName){
        saveCityWithCustomer(cityName);
        throw new RuntimeException("Xeta bas verdi, amma rollback olmayacaq");
    }

    // 2) RuntimeException -> default olaraq ROLLBACK.
    //    INSERT-ler SQL log-da gorunur, amma bazaya yazilmir.
    @Transactional
    public void saveWithRuntimeException(String cityName){
        saveCityWithCustomer(cityName);
        throw new RuntimeException("RuntimeException -> rollback");
    }

    // 2.1) @Transactional proxy-nin arxada etdiyi isin manual (programmatic) versiyasi.
    //      saveWithRuntimeException() ile eyni neticeni verir -> ROLLBACK.
    //      Spring proxy metodu bele "baglayir": begin -> metod -> commit / rollback
    public void saveWithRuntimeExceptionProxy(String cityName){
        // proxy: transaction-i baslat (repository.save()-ler bu transaction-a qosulur)
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            // proxy: esl metodu cagir
            saveCityWithCustomer(cityName);
            if (true) throw new RuntimeException("RuntimeException -> rollback");
            // proxy: exception yoxdursa -> commit
            transactionManager.commit(status);
        } catch (RuntimeException e) {
            // proxy: RuntimeException -> rollback ve exception-i yuxari otur
            transactionManager.rollback(status);
            throw e;
        }
    }

    // 3) Checked exception -> default olaraq rollback YOXDUR, COMMIT olunur!
    @Transactional
    public void saveWithCheckedException(String cityName) throws CityOperationException {
        saveCityWithCustomer(cityName);
        throw new CityOperationException("Checked exception -> commit");
    }

    // 4) rollbackFor: istediyimiz exception ucun rollback
    @Transactional(rollbackFor = CityOperationException.class)
    public void saveWithRollbackFor(String cityName) throws CityOperationException {
        saveCityWithCustomer(cityName);
        throw new CityOperationException("rollbackFor = CityOperationException -> rollback");
    }

    // 5) noRollbackFor: RuntimeException olsa da COMMIT olunur
    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public void saveWithNoRollbackFor(String cityName){
        saveCityWithCustomer(cityName);
        throw new IllegalArgumentException("noRollbackFor = IllegalArgumentException -> commit");
    }

    // 6) Exception metod daxilinde tutulursa (catch) Spring onu gormur -> COMMIT
    @Transactional
    public void saveWithCaughtException(String cityName){
        try {
            saveCityWithCustomer(cityName);
            throw new RuntimeException("catch olunan exception");
        } catch (RuntimeException e) {
            log.error("Exception tutuldu: {}", e.getMessage());
        }
    }

    // 7) Self-invocation: eyni class-dan cagirilan @Transactional metod proxy-den kecmir.
    //    saveWithRuntimeException() burada adi metod kimi isleyir -> rollback YOXDUR
    public void selfInvocation(String cityName){
        saveWithRuntimeException(cityName);
    }

    private void saveCityWithCustomer(String cityName){
        City city = new City();
        city.setName(cityName);
        cityRepository.save(city);
        log.info("City saved, id = {}", city.getId());

        Customer customer = new Customer();
        customer.setName("Tx");
        customer.setSurname("Test");
        customer.setCity(city);
        customerRepository.save(customer);
        log.info("Customer saved, id = {}", customer.getId());
    }
}
