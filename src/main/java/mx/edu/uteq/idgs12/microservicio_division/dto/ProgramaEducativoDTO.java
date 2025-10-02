package mx.edu.uteq.idgs12.microservicio_division.dto;

import lombok.Data;

@Data

public class ProgramaEducativoDTO {
    private Long id;
    private String nombre;
    private Boolean activo;
    private Long divisionId;
}

