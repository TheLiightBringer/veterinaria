package com.parcial3.veterinaria.service;

import com.parcial3.veterinaria.entity.Usuario;
import com.parcial3.veterinaria.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUsuarioDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.getUsuarioByUsername(username);
        if (usuario == null){
            throw new UsernameNotFoundException("No existe el usuario con username: " + username);
        }
        return new MyUsuarioDetailsService(usuario, usuarioRepositorio);
    }
}
