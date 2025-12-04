package mx.edu.uteq.idgs12.microservicio_division.service;

import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoDTO;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import mx.edu.uteq.idgs12.microservicio_division.repository.ProgramaEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramaEducativoService {

    @Autowired
    private ProgramaEducativoRepository programaEducativoRepository;
    
    @Autowired
    private DivisionRepository divisionRepository;

    /**
     * Crear un nuevo programa educativo
     */
    @Transactional
    public ProgramaEducativoDTO crearProgramaEducativo(ProgramaEducativoDTO dto) {
        // Verificar que la división existe
        Division division = divisionRepository.findById(dto.getDivisionId())
                .orElseThrow(() -> new RuntimeException("División no encontrada con id: " + dto.getDivisionId()));
        
        ProgramaEducativo programa = new ProgramaEducativo();
        programa.setNombre(dto.getNombre());
        programa.setActivo(dto.getActivo() != null ? dto.getActivo() : true);
        programa.setDivision(division);
        
        ProgramaEducativo programaGuardado = programaEducativoRepository.save(programa);
        
        return convertirADTO(programaGuardado);
    }

    /**
     * Obtener todos los programas educativos
     */
    public List<ProgramaEducativoDTO> obtenerTodosProgramas() {
        List<ProgramaEducativo> programas = programaEducativoRepository.findAll();
        return programas.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtener un programa educativo por ID
     */
    public ProgramaEducativoDTO obtenerProgramaPorId(Long id) {
        ProgramaEducativo programa = programaEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa educativo no encontrado con id: " + id));
        return convertirADTO(programa);
    }

    /**
     * Obtener programas educativos por división
     */
    public List<ProgramaEducativoDTO> obtenerProgramasPorDivision(Long divisionId) {
        // Verificar que la división existe
        if (!divisionRepository.existsById(divisionId)) {
            throw new RuntimeException("División no encontrada con id: " + divisionId);
        }
        
        Division division = divisionRepository.findById(divisionId)
                .orElseThrow(() -> new RuntimeException("División no encontrada"));
        
        return division.getProgramasEducativos().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    /**
     * Actualizar un programa educativo
     */
    @Transactional
    public ProgramaEducativoDTO actualizarProgramaEducativo(Long id, ProgramaEducativoDTO dto) {
        ProgramaEducativo programa = programaEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa educativo no encontrado con id: " + id));
        
        programa.setNombre(dto.getNombre());
        programa.setActivo(dto.getActivo() != null ? dto.getActivo() : programa.getActivo());
        
        // Si se cambia la división
        if (dto.getDivisionId() != null && !dto.getDivisionId().equals(programa.getDivision().getId())) {
            Division nuevaDivision = divisionRepository.findById(dto.getDivisionId())
                    .orElseThrow(() -> new RuntimeException("División no encontrada con id: " + dto.getDivisionId()));
            programa.setDivision(nuevaDivision);
        }
        
        ProgramaEducativo programaActualizado = programaEducativoRepository.save(programa);
        
        return convertirADTO(programaActualizado);
    }

    /**
     * Eliminar un programa educativo
     */
    @Transactional
    public void eliminarProgramaEducativo(Long id) {
        if (!programaEducativoRepository.existsById(id)) {
            throw new RuntimeException("Programa educativo no encontrado con id: " + id);
        }
        programaEducativoRepository.deleteById(id);
    }

    /**
     * Convertir entidad a DTO
     */
    private ProgramaEducativoDTO convertirADTO(ProgramaEducativo programa) {
        ProgramaEducativoDTO dto = new ProgramaEducativoDTO();
        dto.setId(programa.getId());
        dto.setNombre(programa.getNombre());
        dto.setActivo(programa.getActivo() != null ? programa.getActivo() : true);
        dto.setDivisionId(programa.getDivision().getId());
        return dto;
    }
}