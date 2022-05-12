package net.sytes.ucezz.mirea.java.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sytes.ucezz.mirea.java.carservice.entity.ServiceCategoryEntity;

@Repository
public interface ServiceCategoryRepository extends CrudRepository<ServiceCategoryEntity, Long> {
    @Query(value = "select * from S_ServiceCategory where id_service_category = ?1", nativeQuery = true)
    ServiceCategoryEntity get(int id);

    @Query(value = "select caption from S_ServiceCategory where id_service_category = ?1", nativeQuery = true)
    String getCaption(int id);

    @Query(value = "select * from S_ServiceCategory", nativeQuery = true)
    List<ServiceCategoryEntity> getAll();
}