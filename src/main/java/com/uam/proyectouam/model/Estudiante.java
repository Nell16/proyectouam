package com.uam.proyectouam.model;

import javax.persistence.*;
import lombok.*;
import org.openxava.annotations.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "estudiante")
@Getter
@Setter
@Tab(properties = "cif, nombreCompleto, correo, carrera.nombre, nombresClases, nombresGrupos")
public class Estudiante extends Usuario {

    @ManyToOne
    @DescriptionsList(descriptionProperties = "nombre")
    private Carrera carrera;

    @ManyToMany(mappedBy = "estudiantes")
    private Set<Clase> clasesEstudiante = new HashSet<>();

    @ManyToMany(mappedBy = "estudiantes")
    private Set<Grupo> gruposEstudiante = new HashSet<>();

    @Transient
    public String getNombresClases() {
        if (clasesEstudiante == null || clasesEstudiante.isEmpty()) return "Sin clases";
        return clasesEstudiante.stream()
                .map(Clase::getNombre)
                .collect(Collectors.joining(", "));
    }

    @Transient
    public String getNombresGrupos() {
        if (gruposEstudiante == null || gruposEstudiante.isEmpty()) return "Sin grupos";
        return gruposEstudiante.stream()
                .map(Grupo::getNombreGrupo)
                .collect(Collectors.joining(", "));
    }

    @PrePersist
    @PreUpdate
    private void establecerTipoUsuario() {
        this.setTipoUsuario("Estudiante");
    }
}
