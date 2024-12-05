package com.uam.proyectouam.solicitud;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.EmailList;
import org.openxava.annotations.TextArea;
import org.openxava.annotations.View;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "referente_justificante")
@Getter
@Setter
@View(members =
        "Emitor [#" +
                "nombre, correo;" +
                "telefono, institucion;" +
                "fechaEmision;" +
                "];" +
                "Motivo { motivoConstancia }" +
                "justificaciones { justificaciones }"
)
public class ReferenteJustificante extends Identifiable {

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    @EmailList
    private String correo;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String institucion;

    @TextArea
    @Column(length = 500)
    private String motivoConstancia;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEmision;

    @ManyToMany(mappedBy = "referentesJustificantes")
    private List<Justificacion> justificaciones = new ArrayList<>();
}
