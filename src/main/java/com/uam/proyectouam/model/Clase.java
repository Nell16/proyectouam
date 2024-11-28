package com.uam.proyectouam.model;

import javax.persistence.*;

import lombok.*;
import org.openxava.annotations.TextArea;
import org.openxava.model.Identifiable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Cada subclase tiene su propia tabla
@Getter
@Setter
public abstract class Clase extends Identifiable {

    @Column(name = "nombre", nullable = false) // Este atributo debe estar en la tabla "clase"
    private String nombre;

    @TextArea
    private String descripcion;
}




