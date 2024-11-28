package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.Tab;
import org.openxava.annotations.TextArea;
import org.openxava.annotations.View;
import org.openxava.model.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "facultad")
@Getter
@Setter
@Tab(properties = "nombre, descripcion")
public class Facultad extends Identifiable {

    @Required
    private String nombre;

    @TextArea
    private String descripcion;
}
