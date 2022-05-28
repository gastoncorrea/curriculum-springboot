
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Usuario;
import java.util.List;


public interface UsuarioService {
    
    public void crearUsuario(Usuario usuario);
    
    public Usuario encontrarUnUsuario(Long id);
    
    public List<Usuario> consultarUsuarios();
    
    public void eliminarUnUsuario(Long id);
    
    public Usuario obternerUsuarioPorCredenciales(Usuario usuario);
    
    public Long obtenerIdConEmail(String email);
}
