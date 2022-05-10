package net.sytes.ucezz.mirea.java.carservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "T_Transport")
@Transactional
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Transport")
    int id;
    int idUser;
    int idTransportType;
    int releaseYear;
    String brand;
    String model;
    String regNumber;
    String vin;

    @Override
    public String toString() {
        return String.format("%d: Of user #%d, type #%d, %s %s, %s, %s, %d",
                getId(),
                getIdUser(),
                getIdTransportType(),
                getBrand(),
                getModel(),
                getVin(),
                getRegNumber(),
                getReleaseYear());
    }

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public int getIdTransportType() {
        return idTransportType;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getModel() {
        return model;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdTransportType(int idTransportType) {
        this.idTransportType = idTransportType;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
