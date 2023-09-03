package com.Lo_tienes_CRUDo.domain.services;

import com.Lo_tienes_CRUDo.domain.models.Consulta;
import com.Lo_tienes_CRUDo.infrarepositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getConsultas() {
        return consultaRepository.findAll();
    }

    public void addConsulta(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public void updateConsulta(long id, Consulta consultaActualizada) {
        Optional<Consulta> consultById = (consultaRepository.findById(id));

        if (consultById.isPresent()) {
            Consulta consultaExistente = consultById.get();

            consultaExistente.setComentario(consultaActualizada.getComentario());
            consultaExistente.setDesarrollador(consultaActualizada.getDesarrollador());
            consultaExistente.setLocalizacion(consultaActualizada.getLocalizacion());
            consultaExistente.setFecha(consultaActualizada.getFecha());
            consultaExistente.setTecnologia(consultaActualizada.getTecnologia());

            consultaRepository.save(consultaExistente);
        }
    }

    public void deleteConsulta(long id, Consulta borrar) {
        Optional<Consulta> consultById = (consultaRepository.findById(id));

        if (consultById.isPresent()) {
            consultaRepository.delete(borrar);
        }
    }
    }

