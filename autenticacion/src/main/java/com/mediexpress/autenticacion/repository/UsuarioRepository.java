package com.mediexpress.autenticacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.autenticacion.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //localizadores rut y correo para service
    Optional<Usuario> findByRut(String rut);
    Optional<Usuario> findByCorreo(String correo);
    
}
