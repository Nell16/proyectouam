package com.uam.proyectouam.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;

import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "clases_carrera")
@View(name = "ClasesCarreraVista", members = "carrera, clasesBasicas, clasesDC")
public class ClasesCarrera extends Identifiable {

    @ManyToOne
    @Required
    private Carrera carrera;  // Relación con la carrera

    @OneToMany(mappedBy = "clasesCarrera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClaseBasica> clasesBasicas;  // Relación con las clases básicas de la carrera

    @OneToMany(mappedBy = "clasesCarrera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClaseDC> clasesDC;  // Relación con las clases DC de la carrera

    @OneToMany(mappedBy = "clasesCarrera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Justificacion> justificaciones;
}


