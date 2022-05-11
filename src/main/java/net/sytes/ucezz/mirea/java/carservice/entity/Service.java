package net.sytes.ucezz.mirea.java.carservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    int id;
    int idServiceCategory;
    int idClient;
    int idManager;
    int idTransport;
    String description;
    String creation;
    String completion;

    public String getCompletion() {
        return completion;
    }

    public String getCreation() {
        return creation;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdManager() {
        return idManager;
    }

    public int getIdServiceCategory() {
        return idServiceCategory;
    }

    public int getIdTransport() {
        return idTransport;
    }

    public Service setCompletion(String completion) {
        this.completion = completion;
        return this;
    }

    public Service setCreation(String creation) {
        this.creation = creation;
        return this;
    }

    public Service setDescription(String description) {
        this.description = description;
        return this;
    }

    public Service setId(int id) {
        this.id = id;
        return this;
    }

    public Service setIdClient(int idClient) {
        this.idClient = idClient;
        return this;
    }

    public Service setIdManager(int idManager) {
        this.idManager = idManager;
        return this;
    }

    public Service setIdServiceCategory(int idServiceCategory) {
        this.idServiceCategory = idServiceCategory;
        return this;
    }

    public Service setIdTransport(int idTransport) {
        this.idTransport = idTransport;
        return this;
    }
}
