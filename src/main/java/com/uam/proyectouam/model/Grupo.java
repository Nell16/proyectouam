package com.uam.proyectouam.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "grupo")
public class Grupo extends Identifiable {

    @Column(length = 100)
    @Required
    private String nombre;
}


