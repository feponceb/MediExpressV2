package com.mediexpress.autenticacion.controller;

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

import com.mediexpress.autenticacion.dto.LoginRequest;
import com.mediexpress.autenticacion.model.Usuario;
import com.mediexpress.autenticacion.service.UsuarioService;

@RestController
@RequestMapping("/api/log")
public class autorizacionController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);  
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Usuario usuario = usuarioService.login(loginRequest.getRut(), loginRequest.getPassword());
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/rut/{rut}")
    public ResponseEntity<Void> deleteByRut(@PathVariable String rut) {
        try {
            usuarioService.deleteByRut(rut);
            return ResponseEntity.noContent().build(); 
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); 
        }
    }

    //buscar todo
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsers(){
        List<Usuario> users = usuarioService.getUsers();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUser(@PathVariable Long id){
        try{
            Usuario User = usuarioService.getUser(id);
            return ResponseEntity.ok(User);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
