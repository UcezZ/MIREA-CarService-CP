package net.sytes.ucezz.mirea.java.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sytes.ucezz.mirea.java.carservice.entity.TransportType;

@Repository
public interface TransportTypeRepository extends CrudRepository<TransportType, Long> {
    @Query(value = "select * from S_TransportType where id_transport_type = ?1", nativeQuery = true)
    TransportType get(int id);

    @Query(value = "select caption from S_TransportType where id_transport_type = ?1", nativeQuery = true)
    String getCaption(int id);

    @Query(value = "select * from S_TransportType", nativeQuery = true)
    List<TransportType> getAll();
}