package net.sytes.ucezz.mirea.java.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sytes.ucezz.mirea.java.carservice.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "select * from t_user where id_user = ?1", nativeQuery = true)
    User get(int id);

    @Query(value = "select * from t_user where username = ?1", nativeQuery = true)
    User findByUsername(String username);

    @Query(value = "select * from t_user", nativeQuery = true)
    List<User> getAllUsers();
}