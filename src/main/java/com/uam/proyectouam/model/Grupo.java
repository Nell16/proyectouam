package com.uam.proyectouam.model;

import javax.persistence.*;

import com.uam.proyectouam.clases.Clase;
import com.uam.proyectouam.usuarios.Estudiante;
import com.uam.proyectouam.usuarios.Profesor;
import lombok.*;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@EntityValidator(
        value = com.uam.proyectouam.validator.GestionPermisosValidator.class,
        properties = {
                @PropertyValue(name = "entidad", value = "Grupo")
        }
)
@Getter
@Setter
@Table(name = "grupo")
//@View(members =
//                "nombreGrupo;" +
//                "clase { clase }" +
//                "docente { profesor }" +
//                "estudiantes { estudiantes }"
//)
@Tab(properties = "nombreGrupo, clase.nombre, profesor.nombreCompleto, nombresEstudiantes")
public class Grupo extends Identifiable {

    @Required
    private String nombreGrupo;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre")
    private Clase clase;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profesor profesor;


    @ManyToMany
    @JoinTable(
            name = "grupo_estudiante",
            joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private Set<Estudiante> estudiantes = new HashSet<>();

    @Transient
    public String getNombresEstudiantes() {
        if (estudiantes == null || estudiantes.isEmpty()) return "Sin estudiantes";
        return estudiantes.stream()
                .map(Estudiante::getNombreCompleto)
                .collect(Collectors.joining(", "));
    }
}
