package com.uam.proyectouam.validator;

import com.uam.proyectouam.usuarios.Rol;
import com.uam.proyectouam.usuarios.Usuario;
import org.openxava.jpa.XPersistence;
import org.openxava.util.Messages;
import org.openxava.util.Users;
import org.openxava.validators.IValidator;

public class GestionPermisosValidator implements IValidator {

    private String entidad;

    @Override
    public void validate(Messages messages) throws Exception {
        // Obtener el usuario actual desde OpenXava
        String username = Users.getCurrent();
        if (username == null) {
            messages.add("No se encontró el usuario autenticado.");
            return;
        }

        // Recuperar el usuario desde la base de datos
        Usuario usuario = XPersistence.getManager()
                .createQuery("SELECT u FROM Usuario u WHERE u.cif = :username", Usuario.class)
                .setParameter("username", username)
                .getSingleResult();

        if (usuario == null) {
            messages.add("Error interno: No se pudo encontrar información del usuario.");
            return;
        }

        // Validar permisos según el rol del usuario y la entidad
        if (("Clase".equals(entidad) ||
                "Carrera".equals(entidad) ||
                "Usuario".equals(entidad) ||
                "Profesor".equals(entidad) ||
                "Estudiante".equals(entidad) ||
                "Administracion".equals(entidad) ||
                "Grupo".equals(entidad) ||
                "Facultad".equals(entidad) ||
                "ClaseDC".equals(entidad) ||
                "ClaseBasica".equals(entidad) ||
                "Clase".equals(entidad)) && usuario.getRol() == Rol.USUARIO) {
            messages.add("No tiene permisos para gestionar la entidad: " + entidad);
        }

        // Si el rol es ADMINISTRADOR o la entidad no requiere restricción, se permite la operación o gestion por decirlo asi
        // Un ejemplo seria nuestra clase Justificacion y sus derivados que como tal no estan restringidas para la gestion de los USUARIOS
    }

    // Métodos para inyección de propiedades
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }
}
