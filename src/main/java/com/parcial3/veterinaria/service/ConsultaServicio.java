package com.parcial3.veterinaria.service;

import com.parcial3.veterinaria.entity.Consulta;
import com.parcial3.veterinaria.exeption.UserNotFoundException;
import com.parcial3.veterinaria.repository.ConsultaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServicio {
    private final ConsultaRepositorio consultaRepositorio;
    @Autowired
    public ConsultaServicio(ConsultaRepositorio consultaRepositorio) {
        this.consultaRepositorio = consultaRepositorio;
    }
    public Consulta addConsulta(Consulta consulta){
        return consultaRepositorio.save(consulta);
    }
    public List<Consulta> findAllConsultas(){
        return consultaRepositorio.findAll();
    }
    public Consulta updateConsulta(Consulta consulta){
        return consultaRepositorio.save(consulta);
    }
    public Consulta findConsultasById(Integer id){
        return consultaRepositorio.findConsultaById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    public void deleteConsulta(Integer id){
        consultaRepositorio.deleteConsultaById(id);
    }

}
