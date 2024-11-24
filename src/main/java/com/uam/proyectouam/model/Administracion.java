package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "administracion")
@Getter @Setter
public class Administracion extends Usuario {
}
