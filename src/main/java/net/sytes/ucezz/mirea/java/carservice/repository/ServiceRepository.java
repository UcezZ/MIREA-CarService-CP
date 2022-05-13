package net.sytes.ucezz.mirea.java.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sytes.ucezz.mirea.java.carservice.entity.ServiceEntity;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {
    @Query(value = "select * from t_service where id_service = ?1", nativeQuery = true)
    ServiceEntity get(int id);

    @Query(value = "select * from t_service", nativeQuery = true)
    List<ServiceEntity> getAll();

    @Query(value = "select t_service.* from t_service join t_transport on t_service.id_transport = t_transport.id_transport where t_transport.id_user = ?1", nativeQuery = true)
    List<ServiceEntity> getAllByUserId(int id);

    @Query(value = "select count(*) from t_service join t_transport on t_service.id_transport = t_transport.id_transport where t_transport.id_user = ?1", nativeQuery = true)
    int getCountByUserId(int id);

    @Query(value = "select * from t_service where id_transport = ?1", nativeQuery = true)
    List<ServiceEntity> getAllByTransportId(int id);

    @Query(value = "select count(*) from t_service where id_transport = ?1", nativeQuery = true)
    int getCountByTransportId(int id);

    @Query(value = "select t_service.* from t_service join t_transport on t_service.id_transport = t_transport.id_transport and t_transport.id_user = ?1 where t_service.id_manager = 0", nativeQuery = true)
    List<ServiceEntity> getUserNewServices(int idUser);

    @Query(value = "select t_service.* from t_service join t_transport on t_service.id_transport = t_transport.id_transport and t_transport.id_user = ?1 where t_service.id_manager > 0 and len(t_service.completion) = 0", nativeQuery = true)
    List<ServiceEntity> getUserActiveServices(int idUser);

    @Query(value = "select t_service.* from t_service join t_transport on t_service.id_transport = t_transport.id_transport and t_transport.id_user = ?1 where t_service.id_manager > 0 and len(t_service.completion) > 0", nativeQuery = true)
    List<ServiceEntity> getUserClosedServices(int idUser);

    @Query(value = "select * from t_service where t_service.id_manager = 0", nativeQuery = true)
    List<ServiceEntity> getManagerNewServices();

    @Query(value = "select * from t_service where t_service.id_manager = ?1 and len(t_service.completion) = 0", nativeQuery = true)
    List<ServiceEntity> getManagerActiveServices(int idManager);

    @Query(value = "select * from t_service where t_service.id_manager = ?1 and len(t_service.completion) > 0", nativeQuery = true)
    List<ServiceEntity> getManagerClosedServices(int idManager);

    @Query(value = "insert into t_service (id_service_category, id_transport, description, creation) values (?1, ?2, ?3, ?4); select '';", nativeQuery = true)
    void add(int idServiceCategory, int idTransport, String description, String creation);
}