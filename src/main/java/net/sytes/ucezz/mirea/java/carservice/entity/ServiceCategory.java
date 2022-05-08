package net.sytes.ucezz.mirea.java.carservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "S_ServiceCategory")
@Transactional
public class ServiceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service_category")
    int id;

    @Column(name = "caption")
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
