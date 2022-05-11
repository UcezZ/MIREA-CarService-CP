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
    User get(String username);

    @Query(value = "select * from t_user", nativeQuery = true)
    List<User> getAll();

    @Query(value = "insert into t_user (is_manager, last_name, first_name, middle_name, username, password_hash_string, birth_date) values ('false', ?1, ?2, ?3, ?4, ?5, ?6) union select ''", nativeQuery = true)
    void register(String lastName, String firstName, String middleName, String username,
            String passwordHashString, String birthDate);
}