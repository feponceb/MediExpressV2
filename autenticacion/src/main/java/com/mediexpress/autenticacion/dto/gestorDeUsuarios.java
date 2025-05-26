package com.mediexpress.autenticacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class gestorDeUsuarios {
    private String rut;
    private String correo;
    private String nombre;
    private String password;

}
