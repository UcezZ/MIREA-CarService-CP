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

    @Query(value = "select * from t_transport where reg_number = ?1", nativeQuery = true)
    TransportEntity get(String regNumber);

    @Query(value = "select * from t_transport where id_user = ?1", nativeQuery = true)
    List<TransportEntity> getAllByUserId(int id);

    @Query(value = "select * from t_transport where id_transport_type = ?1", nativeQuery = true)
    TransportEntity getAllByTransportTypeId(int id);

    @Query(value = "select * from t_transport", nativeQuery = true)
    List<TransportEntity> getAll();

    @Query(value = "select count(*) from t_transport where id_user = ?1", nativeQuery = true)
    int getCountByUserId(int id);

    @Query(value = "insert into t_transport (id_transport_type, id_user, brand, model, reg_number, release_year) values (?1, ?2, ?3, ?4, ?5, ?6); select '';", nativeQuery = true)
    void add(int idTransportType, int idUser, String brand, String model, String regNumber, int releaseYear);
}