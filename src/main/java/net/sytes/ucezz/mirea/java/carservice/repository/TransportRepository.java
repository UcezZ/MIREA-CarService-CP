package net.sytes.ucezz.mirea.java.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sytes.ucezz.mirea.java.carservice.entity.TransportEntity;

@Repository
public interface TransportRepository extends CrudRepository<TransportEntity, Long> {
    @Query(value = "select * from t_transport where id_transport = ?1", nativeQuery = true)
    TransportEntity get(int id);

    @Query(value = "select * from t_transport where id_user = ?1", nativeQuery = true)
    List<TransportEntity> getAllByUserId(int id);

    @Query(value = "select * from t_transport where id_transport_type = ?1", nativeQuery = true)
    TransportEntity getAllByTransportTypeId(int id);

    @Query(value = "select * from t_transport", nativeQuery = true)
    List<TransportEntity> getAll();

    @Query(value = "select count(*) from t_transport where id_user = ?1", nativeQuery = true)
    int getCountByUserId(int id);
}