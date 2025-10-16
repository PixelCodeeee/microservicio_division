package mx.edu.uteq.idgs12.microservicio_division.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;

@Controller
public class DivisionController {

      @Autowired
    private DivisionRepository divRepo;

     @GetMapping(value="/api/divisionAdmin", produces = "application/json")
    public @ResponseBody List<Division> restDivision() {
        List<Division> lista = divRepo.findAll();
        return lista;
    }
}
