package com.uam.proyectouam.model;

import javax.persistence.*;

import com.uam.proyectouam.herencia.Clase;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Table(name = "clase_dc")
@Getter
@Setter
@Tab(properties = "nombre, carrera.nombre, carrera.facultad.nombre")
public class ClaseDC extends Clase {

    @ManyToOne
    @ReferenceView("simple")
    @NoFrame
    private Carrera carrera;

}





