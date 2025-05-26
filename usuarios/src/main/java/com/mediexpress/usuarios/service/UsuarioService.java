package com.mediexpress.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mediexpress.usuarios.model.Usuario;
import com.mediexpress.usuarios.repository.UsuarioRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository UserRepository;
    @Autowired
    private RestTemplate restTemplate;

    //traer todos los users
    public List<Usuario> getUsers(){
        return UserRepository.findAll();
    }

    //buscar usuarios por id
    public Usuario getUser(Long id){
        return UserRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }

    //crear usuarios
    public Usuario saveUser(Usuario User){
        return UserRepository.save(User);
    }

    //deletear
    public void deleteUser(Long id){
        //extraccion rut
        Usuario user = UserRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

        String rut = user.getRut();

        UserRepository.deleteById(id);

        String urlAutenticacion = "http://localhost:3345/api/log/rut/" + rut;
        try {
            restTemplate.delete(urlAutenticacion);
        } catch (Exception e) {
            System.err.println("Error al eliminar en autenticación: " + e.getMessage());
        }
    }

    //buscar por rut
    public Usuario findByRut(String rut) {
        Optional<Usuario> usuarioOpt = UserRepository.findByRut(rut);
        return usuarioOpt.orElse(null);
    }
}
