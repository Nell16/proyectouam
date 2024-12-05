package com.uam.proyectouam.model;

import javax.persistence.*;
import lombok.*;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

@Entity
@Table(name = "imagenes_adjuntas")
@Getter
@Setter
public class ImagenesAdjuntas extends Identifiable {

    @ManyToOne
    @JoinColumn(name = "justificacion_id", nullable = false)
    private Justificacion justificacion;

    @File
    @Column(name = "documento", nullable = false)
    private byte[] documento;

    @Hidden
    @Column(name = "nombre_documento", nullable = false, length = 255)
    private String nombreDocumento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}

