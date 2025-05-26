package com.mediexpress.autenticacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mediexpress.autenticacion.dto.gestorDeUsuarios;
import com.mediexpress.autenticacion.model.Usuario;
import com.mediexpress.autenticacion.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestTemplate restTemplate;

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

        //guardando
        Usuario saveUsuario1 = usuarioRepository.save(usuario); 

        //sending to gestion de usuarios
        gestorDeUsuarios dto = new gestorDeUsuarios(
        saveUsuario1.getRut(),
        saveUsuario1.getCorreo(),
        saveUsuario1.getNombre(),
        saveUsuario1.getPassword()
    );

    String urlGestion = "http://localhost:3245/api/usuarios";

    try {
        restTemplate.postForObject(urlGestion, dto, Void.class);
    } catch (Exception e) {
        System.err.println("Error al crear usuario en gestión: " + e.getMessage());
    }

    return saveUsuario1;
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
