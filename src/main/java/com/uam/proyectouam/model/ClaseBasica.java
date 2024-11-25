package com.uam.proyectouam.model;

import javax.persistence.*;

import com.uam.proyectouam.herencia.Clase;
import lombok.*;
import org.openxava.annotations.NoModify;
import org.openxava.annotations.ReadOnly;
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






