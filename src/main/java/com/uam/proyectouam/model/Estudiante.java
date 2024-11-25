package com.uam.proyectouam.model;

import com.uam.proyectouam.herencia.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="estudiante")
@Getter
@Setter
@Tab(properties = "cif, nombreCompleto, correo")
public class Estudiante extends Usuario {


}
