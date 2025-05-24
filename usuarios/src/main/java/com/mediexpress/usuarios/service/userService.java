package com.mediexpress.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.usuarios.model.user;
import com.mediexpress.usuarios.repository.userRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class userService {
    @Autowired
    private userRepository UserRepository;

    //traer todos los users
    public List<user> getUsers(){
        return UserRepository.findAll();
    }

    //buscar usuarios por id
    public user getUser(Long id){
        return UserRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }

    //crear usuarios
    public user saveUser(user User){
        return UserRepository.save(User);
    }

    //deletear
    public void deleteUser(Long id){
        UserRepository.deleteById(id);
    }

}
