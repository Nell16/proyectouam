package com.uam.proyectouam.herencia;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;

@MappedSuperclass
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Tab(properties = "cif, nombre, correo")
public abstract class Usuario extends Identifiable {

    @Column(length = 50, unique = true)
    @Required
    private String cif;

    @Column(length = 100)
    @Required
    private String primerNombre;

    @Column(length = 100)
    @Required
    private String segundoNombre;

    @Column(length = 100)
    @Required
    private String primerApellido;

    @Column(length = 100)
    @Required
    private String segundoApellido;

    @Column(length = 100, unique = true)
    @Required
    @EmailList
    @Stereotype("EMAIL")
    private String correo;

    @Column(length = 255)
    @Required
    @Stereotype("PASSWORD")
    private String password;

    public String getNombreCompleto() {
        return primerNombre + " " + primerApellido
                + " " + segundoNombre + " " + segundoApellido;
    }
}
