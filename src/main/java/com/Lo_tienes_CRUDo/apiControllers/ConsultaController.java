package com.Lo_tienes_CRUDo.apiControllers;

import com.Lo_tienes_CRUDo.domain.models.Consulta;
import com.Lo_tienes_CRUDo.domain.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/lo_tienes_crudo")

public class ConsultaController {
    private final ConsultaService consultaService;
    @Autowired
    public ConsultaController(ConsultaService consultaService) {

        this.consultaService = consultaService;
    }

    @GetMapping
    public List<Consulta> getConsultController(){
        return consultaService.getConsult();
    }

    @PostMapping
    public void createConsult(@RequestBody Consulta consulta){
        consultaService.newConsulta(consulta);
    }

    @PutMapping("/{id}")
    public void updateConsult(@PathVariable Long id, @RequestBody Consulta consulta){
        consultaService.update(id,consulta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, Consulta consulta){

        consultaService.deleteConsult(id, consulta);
    }
}