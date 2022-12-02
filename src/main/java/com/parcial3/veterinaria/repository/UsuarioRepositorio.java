package com.parcial3.veterinaria.repository;

import com.parcial3.veterinaria.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
    Usuario getUsuarioByUsername(@Param("username") String username);
}
