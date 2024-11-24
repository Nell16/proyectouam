package com.uam.proyectouam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesor")
@Getter
@Setter
public class Profesor extends Usuario {

}
