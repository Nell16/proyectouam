package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import org.openxava.model.Identifiable;

import javax.persistence.*;

@MappedSuperclass
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Usuario extends Identifiable{

    @Column(length = 50, unique = true)
    @Required
    private String cif;

    @Column(length = 100)
    @Required
    private String nombre;

    @Column(length = 255)
    @Required
    @Stereotype("PASSWORD")
    private String password;

    @Column(length = 100, unique = true)
    @Required
    @Stereotype("EMAIL")
    private String correo;
}

