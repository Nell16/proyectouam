package com.uam.proyectouam.usuarios;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;

@Entity
@EntityValidator(
        value = com.uam.proyectouam.validator.GestionPermisosValidator.class,
        properties = {
                @PropertyValue(name = "entidad", value = "Usuario")
        }
)
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Usuario.all",
                query = "select e from Usuario e"),

        @NamedQuery(name = "Usuario.findPassword",
                query = "select e from Usuario e " +
                        "where e.cif = ?1 and e.password = ?2")
})
@Tab(properties = "cif, nombreCompleto, correo, tipoUsuario, rol")
public abstract class Usuario extends Identifiable {

    @Column(length = 30, unique = true)
    @Required
    private String cif;

    @Column(length = 30)
    @Required
    private String primerNombre;

    @Column(length = 30)
    private String segundoNombre; // Puede no ser obligatorio

    @Column(length = 30)
    @Required
    private String primerApellido;

    @Column(length = 30)
    private String segundoApellido; // Puede no ser obligatorio

    @Column(length = 30, unique = true)
    @Required
    @EmailList
    private String correo;

    @Column(length = 30)
    @Required
    private String password;

    @Column(name = "tipo_usuario", length = 30)
    @ReadOnly
    private String tipoUsuario;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    @ReadOnly
    private Rol rol;

    @PrePersist
    protected void prePersist() {
        this.rol = determineRol();
        this.tipoUsuario = determineTipoUsuario();
    }

    protected abstract String determineTipoUsuario();

    protected abstract Rol determineRol();

    @Transient
    public String getNombreCompleto() {
        return (primerNombre != null ? primerNombre : "") + " " +
                (primerApellido != null ? primerApellido : "") + " " +
                (segundoNombre != null ? segundoNombre : "") + " " +
                (segundoApellido != null ? segundoApellido : "");
    }
}
