package com.parcial3.veterinaria.repository;

import com.parcial3.veterinaria.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsultaRepositorio extends JpaRepository<Consulta, Integer> {
    void deleteConsultaById(Integer id);

    Optional<Consulta> findConsultaById(Integer id);
}
