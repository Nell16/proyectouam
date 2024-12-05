package com.uam.proyectouam.solicitud;

import javax.persistence.*;

import com.uam.proyectouam.usuarios.Usuario;
import lombok.*;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

@Entity
//@View(members=
//        "nombreDocumento;" +
//                "justificacion { justificacion }" +
//                "Adjunto { documento }"
//)
@Table(name = "imagenes_adjuntas")
@Getter
@Setter
//aqui hace falta un tab para ver los datos existentes en el list o capaz no haga falta xd
public class ImagenesAdjuntas extends Identifiable {

    @ManyToOne
    @JoinColumn(name = "justificacion_id", nullable = false)
    private Justificacion justificacion;

    @File
    @Column(name = "documento", length=32)
    private byte[] documento;

    @Column(name = "nombre_documento", nullable = false, length = 255)
    private String nombreDocumento;

}

