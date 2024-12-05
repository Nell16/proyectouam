package com.uam.proyectouam.model;

import org.openxava.annotations.LabelFormat;
import org.openxava.annotations.LabelFormatType;
import org.openxava.annotations.Required;

import com.uam.proyectouam.usuarios.Rol; // Importa el enum unificado

import javax.persistence.Column;

public class SignIn {

    @Required
    @Column(length = 30)
    @LabelFormat(LabelFormatType.SMALL)
    private String user;

    @Required
    @Column(length = 30)
    @LabelFormat(LabelFormatType.SMALL)
    private String password;

    private Rol rol; // Usamos el enum unificado

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
