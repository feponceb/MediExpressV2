package com.mediexpress.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.usuarios.model.user;
import com.mediexpress.usuarios.service.userService;

@RestController
@RequestMapping("/api/Usuarios")
public class userController {
    @Autowired
    public userService UserService; 

    //agarra todos los usuarios
    @GetMapping
    public ResponseEntity<List<user>> obtenerUsers(){
        List<user> users = UserService.getUsers();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

}
