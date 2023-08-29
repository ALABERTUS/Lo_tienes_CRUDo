package com.Lo_tienes_CRUDo.domain.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table

public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")


    private LocalDateTime fecha;
    private String tecnologia;
    private String desarrollador;
    private String localizacion;
    private String comentario;

    public Consulta(){
    }
    public Consulta(Long id, LocalDateTime fecha, String tecnologia, String desarrollador, String localizacion, String comentario) {
        this.id = id;
        this.fecha = fecha;
        this.tecnologia = tecnologia;
        this.desarrollador = desarrollador;
        this.localizacion = localizacion;
        this.comentario = comentario;
    }
    public Consulta(LocalDateTime fecha, String tecnologia, String desarrollador, String localizacion, String comentario) {
        this.fecha = fecha;
        this.tecnologia = tecnologia;
        this.desarrollador = desarrollador;
        this.localizacion = localizacion;
        this.comentario = comentario;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public LocalDateTime getFecha() {

        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {

        this.fecha = fecha;
    }

    public String getTecnologia() {

        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {

        this.tecnologia = tecnologia;
    }

    public String getDesarrollador() {

        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {

        this.desarrollador = desarrollador;
    }

    public String getLocalizacion() {

        return localizacion;
    }

    public void setLocalizacion(String localizacion) {

        this.localizacion = localizacion;
    }

    public String getComentario() {

        return comentario;
    }

    public void setComentario(String comentario) {

        this.comentario = comentario;
    }

}
