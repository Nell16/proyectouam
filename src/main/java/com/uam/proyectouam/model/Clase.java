package com.uam.proyectouam.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@View(name = "NingunaVista", members = "") // Vista vacía
public abstract class Clase extends Identifiable {

    @Column(name = "nombre_clase", nullable = false)
    private String nombreClase;

    @TextArea
    private String descripcion;
}


