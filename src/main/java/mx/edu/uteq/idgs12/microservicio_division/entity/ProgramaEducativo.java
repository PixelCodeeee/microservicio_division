package mx.edu.uteq.idgs12.microservicio_division.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad Programa Educativo
 * Representa carreras/programas académicos
 * 
 * Relationship: Division (1) → ProgramaEducativo (N)
 * Many programs belong to one division
 */
@Data
@Entity
@Table(name = "programa_educativo")
public class ProgramaEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private Boolean activo = true;
    
    // Many-to-One: Many programs belong to one division
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;
}