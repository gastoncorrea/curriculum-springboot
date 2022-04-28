
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Usuario;
import com.curriculum.dinamico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired 
    private UsuarioService uService;
    
    @PostMapping("/usuario/save")
    public String crearUsuario(@RequestBody Usuario usuario){
        uService.crearUsuario(usuario);
        return "El usuario fue creado correctamente";
    }
}
