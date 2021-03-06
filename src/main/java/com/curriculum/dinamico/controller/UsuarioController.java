
package com.curriculum.dinamico.controller;

import com.curriculum.dinamico.model.Usuario;
import com.curriculum.dinamico.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired 
    private UsuarioService uService;
    
    @PostMapping("/save")
    public String crearUsuario(@RequestBody Usuario usuario){
        uService.crearUsuario(usuario);
        return "El usuario fue creado correctamente";
    }
    
    @GetMapping("/consultar")
    public List<Usuario> traerUsuarios(){
        return uService.consultarUsuarios();
    }
    
    @DeleteMapping("/delete/{id}")
    public String borrarUsuario(@PathVariable Long id){
        uService.eliminarUnUsuario(id);
        return "El usuario fue eliminado correctamente";
    }
    
    @PutMapping ("/modificar/{id}")
    public String modificarUnUsuario(@PathVariable Long id, @RequestParam ("email") String nuevoEmail, @RequestParam ("password") String nuevoPassword){
        
        Usuario findUsuario = uService.encontrarUnUsuario(id);
        
        findUsuario.setEmail(nuevoEmail);
        findUsuario.setPassword(nuevoPassword);
        
        uService.crearUsuario(findUsuario);
        
        return "El usuario fue modificado correctamente";
    }
}
