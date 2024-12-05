package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@EntityValidator(
        value = com.uam.proyectouam.validator.GestionPermisosValidator.class,
        properties = {
                @PropertyValue(name = "entidad", value = "Facultad")
        }
)
@Table(name = "facultad")
@Getter
@Setter
@Tab(properties = "nombre, descripcion, nombresCarreras")
public class Facultad extends Identifiable {

    @Required
    private String nombre;

    @TextArea
    private String descripcion;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListAction("Collection.add")
    private Set<Carrera> carreras;

    @Transient
    public String getNombresCarreras() {
        if (carreras == null || carreras.isEmpty()) return "Sin carreras";
        return carreras.stream()
                .map(Carrera::getNombre)
                .collect(Collectors.joining(", "));
    }


}
