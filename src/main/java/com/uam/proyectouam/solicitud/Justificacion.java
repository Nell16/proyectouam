package com.uam.proyectouam.solicitud;

import javax.persistence.*;

import com.uam.proyectouam.usuarios.Usuario;
import com.uam.proyectouam.calculators.CurrentDateCalculator; // Importa el calculador
import lombok.*;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import java.util.*;

@Entity
@Table(name = "justificacion")
@Getter
@Setter
//@View(members =
//                "fechaSolicitud, estado;" +
//                "descripcion { descripcion }" +
//                "solicitante { usuario }" +
//                "emitor { referentesJustificantes }" +
//                "adjunto { imagenesAdjuntas }"
//)
@Tab(properties = "fechaSolicitud, estado, descripcion, usuario.nombreCompleto")
public class Justificacion extends Identifiable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_solicitud", nullable = false)
    @ReadOnly
    @DefaultValueCalculator(CurrentDateCalculator.class) // Fecha predeterminada
    private Date fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    @ReadOnly
    private EstadoJustificacion estado;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "justificacion_referente",
            joinColumns = @JoinColumn(name = "justificacion_id"),
            inverseJoinColumns = @JoinColumn(name = "referente_id")
    )
    private List<ReferenteJustificante> referentesJustificantes = new ArrayList<>();

    @OneToMany(mappedBy = "justificacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenesAdjuntas> imagenesAdjuntas = new ArrayList<>();

    @PrePersist
    private void prePersist() {
        this.estado = EstadoJustificacion.PENDIENTE;
        if (this.fechaSolicitud == null) {
            this.fechaSolicitud = new Date();
        }
    }



    // Metodo INCOMPLETO falta por configurar :(
    private void enviarCorreo(String asunto, String mensaje) {
        String destinatario = usuario.getCorreo();
        System.out.println("Enviando correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
    }
}
