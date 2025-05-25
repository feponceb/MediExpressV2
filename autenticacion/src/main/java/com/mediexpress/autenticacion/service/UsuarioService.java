package com.mediexpress.autenticacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mediexpress.autenticacion.model.Usuario;
import com.mediexpress.autenticacion.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //Registro de Usuarios
    public Usuario registrarUsuario(Usuario usuario) {
        // Validar si el RUT o correo ya existen
        if (usuarioRepository.findByRut(usuario.getRut()).isPresent()) {
            throw new RuntimeException("El RUT ya está registrado.");
        }

        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado.");
        }

        // Encriptar la contraseña antes de guardar
        String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptada);

        return usuarioRepository.save(usuario);
    }

    //Metodo Log in
    public Usuario login(String rut, String password) {
        Usuario usuario = usuarioRepository.findByRut(rut)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuario;
    }

}
