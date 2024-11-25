package com.uam.proyectouam.model;

import javax.persistence.*;

import com.uam.proyectouam.herencia.EstadoJustificacion;
import org.openxava.annotations.*;
import lombok.*;
import org.openxava.model.Identifiable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "justificacion")
@Getter
@Setter
public class Justificacion extends Identifiable {


}
