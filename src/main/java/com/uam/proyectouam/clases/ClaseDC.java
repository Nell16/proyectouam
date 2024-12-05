package com.uam.proyectouam.clases;

import javax.persistence.*;

import com.uam.proyectouam.model.Carrera;
import org.openxava.annotations.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@EntityValidator(
        value = com.uam.proyectouam.validator.GestionPermisosValidator.class,
        properties = {
                @PropertyValue(name = "entidad", value = "ClaseDC")
        }
)
@Table(name = "clase_dc")
@Getter
@Setter
//@View(members =
//                "nombre, descripcion, tipoClase;" +
//                "carreras { carreraClase }" +
//                "grupos { grupos }" +
//                "estudiantes { estudiantes }" +
//                "profesores { profesores }"
//)
@Tab(properties = "nombre, nombresCarreras, nombresGrupos, nombresEstudiantes, nombresProfesores")
public class ClaseDC extends Clase {

    @ManyToMany(mappedBy = "clasesDC")
    @Collapsed
    private Set<Carrera> carreraClase = new HashSet<>();

    @Transient
    public String getNombresCarreras() {
        if (carreraClase == null || carreraClase.isEmpty()) return "Sin carreras";
        return carreraClase.stream()
                .map(Carrera::getNombre)
                .collect(Collectors.joining(", "));
    }

    @PrePersist
    @PreUpdate
    private void establecerTipoClase() {
        this.setTipoClase("De Carrera");
    }
}






