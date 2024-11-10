package com.manuellarrota.admin.entities.common;


import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * Superclase Generica con atributos generales que son reusados como singleton para las
 * obtenerEspecificacion clases entidades relacionales del sistema.
 *
 * @author Manuel Larrota
 */
@Setter
@Getter
@MappedSuperclass
public class Domain implements Serializable {

    protected Boolean visible = true;
    protected Boolean enable = true;
    protected Date lastUpdate;
    protected Date dateCreated;
    protected Date dateDisabled;

    @PrePersist
    @PreUpdate
    protected void beforePersist() {
        setLastUpdate(Date.from(Instant.now()));
        if (enable == null) {
            enable = true;
        }
        if (visible == null) {
            visible = true;
        }
        if (dateCreated == null) {
            setDateCreated(Date.from(Instant.now()));
        }
        if (!enable) {
            setDateDisabled(Date.from(Instant.now()));
        }
    }

    public Boolean isVisible() {
        return visible;
    }

    public Boolean isDisponible() {
        return enable;
    }

}
