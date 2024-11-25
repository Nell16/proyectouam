package com.uam.proyectouam.model;

import javax.persistence.*;

import com.uam.proyectouam.herencia.Clase;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "clase_dc")
@View(name="simple",members="nombre, carrera")
//@Tab(properties = "nombre, carrera")
public class ClaseDC extends Clase {

    @ManyToOne
    @ReferenceView("simple")
    @NoFrame
    private Carrera carrera;

}





