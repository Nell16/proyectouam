package com.uam.proyectouam.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "clase_dc")
@Getter
@Setter
@Tab(properties = "nombre, nombresCarreras, nombresGrupos, nombresEstudiantes, nombresProfesores")
public class ClaseDC extends Clase {

    @ManyToMany(mappedBy = "clasesDC")
    @Collapsed
    private Set<Carrera> carreraClase = new HashSet<>();

    @Transient
    public String getNombresCarreras() {
        if (carreraClase == null || carreraClase.isEmpty()) return "Sin carreras";
        return carreraClase.stream()
                .map(Carrera::getNombre)
                .collect(Collectors.joining(", "));
    }

    @PrePersist
    @PreUpdate
    private void establecerTipoClase() {
        this.setTipoClase("De Carrera");
    }
}






