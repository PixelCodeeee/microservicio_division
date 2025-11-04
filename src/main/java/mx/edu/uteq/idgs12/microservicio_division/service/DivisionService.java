package mx.edu.uteq.idgs12.microservicio_division.service;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionDTO;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    public DivisionDTO crearDivision(DivisionDTO divisionDTO) {
        Division division = new Division();
        division.setNombre(divisionDTO.getNombre());
        division.setActivo(divisionDTO.getActivo() != null ? divisionDTO.getActivo() : true);
        
        Division divisionGuardada = divisionRepository.save(division);
        
        return convertirADTO(divisionGuardada);
    }

    public List<DivisionDTO> obtenerTodasDivisiones() {
        List<Division> divisiones = divisionRepository.findAll();
        return divisiones.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }


    public DivisionDTO obtenerDivisionPorId(Long id) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada con id: " + id));
        return convertirADTO(division);
    }

    public DivisionDTO actualizarDivision(Long id, DivisionDTO divisionDTO) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada con id: " + id));
        
        division.setNombre(divisionDTO.getNombre());
        division.setActivo(divisionDTO.getActivo() != null ? divisionDTO.getActivo() : division.getActivo());
        Division divisionActualizada = divisionRepository.save(division);
        
        return convertirADTO(divisionActualizada);
    }

    public void eliminarDivision(Long id) {
        if (!divisionRepository.existsById(id)) {
            throw new RuntimeException("División no encontrada con id: " + id);
        }
        divisionRepository.deleteById(id);
    }


    private DivisionDTO convertirADTO(Division division) {
        DivisionDTO dto = new DivisionDTO();
        dto.setId(division.getId());
        dto.setNombre(division.getNombre());
        dto.setActivo(division.getActivo() != null ? division.getActivo() : true);
        return dto;
    }
}