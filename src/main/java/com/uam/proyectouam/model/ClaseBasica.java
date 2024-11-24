package com.uam.proyectouam.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

import java.util.List;

@Entity  // Esta clase será gestionada como una entidad por OpenXava
@View(name = "VistaClaseDC", members = "nombreClase, descripcion")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Table(name = "clase_basica")
public class ClaseBasica extends Clase {

    @ManyToOne
    @JoinColumn(name = "clases_carrera_id")  // Relación con ClasesCarrera
    private ClasesCarrera clasesCarrera;  // Relación con ClasesCarrera

}


