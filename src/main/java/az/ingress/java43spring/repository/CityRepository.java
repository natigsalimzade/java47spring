package az.ingress.java43spring.repository;

import az.ingress.java43spring.model.dto.CityCustomerCount;
import az.ingress.java43spring.model.entity.City;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
//
//    @EntityGraph(attributePaths = {"customers"})
//    Optional<City> findById(Integer id);
//
//    @EntityGraph(value = "city-customers")
//    List<City> findAll();

    // ---------- JPQL ----------

    // JOIN FETCH customers-i eyni sorgu ile yukleyir -> LazyInitializationException olmur
    @Query("SELECT c FROM City c LEFT JOIN FETCH c.customers")
    List<City> findAllWithCustomersJpql();

    @Query("SELECT c FROM City c LEFT JOIN FETCH c.customers WHERE c.id = :id")
    Optional<City> findByIdWithCustomersJpql(@Param("id") Integer id);

    // FETCH olmadan sade JOIN: customers yene LAZY qalir
    @Query("SELECT DISTINCT c FROM City c JOIN c.customers cu WHERE cu.name = :customerName")
    List<City> findAllByCustomerNameJpql(@Param("customerName") String customerName);

    // ---------- Native SQL ----------

    // Native query City entity qaytarir, amma customers collection-i LAZY qalir
    @Query(value = "SELECT * FROM cities WHERE name = :name", nativeQuery = true)
    List<City> findAllByNameNative(@Param("name") String name);

    // Native query + interface projection: entity yox, yalniz lazim olan sutunlar
    @Query(value = """
            SELECT c.id AS id, c.name AS name, COUNT(cu.id) AS customerCount
            FROM cities c
            LEFT JOIN customers cu ON cu.city_id = c.id
            GROUP BY c.id, c.name
            """, nativeQuery = true)
    List<CityCustomerCount> findCityCustomerCountsNative();
}
