package com.uam.proyectouam.clases;

import javax.persistence.*;

import lombok.*;
import org.openxava.annotations.EntityValidator;
import org.openxava.annotations.PropertyValue;
import org.openxava.annotations.Tab;

@Entity
@EntityValidator(
        value = com.uam.proyectouam.validator.GestionPermisosValidator.class,
        properties = {
                @PropertyValue(name = "entidad", value = "ClaseBasica")
        }
)
@Getter
@Setter
@Table(name = "clase_basica")
@Tab(properties = "nombre, tipoClase, nombresGrupos, nombresEstudiantes, nombresProfesores")
public class ClaseBasica extends Clase {

    public String getTipoClase(){
        return new StringBuffer("Basica / Compartida")
                .toString();
    }

    @PrePersist
    @PreUpdate
    private void establecerTipoClase() {
        this.setTipoClase("Basica / Compartida");
    }
}





