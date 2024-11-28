package com.uam.proyectouam.model;

import javax.persistence.*;
import lombok.*;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Table(name = "clase")
@Tab(properties ="nombre, descripcion, nombresGrupos, nombresEstudiantes, nombresProfesores")
public abstract class Clase extends Identifiable {

    @Column(name = "nombre", nullable = false)
    @Required
    private String nombre;

    @TextArea
    private String descripcion;

    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grupo> grupos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "clase_estudiante",
            joinColumns = @JoinColumn(name = "clase_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private Set<Estudiante> estudiantes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "clase_profesor",
            joinColumns = @JoinColumn(name = "clase_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id")
    )
    private Set<Profesor> profesores = new HashSet<>();

    @Transient
    public String getNombresGrupos() {
        if (grupos == null || grupos.isEmpty()) return "Sin grupos";
        return grupos.stream()
                .map(Grupo::getNombreGrupo)
                .collect(Collectors.joining(", "));
    }

    @Transient
    public String getNombresEstudiantes() {
        if (estudiantes == null || estudiantes.isEmpty()) return "Sin estudiantes";
        return estudiantes.stream()
                .map(Estudiante::getNombreCompleto)
                .collect(Collectors.joining(", "));
    }

    @Transient
    public String getNombresProfesores() {
        if (profesores == null || profesores.isEmpty()) return "Sin profesores";
        return profesores.stream()
                .map(Profesor::getNombreCompleto)
                .collect(Collectors.joining(", "));
    }
}
