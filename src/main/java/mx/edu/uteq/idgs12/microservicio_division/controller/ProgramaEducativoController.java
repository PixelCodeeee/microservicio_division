package mx.edu.uteq.idgs12.microservicio_division.controller;

import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoDTO;
import mx.edu.uteq.idgs12.microservicio_division.service.ProgramaEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas-educativos")
@CrossOrigin(origins = "*")
public class ProgramaEducativoController {

    @Autowired
    private ProgramaEducativoService programaEducativoService;

    /**
     * Crear un nuevo programa educativo
     * POST /api/programas-educativos
     */
    @PostMapping
    public ResponseEntity<ProgramaEducativoDTO> crearProgramaEducativo(@RequestBody ProgramaEducativoDTO dto) {
        try {
            ProgramaEducativoDTO nuevoPrograma = programaEducativoService.crearProgramaEducativo(dto);
            return new ResponseEntity<>(nuevoPrograma, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener todos los programas educativos
     * GET /api/programas-educativos
     */
    @GetMapping
    public ResponseEntity<List<ProgramaEducativoDTO>> obtenerTodosProgramas() {
        try {
            List<ProgramaEducativoDTO> programas = programaEducativoService.obtenerTodosProgramas();
            if (programas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(programas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener un programa educativo por ID
     * GET /api/programas-educativos/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProgramaEducativoDTO> obtenerProgramaPorId(@PathVariable Long id) {
        try {
            ProgramaEducativoDTO programa = programaEducativoService.obtenerProgramaPorId(id);
            return new ResponseEntity<>(programa, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener programas educativos por división
     * GET /api/programas-educativos/division/{divisionId}
     */
    @GetMapping("/division/{divisionId}")
    public ResponseEntity<List<ProgramaEducativoDTO>> obtenerProgramasPorDivision(@PathVariable Long divisionId) {
        try {
            List<ProgramaEducativoDTO> programas = programaEducativoService.obtenerProgramasPorDivision(divisionId);
            if (programas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(programas, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Actualizar un programa educativo
     * PUT /api/programas-educativos/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProgramaEducativoDTO> actualizarProgramaEducativo(
            @PathVariable Long id, 
            @RequestBody ProgramaEducativoDTO dto) {
        try {
            ProgramaEducativoDTO programaActualizado = programaEducativoService.actualizarProgramaEducativo(id, dto);
            return new ResponseEntity<>(programaActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Eliminar un programa educativo
     * DELETE /api/programas-educativos/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarProgramaEducativo(@PathVariable Long id) {
        try {
            programaEducativoService.eliminarProgramaEducativo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}