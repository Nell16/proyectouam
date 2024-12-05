package com.uam.proyectouam.usuarios;

import com.uam.proyectouam.usuarios.Rol;
import com.uam.proyectouam.usuarios.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.EntityValidator;
import org.openxava.annotations.PropertyValue;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@EntityValidator(
        value = com.uam.proyectouam.validator.GestionPermisosValidator.class,
        properties = {
                @PropertyValue(name = "entidad", value = "Administracion")
        }
)
@Table(name = "administracion")
@Getter
@Setter
@View(members=
        "cif;" +
                "Estudiante [#" +
                "primerNombre, correo;" +
                "segundoNombre, password;" +
                "primerApellido, tipoUsuario;" +
                "segundoApellido, rol;" +
                "];"
)
@Tab(properties = "cif, nombreCompleto, correo")
public class Administracion extends Usuario {

    @Override
    protected String determineTipoUsuario() {
        return "Administrador";
    }

    @Override
    protected Rol determineRol() {
        return Rol.ADMINISTRADOR;
    }
}
