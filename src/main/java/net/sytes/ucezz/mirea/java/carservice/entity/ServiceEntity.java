package net.sytes.ucezz.mirea.java.carservice.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "T_Service")
@Transactional
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    int id;
    int idServiceCategory;
    int idManager;
    int idTransport;
    String description;
    String creation;
    String completion;

    public String getCompletion() {
        return completion;
    }

    public String getCompletionHumanReadable() throws ParseException {
        return new SimpleDateFormat("d MMM yyyy HH:mm")
                .format(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(completion));
    }

    public String getCreation() {
        return creation;
    }

    public String getCreationHumanReadable() throws ParseException {
        return new SimpleDateFormat("d MMM yyyy HH:mm")
                .format(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(creation));
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
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

    public ServiceEntity setCompletion(String completion) {
        this.completion = completion;
        return this;
    }

    public ServiceEntity setCreation(String creation) {
        this.creation = creation;
        return this;
    }

    public ServiceEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ServiceEntity setId(int id) {
        this.id = id;
        return this;
    }

    public ServiceEntity setIdManager(int idManager) {
        this.idManager = idManager;
        return this;
    }

    public ServiceEntity setIdServiceCategory(int idServiceCategory) {
        this.idServiceCategory = idServiceCategory;
        return this;
    }

    public ServiceEntity setIdTransport(int idTransport) {
        this.idTransport = idTransport;
        return this;
    }
}
