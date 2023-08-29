package com.Lo_tienes_CRUDo.domain.services;

import com.Lo_tienes_CRUDo.domain.models.Consulta;
import com.Lo_tienes_CRUDo.infra.resositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> getConsult() {
        return consultaRepository.findAll();

    }

    public void newConsulta(Consulta consulta) {
        consultaRepository.save(consulta);

    }

    public void update(Long id, Consulta consulta) {
        Optional<Consulta> consultByID = (consultaRepository.findById(id));
        if(consultByID.isPresent()){
            Consulta consultExistente=consultByID.get();

            consultExistente.setFecha(consulta.getFecha());
            consultExistente.setTecnologia(consulta.getTecnologia());
            consultExistente.setDesarrollador(consulta.getDesarrollador());
            consultExistente.setLocalizacion(consulta.getLocalizacion());
            consultExistente.setComentario(consulta.getComentario());

            consultaRepository.save(consultExistente);
        }
    }


    public void deleteConsult(Long id, Consulta consulta) {
        boolean existe = consultaRepository.existsById(id);
        if (existe){
            consultaRepository.delete(consulta);
        }
    }
}
