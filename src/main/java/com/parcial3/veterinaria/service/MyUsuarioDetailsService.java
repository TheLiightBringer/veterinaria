package com.parcial3.veterinaria.service;

import com.parcial3.veterinaria.entity.Usuario;
import com.parcial3.veterinaria.repository.UsuarioRepositorio;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUsuarioDetailsService implements UserDetails {
    private final Usuario usuario;
    private final UsuarioRepositorio usuarioRepositorio;

    public MyUsuarioDetailsService(Usuario usuario, UsuarioRepositorio usuarioRepositorio) {
        this.usuario = usuario;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }
    public Usuario getUsuario(){
        return usuario;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
