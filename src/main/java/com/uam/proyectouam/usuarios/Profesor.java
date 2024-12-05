package com.uam.proyectouam.usuarios;

import javax.persistence.*;

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
                @PropertyValue(name = "entidad", value = "Profesor")
        }
)
@Table(name = "profesor")
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
                "grupos { grupos }" +
                "clases { clasesProfesor }"
)
@Tab(properties = "cif, nombreCompleto, correo, nombresClases, nombresGrupos")
public class Profesor extends Usuario {



    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListAction("Collection.add")
    @Collapsed
    private Set<Grupo> grupos = new HashSet<>();


    @ManyToMany(mappedBy = "profesores")
    @Collapsed
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

    @Override
    protected String determineTipoUsuario() {
        return "Profesor";
    }

    @Override
    protected Rol determineRol() {
        return Rol.USUARIO;
    }
}
