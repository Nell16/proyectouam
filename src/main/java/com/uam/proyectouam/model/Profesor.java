package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.util.List;

@Entity  // Esta clase será gestionada como una entidad por OpenXava
@View(name = "VistaEstudiante", members = "nombreUsuario, emailUsuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "profesor")
@Getter
@Setter
public class Profesor extends Usuario {

}
