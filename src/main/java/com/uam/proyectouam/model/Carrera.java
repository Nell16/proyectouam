package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrera")
@Getter
@Setter
public class Carrera extends Identifiable {

    @Required
    private String nombre;

    @ManyToOne
    @DescriptionsList
    private Facultad facultad;

    @TextArea
    private String descripcion;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private List<ClasesCarrera> clasesCarrera;
}

