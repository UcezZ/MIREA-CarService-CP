package net.sytes.ucezz.mirea.java.carservice.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "T_User")
@Transactional
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_User")
    int id;
    Boolean isManager;
    String lastName;
    String firstName;
    String middleName;
    String username;
    String passwordHashString;
    String birthDate;

    public User() {
        isManager = false;
        id = 0;
        lastName = firstName = middleName = username = passwordHashString = birthDate = "";
    }

    public User(String username, String passwordHashString) {
        this.username = username;
        this.passwordHashString = passwordHashString;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s %s, %s, %s:%s, %s",
                getId(),
                getLastName(),
                getFirstName(),
                getMiddleName(),
                getBirthDate(),
                getUsername(),
                getPasswordHashString(),
                getRole());
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public Boolean getIsManager() {
        return isManager;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPasswordHashString() {
        return passwordHashString;
    }

    public String getUsername() {
        return username;
    }

    public User setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public User setIsManager(Boolean isManager) {
        this.isManager = isManager;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public User setPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            passwordHashString = new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(System.err);
        }
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRole() {
        return isManager ? getUsername().equalsIgnoreCase("Admin") ? "ADMIN" : "MANAGER" : "CLIENT";
    }

    public User setRole(String role) {
        setIsManager(role == "MANAGER");
        return this;
    }
}
