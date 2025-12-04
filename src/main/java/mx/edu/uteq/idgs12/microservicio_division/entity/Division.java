package mx.edu.uteq.idgs12.microservicio_division.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad División
 * Representa divisiones académicas de la universidad
 * 
 * Relationship: Division (1) → ProgramaEducativo (N)
 * One division has many programs
 */
@Data
@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "activo")
    private Boolean activo = true;
    
    // One-to-Many: One division has many programs
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaEducativo> programasEducativos = new ArrayList<>();
}