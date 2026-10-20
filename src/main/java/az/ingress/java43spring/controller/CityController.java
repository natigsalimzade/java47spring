package az.ingress.java43spring.controller;

import az.ingress.java43spring.exception.CityOperationException;
import az.ingress.java43spring.model.dto.CityCustomerCount;
import az.ingress.java43spring.model.dto.CityDto;
import az.ingress.java43spring.model.dto.CustomerDTO;
import az.ingress.java43spring.model.entity.City;
import az.ingress.java43spring.service.CityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/cities")
public class CityController {

    CityService cityService;

    @GetMapping
    public List<CityDto> findAll(){
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable Integer id){
        return cityService.findById(id);
    }

    @GetMapping("/jpql")
    public List<CityDto> findAllWithCustomersJpql(){
        return cityService.findAllWithCustomersJpql();
    }

    @GetMapping("/jpql/{id}")
    public CityDto findByIdWithCustomersJpql(@PathVariable Integer id){
        return cityService.findByIdWithCustomersJpql(id);
    }

    @GetMapping("/jpql/by-customer")
    public List<CityDto> findAllByCustomerNameJpql(@RequestParam String customerName){
        return cityService.findAllByCustomerNameJpql(customerName);
    }

    @GetMapping("/native")
    public List<CityDto> findAllByNameNative(@RequestParam String name){
        return cityService.findAllByNameNative(name);
    }

    @GetMapping("/native/customer-count")
    public List<CityCustomerCount> findCityCustomerCountsNative(){
        return cityService.findCityCustomerCountsNative();
    }

    // ---------- @Transactional numuneleri ----------

    @PostMapping("/tx/no-transaction")
    public void saveWithoutTransaction(@RequestParam String name){
        cityService.saveWithoutTransaction(name);
    }

    @PostMapping("/tx/runtime")
    public void saveWithRuntimeException(@RequestParam String name){
        cityService.saveWithRuntimeException(name);
    }

    @PostMapping("/tx/checked")
    public void saveWithCheckedException(@RequestParam String name) throws CityOperationException {
        cityService.saveWithCheckedException(name);
    }

    @PostMapping("/tx/rollback-for")
    public void saveWithRollbackFor(@RequestParam String name) throws CityOperationException {
        cityService.saveWithRollbackFor(name);
    }

    @PostMapping("/tx/no-rollback-for")
    public void saveWithNoRollbackFor(@RequestParam String name){
        cityService.saveWithNoRollbackFor(name);
    }

    @PostMapping("/tx/caught")
    public void saveWithCaughtException(@RequestParam String name){
        cityService.saveWithCaughtException(name);
    }

    @PostMapping("/tx/self-invocation")
    public void selfInvocation(@RequestParam String name){
        cityService.selfInvocation(name);
    }
}
