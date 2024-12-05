package com.uam.proyectouam.solicitud;

import javax.persistence.*;

import com.uam.proyectouam.usuarios.Usuario;
import lombok.*;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

@Entity
@Table(name = "imagenes_adjuntas")
@Getter
@Setter
//aqui hace falta un tab y anotaciones para estetica
public class ImagenesAdjuntas extends Identifiable {

    @ManyToOne
    @Collapsed
    @JoinColumn(name = "justificacion_id", nullable = false)
    private Justificacion justificacion;

    @File
    @Column(name = "documento", nullable = false)
    private byte[] documento;

    @Hidden
    @Column(name = "nombre_documento", nullable = false, length = 255)
    private String nombreDocumento;

}

