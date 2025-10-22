package mx.edu.uteq.idgs12.microservicio_division.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import mx.edu.uteq.idgs12.microservicio_division.repository.ProgramaEducativoRepository;

@Controller
public class ProgramaEducativoController {

    @Autowired
    private ProgramaEducativoRepository repo;

    @GetMapping(value="/api/ofertaAdmin", produces = "application/json")
    public @ResponseBody List<ProgramaEducativo> restOferta() {
        List<ProgramaEducativo> lista = repo.findAll();
        return lista;
    }

}
