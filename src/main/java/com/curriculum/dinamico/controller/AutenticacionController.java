
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Usuario;
import com.curriculum.dinamico.service.UsuarioService;
import com.curriculum.dinamico.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class AutenticacionController {
    
    @Autowired 
    private JwtUtil jwtUtil;
    
    @Autowired
    private UsuarioService usuarioS;
    
    @PostMapping("/autenticacion/persona")
    @ResponseBody
    public String encontrarPersona(@RequestBody Usuario usuario){
        
        Usuario encontrarUsuario = usuarioS.obternerUsuarioPorCredenciales(usuario);
       
       if(encontrarUsuario != null){
           String token = jwtUtil.create(String.valueOf(encontrarUsuario.getIdusuario()), encontrarUsuario.getEmail());
           return token;
       }else{
       return "FAIL";
       }
    }
    
    @GetMapping("/login/invitado")
    public String enviarInvitacion(){
        
        String token = jwtUtil.create(String.valueOf(43),"invitado");
        return token;
    }
    
}
