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

    @Column(name = "IsManager")
    Boolean isManager;

    @Column(name = "LastName")
    String lastName;

    @Column(name = "FirstName")
    String firstName;

    @Column(name = "MiddleName")
    String middleName;

    @Column(name = "Username")
    String username;

    @Column(name = "PasswordHashString")
    String passwordHashString;

    @Column(name = "BirthDate")
    String birthDate;

    public User() {
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
                getIsManager() ? "Сотрудник" : "Клиент");
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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        passwordHashString = new String(messageDigest.digest());
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
