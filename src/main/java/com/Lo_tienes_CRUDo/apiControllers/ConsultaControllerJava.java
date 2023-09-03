package com.Lo_tienes_CRUDo.apiControllers;

import com.Lo_tienes_CRUDo.domain.models.Consulta;
import com.Lo_tienes_CRUDo.domain.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/consultas")
public class ConsultaControllerJava {
    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getConsultasController() {
        return consultaService.getConsultas();
    }

    @PostMapping
    public void postConsultasController(@RequestBody Consulta nuevaConsulta){
        consultaService.addConsulta(nuevaConsulta);
    }

    @PutMapping("/{id}")
    public void putConsultasController(@PathVariable Long id, @RequestBody Consulta consulta){
        consultaService.updateConsulta(id, consulta);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultaController(@PathVariable Long id, Consulta consulta) {
        consultaService.deleteConsulta(id, consulta);
    }

}
