package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.View;

import javax.persistence.*;

@Entity  // Esta clase será gestionada como una entidad por OpenXava
@View(name = "VistaEstudiante", members = "nombreUsuario, emailUsuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "administracion")
@Getter @Setter
public class Administracion extends Usuario {
}
