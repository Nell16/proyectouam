package com.uam.proyectouam.model;

import javax.persistence.*;

import com.uam.proyectouam.herencia.Clase;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "grupo")
public class Grupo extends Identifiable {

    @Required
    private String nombreGrupo;

    @ManyToOne(fetch = FetchType.LAZY)
    @NoFrame
    private Clase clase;

    @ManyToOne(fetch = FetchType.LAZY)
    @ReferenceView("simple")
    @NoFrame
    private Profesor profesor;
}


