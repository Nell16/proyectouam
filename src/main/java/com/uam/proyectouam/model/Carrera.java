package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "carrera")
@View(name = "simple", members = "nombre, facultad.nombre, nombresClasesDC, nombresEstudiantes")
@Tab(properties ="nombre, facultad.nombre, nombresClasesDC, nombresEstudiantes")
public class Carrera extends Identifiable {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @ManyToOne
    @DescriptionsList(descriptionProperties = "nombre")
    private Facultad facultad;

    @ManyToMany
    @JoinTable(
            name = "carrera_claseDC", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "carrera_id"), // Columna para Carrera
            inverseJoinColumns = @JoinColumn(name = "claseDC_id") // Columna para ClaseDC
    )
    private Set<ClaseDC> clasesDC = new HashSet<>();

    @Transient
    public String getNombresClasesDC() {
        if (clasesDC == null || clasesDC.isEmpty()) return "Sin clases";
        return clasesDC.stream()
                .map(ClaseDC::getNombre)
                .collect(Collectors.joining(", "));
    }

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListAction("Collection.add")
    private Set<Estudiante> estudiantes;

    @Transient
    public String getNombresEstudiantes() {
        if (estudiantes == null || estudiantes.isEmpty()) return "Sin Estudiantes";
        return estudiantes.stream()
                .map(Estudiante::getNombreCompleto)
                .collect(Collectors.joining(", "));
    }
}


