package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "profesor")
@Getter
@Setter
@View(name="simple",members="nombreCompleto")
@Tab(properties = "cif, nombreCompleto, correo")
public class Profesor extends Usuario {

}
