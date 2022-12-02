package com.parcial3.veterinaria.controller;

import com.parcial3.veterinaria.entity.Consulta;
import com.parcial3.veterinaria.service.ConsultaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@Controller
public class ConsultaController {
    private final ConsultaServicio consultaServicio;

    public ConsultaController(ConsultaServicio consultaServicio) {
        this.consultaServicio = consultaServicio;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Consulta>> getAllConsulta () {
        List<Consulta> consultas = consultaServicio.findAllConsultas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Consulta> getConsultaById (@PathVariable("id") Integer id) {
        Consulta consulta = consultaServicio.findConsultasById(id);
        return new ResponseEntity<>(consulta, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Consulta> addConsulta(@RequestBody Consulta consulta) {
        Consulta newConsulta = consultaServicio.addConsulta(consulta);
        return new ResponseEntity<>(newConsulta, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Consulta> updateConsulta(@RequestBody Consulta consulta) {
        Consulta updateConsulta = consultaServicio.updateConsulta(consulta);
        return new ResponseEntity<>(updateConsulta, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteConsulta(@PathVariable("id") Integer id) {
        consultaServicio.deleteConsulta(id);
        return new ResponseEntity<>(HttpStatus.OK);
}
}
