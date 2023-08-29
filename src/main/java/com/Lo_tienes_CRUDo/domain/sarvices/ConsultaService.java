package com.Lo_tienes_CRUDo.domain.sarvices;

import com.Lo_tienes_CRUDo.domain.modail.Consulta;
import com.Lo_tienes_CRUDo.infra.repositoris.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    @Autowired

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> getConsult() {
        return consultaRepository.findAll();
    }

    public void newConsulta(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public void update(Integer id, Consulta consulta) {
        Optional<Consulta> consultaByID = (consultaRepository.findById(id));

        if (consultaByID.isPresent()){
            Consulta consultaExistente = consultaByID.get();

            consultaExistente.setFecha(consulta.getFecha());
            consultaExistente.setTecnologia(consulta.getTecnologia());
            consultaExistente.setDesarrollador(consulta.getDesarrollador());
            consultaExistente.setLocalizacion(consulta.getLocalizacion());
            consultaExistente.setComentario(consulta.getComentario());

            consultaRepository.save(consultaExistente);
        }

    }

    public void deleteConsulta(Integer id, Consulta consulta) {
        boolean existe = consultaRepository.existsById(id);
        if (existe) {
            consultaRepository.delete(consulta);
        }
    }
}


