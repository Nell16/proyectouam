package com.uam.proyectouam.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;

@Entity
@Table(name = "imagenesAdjuntas")
@Getter
@Setter
public class ImagenesAdjuntas extends Identifiable {
    @ManyToOne
    @JoinColumn(name = "justificacion_id")
    private Justificacion justificacion;

    @Lob
    @Column(name = "documento", nullable = false)
    private byte[] documento;

    @Column(name = "nombre_documento")
    private String nombreDocumento;

    //Muy posible modificaremos esta clase de aca chicos
}
