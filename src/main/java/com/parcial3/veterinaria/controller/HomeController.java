package com.parcial3.veterinaria.controller;

import com.parcial3.veterinaria.entity.Usuario;
import com.parcial3.veterinaria.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "register";
    }
    @PostMapping("/register")
    public String registerProcess(@ModelAttribute("usuario") Usuario usuario){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuarioRepositorio.save(usuario);
        return "redirect:/login";
    }
}
