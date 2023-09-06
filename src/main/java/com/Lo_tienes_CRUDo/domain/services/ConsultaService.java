package com.Lo_tienes_CRUDo.domain.services;

import com.Lo_tienes_CRUDo.domain.models.Consulta;
import com.Lo_tienes_CRUDo.infrarepositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    private final ConsultaRepository ConsultaRepository;
    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository){
        this.ConsultaRepository = consultaRepository;
    }

    public List<Consulta> getConsult() {
        return ConsultaRepository.findAll();

    }

    public void newConsulta(Consulta consulta) {
        ConsultaRepository.save(consulta);

    }

    public void update(Long id, Consulta consulta) {
        Optional<Consulta> consultByID = (ConsultaRepository.findById(id));
        if(consultByID.isPresent()){
            Consulta consultExistente=consultByID.get();

            consultExistente.setFecha(consulta.getFecha());
            consultExistente.setTecnologia(consulta.getTecnologia());
            consultExistente.setDesarrollador(consulta.getDesarrollador());
            consultExistente.setLocalizacion(consulta.getLocalizacion());
            consultExistente.setComentario(consulta.getComentario());

            ConsultaRepository.save(consultExistente);
        }
    }


    public void deleteConsult(Long id, Consulta consulta) {
        boolean existe = ConsultaRepository.existsById(id);
        if (existe){
            ConsultaRepository.delete(consulta);
        }
    }
}
