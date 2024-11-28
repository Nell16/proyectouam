package com.uam.proyectouam.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import lombok.*;

@Entity
@Table(name = "clase_dc")
@Getter
@Setter
@Tab(properties = "nombre, carrera.nombre, carrera.facultad.nombre, nombresGrupos")
public class ClaseDC extends Clase {

    @ManyToOne
    @ReferenceView("simple")
    @NoFrame
    private Carrera carrera;

}





