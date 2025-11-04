package mx.edu.uteq.idgs12.microservicio_division.controller;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionDTO;
import mx.edu.uteq.idgs12.microservicio_division.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisiones")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    /**
     * Microservicio 1: Crear una nueva división
     * POST /api/divisiones
     */
    @PostMapping
    public ResponseEntity<DivisionDTO> crearDivision(@RequestBody DivisionDTO divisionDTO) {
        try {
            DivisionDTO nuevaDivision = divisionService.crearDivision(divisionDTO);
            return new ResponseEntity<>(nuevaDivision, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Microservicio 2: Consultar todas las divisiones
     * GET /api/divisiones
     */
    @GetMapping
    public ResponseEntity<List<DivisionDTO>> obtenerTodasDivisiones() {
        try {
            List<DivisionDTO> divisiones = divisionService.obtenerTodasDivisiones();
            if (divisiones.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(divisiones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Consultar una división por ID
     * GET /api/divisiones/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<DivisionDTO> obtenerDivisionPorId(@PathVariable Long id) {
        try {
            DivisionDTO division = divisionService.obtenerDivisionPorId(id);
            return new ResponseEntity<>(division, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Actualizar una división existente
     * PUT /api/divisiones/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<DivisionDTO> actualizarDivision(@PathVariable Long id, 
                                                           @RequestBody DivisionDTO divisionDTO) {
        try {
            DivisionDTO divisionActualizada = divisionService.actualizarDivision(id, divisionDTO);
            return new ResponseEntity<>(divisionActualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Eliminar una división
     * DELETE /api/divisiones/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarDivision(@PathVariable Long id) {
        try {
            divisionService.eliminarDivision(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}