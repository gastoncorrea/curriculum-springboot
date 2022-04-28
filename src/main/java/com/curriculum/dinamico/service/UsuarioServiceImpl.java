
package com.curriculum.dinamico.service;

import com.curriculum.dinamico.model.Usuario;
import com.curriculum.dinamico.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository uRepository;

    @Override
    public void crearUsuario(Usuario usuario) {
        uRepository.save(usuario);
    }


    @Override
    public Usuario encontrarUnUsuario(Long id) {
        Usuario usuario = uRepository.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        List<Usuario> usuario = uRepository.findAll();
        return usuario;
    }

    @Override
    public void eliminarUnUsuario(Long id) {
        uRepository.deleteById(id);
    }
    
}
