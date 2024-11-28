package com.uam.proyectouam.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;

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


