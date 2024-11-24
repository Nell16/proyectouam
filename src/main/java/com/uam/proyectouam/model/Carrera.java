package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.TextArea;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrera")
@Getter
@Setter
public class Carrera extends Identifiable {

    @Required
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Facultad facultad;

    @TextArea
    private String descripcion;

}

