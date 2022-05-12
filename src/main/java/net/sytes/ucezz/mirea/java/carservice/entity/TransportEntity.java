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
public class TransportEntity {
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

    @Override
    public String toString() {
        return String.format("%d: Of user #%d, type #%d, %s %s, %s, %d",
                getId(),
                getIdUser(),
                getIdTransportType(),
                getBrand(),
                getModel(),
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

    public TransportEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public TransportEntity setId(int id) {
        this.id = id;
        return this;
    }

    public TransportEntity setIdTransportType(int idTransportType) {
        this.idTransportType = idTransportType;
        return this;
    }

    public TransportEntity setIdUser(int idUser) {
        this.idUser = idUser;
        return this;
    }

    public TransportEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public TransportEntity setRegNumber(String regNumber) {
        this.regNumber = regNumber;
        return this;
    }

    public TransportEntity setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }
}
