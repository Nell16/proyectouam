package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "carrera")
@View(name="simple",members="nombre, facultad")
public class Carrera extends Identifiable {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @ManyToOne
    @DescriptionsList(descriptionProperties = "nombre")
    private Facultad facultad;

}

