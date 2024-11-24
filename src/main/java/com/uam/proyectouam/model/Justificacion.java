package com.uam.proyectouam.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "justificacion")
@Getter
@Setter
public class Justificacion extends Identifiable {

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Estudiante estudiante;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    // Relación con ClasesCarrera
    @ManyToOne
    @JoinColumn(name = "clase_carrera_id")  // Relación con ClasesCarrera
    private ClasesCarrera clasesCarrera;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private Grupo grupo;

    // Relación con ImagenesAdjuntas
    @OneToMany(mappedBy = "justificacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ImagenesAdjuntas> documentosAdjuntos;

    @ManyToOne
    @JoinColumn(name = "referente_justificador_id", nullable = false)
    private ReferenteJustificante referenteJustificante;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_justificacion", nullable = false)
    private EstadoJustificacion estadoJustificacion;

    @ManyToOne
    @JoinColumn(name = "administracion_id", nullable = false)
    private Administracion administracion;

    // Inicializar el estado de la justificación como "Pendiente" por defecto.
    @PrePersist
    public void prePersist() {
        if (estadoJustificacion == null) {
            estadoJustificacion = EstadoJustificacion.PENDIENTE; // Establece el estado como Pendiente
        }
    }
}
