package net.sytes.ucezz.mirea.java.carservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "S_ServiceCategory")
public class ServiceCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service_category")
    int id;
    String caption;

    public String getCaption() {
        return caption;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", getId(), getCaption());
    }
}
