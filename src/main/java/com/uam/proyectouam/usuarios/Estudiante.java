package com.uam.proyectouam.usuarios;

import javax.persistence.*;

import com.uam.proyectouam.model.Carrera;
import com.uam.proyectouam.clases.Clase;
import com.uam.proyectouam.model.Grupo;
import lombok.*;
import org.openxava.annotations.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@EntityValidator(
        value = com.uam.proyectouam.validator.GestionPermisosValidator.class,
        properties = {
                @PropertyValue(name = "entidad", value = "Estudiante")
        }
)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "estudiante")
@Getter
@Setter
@View(members=
        "cif;" +
                "Estudiante [#" +
                "primerNombre, correo;" +
                "segundoNombre, password;" +
                "primerApellido, tipoUsuario;" +
                "segundoApellido, rol;" +
                "];" +
                "carrera { carrera }" +
                "clases { clasesEstudiante }" +
                "grupos { gruposEstudiante }"
)
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

    @Override
    protected String determineTipoUsuario() {
        return "Estudiante";
    }

    @Override
    protected Rol determineRol() {
        return Rol.USUARIO;
    }

}
