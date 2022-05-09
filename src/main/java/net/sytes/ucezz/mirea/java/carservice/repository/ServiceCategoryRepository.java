package net.sytes.ucezz.mirea.java.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sytes.ucezz.mirea.java.carservice.entity.ServiceCategory;

@Repository
public interface ServiceCategoryRepository extends CrudRepository<ServiceCategory, Long> {
    @Query(value = "select * from S_ServiceCategory where username = ?1", nativeQuery = true)
    ServiceCategory get(int id);

    @Query(value = "select * from S_ServiceCategory", nativeQuery = true)
    List<ServiceCategory> getAll();
}