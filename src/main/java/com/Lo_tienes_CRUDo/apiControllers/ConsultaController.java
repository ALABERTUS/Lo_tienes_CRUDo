package com.Lo_tienes_CRUDo.apiControllers;

import com.Lo_tienes_CRUDo.domain.modail.Consulta;
import com.Lo_tienes_CRUDo.domain.sarvices.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/consultas")
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
    public void updateConsulta(@PathVariable Integer id, @RequestBody Consulta consulta){
        consultaService.update(id, consulta);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id, Consulta consulta){
        consultaService.deleteConsulta(id, consulta);
    }
}
