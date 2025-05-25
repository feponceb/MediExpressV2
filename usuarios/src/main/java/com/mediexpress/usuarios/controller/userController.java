package com.mediexpress.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<user> obtenerUser(@PathVariable Long id){
        try{
            user User = UserService.getUser(id);
            return ResponseEntity.ok(User);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    //crear usuarios
    @PostMapping
    public ResponseEntity<user> saveUser(@RequestBody user User){
        return ResponseEntity.status(201).body(UserService.saveUser(User));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        UserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    

}
