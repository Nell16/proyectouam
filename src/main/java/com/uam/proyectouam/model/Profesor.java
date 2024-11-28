package com.uam.proyectouam.model;

import javax.persistence.*;
import lombok.*;
import org.openxava.annotations.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "profesor")
@Getter
@Setter
@View(name = "simple", members = "nombreCompleto; grupos { grupos }")
@Tab(properties = "cif, nombreCompleto, correo, nombresClases, nombresGrupos")
public class Profesor extends Usuario {

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListAction("Collection.add")
    private Set<Grupo> grupos = new HashSet<>();

    @ManyToMany(mappedBy = "profesores")
    private Set<Clase> clasesProfesor = new HashSet<>();

    @Transient
    public String getNombresClases() {
        if (clasesProfesor == null || clasesProfesor.isEmpty()) return "Sin clases";
        return clasesProfesor.stream()
                .map(Clase::getNombre)
                .collect(Collectors.joining(", "));
    }

    @Transient
    public String getNombresGrupos() {
        if (grupos == null || grupos.isEmpty()) return "Sin grupos";
        return grupos.stream()
                .map(Grupo::getNombreGrupo)
                .collect(Collectors.joining(", "));
    }
}
