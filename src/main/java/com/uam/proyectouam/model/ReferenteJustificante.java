package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;
import org.openxava.model.Identifiable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "referente_justificante")
@Getter
@Setter
public class ReferenteJustificante extends Identifiable {

    @Column(length = 100)
    @Required
    private String nombre;

    @Column(length = 100)
    @Required
    @Stereotype("EMAIL")
    private String correo;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    @Required
    private String institucion;

    @Column(length = 500)
    private String motivoConstancia;

    @Temporal(TemporalType.DATE)
    @Required
    private Date fechaEmision;
}
