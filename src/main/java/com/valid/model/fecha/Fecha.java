package com.valid.model.fecha;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
 
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"fechaCreacion", "fechaActualizacion"},
        allowGetters = true
)
public abstract class Fecha {
 
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant fechaCreacion;
 
    @LastModifiedDate
    @Column(nullable = false)
    private Instant fechaActualizacion;

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Instant getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Instant fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}