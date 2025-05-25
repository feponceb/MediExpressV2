package com.mediexpress.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.usuarios.model.Usuario;
import com.mediexpress.usuarios.repository.UsuarioRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository UserRepository;

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
        UserRepository.deleteById(id);
    }

}
