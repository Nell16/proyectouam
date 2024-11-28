package com.uam.proyectouam.model;

import javax.persistence.*;

import lombok.*;
import org.openxava.annotations.Tab;

@Entity
@Getter
@Setter
@Table(name = "clase_basica")
@Tab(properties = "nombre, tipoClase")
public class ClaseBasica extends Clase {

    public String getTipoClase(){
        return new StringBuffer("Basica / Compartida")
                .toString();
    }
}






