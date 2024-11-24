package com.uam.proyectouam.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;

import java.util.List;

@Entity
@Table(name = "clase")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Clase extends Identifiable {

    @Column(name = "nombre_clase", nullable = false)
    private String nombreClase;

    @Column(name = "descripcion")
    private String descripcion;



}
