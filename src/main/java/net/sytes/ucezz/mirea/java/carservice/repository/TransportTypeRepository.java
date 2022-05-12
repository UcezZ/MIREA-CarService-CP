package net.sytes.ucezz.mirea.java.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sytes.ucezz.mirea.java.carservice.entity.TransportTypeEntity;

@Repository
public interface TransportTypeRepository extends CrudRepository<TransportTypeEntity, Long> {
    @Query(value = "select * from S_TransportType where id_transport_type = ?1", nativeQuery = true)
    TransportTypeEntity get(int id);

    @Query(value = "select * from S_TransportType where caption = ?1", nativeQuery = true)
    TransportTypeEntity get(String caption);

    @Query(value = "select caption from S_TransportType where id_transport_type = ?1", nativeQuery = true)
    String getCaption(int id);

    @Query(value = "select * from S_TransportType", nativeQuery = true)
    List<TransportTypeEntity> getAll();
}