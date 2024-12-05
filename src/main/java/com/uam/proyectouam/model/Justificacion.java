package com.uam.proyectouam.model;

import javax.persistence.*;


import lombok.*;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import java.util.*;

@Entity
@Table(name = "justificacion")
@Getter
@Setter
@Tab(properties = "fechaSolicitud, estado, descripcion, usuario.nombreCompleto")
public class Justificacion extends Identifiable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_solicitud", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "referente_justificante_id")
    private ReferenteJustificante referenteJustificante;

    @OneToMany(mappedBy = "justificacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenesAdjuntas> imagenesAdjuntas = new ArrayList<>();

    @PrePersist
    private void prePersist() {
        this.estado = EstadoJustificacion.PENDIENTE;
        this.fechaSolicitud = new Date();
    }


    //Metodo
    private void enviarCorreo(String asunto, String mensaje) {
        String destinatario = usuario.getCorreo();
        System.out.println("Enviando correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
    }
}