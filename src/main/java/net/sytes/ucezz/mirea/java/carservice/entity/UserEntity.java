package net.sytes.ucezz.mirea.java.carservice.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

@Entity
@Table(name = "T_User")
@Transactional
public class UserEntity {
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

    public UserEntity() {
        isManager = false;
        id = 0;
        lastName = firstName = middleName = username = passwordHashString = birthDate = "";
    }

    public UserEntity(String username, String passwordHashString) {
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

    public String getBirthDateHumanReadable() throws ParseException {
        return new SimpleDateFormat("d MMM yyyy")
                .format(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate));
    }

    public int getBirthYear() throws ParseException {
        return Integer.parseInt(new SimpleDateFormat("yyyy")
                .format(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate)));
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

    public String getSummary() throws ParseException {
        if (middleName.length() == 0) {
            return String.format("%s %c. %d г. р.", lastName, firstName.charAt(0), getBirthYear());
        } else {
            return String.format("%s %c. %c. %d г. р.", lastName, firstName.charAt(0), middleName.charAt(0),
                    getBirthYear());
        }
    }

    public UserEntity setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntity setId(int id) {
        this.id = id;
        return this;
    }

    public UserEntity setIsManager(Boolean isManager) {
        this.isManager = isManager;
        return this;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEntity setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public UserEntity setPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();
            passwordHashString = DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(System.err);
        }
        return this;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRole() {
        return isManager ? getUsername().equalsIgnoreCase("Admin") ? "ADMIN" : "MANAGER" : "CLIENT";
    }

    public UserEntity setRole(String role) {
        setIsManager(role == "MANAGER");
        return this;
    }
}
