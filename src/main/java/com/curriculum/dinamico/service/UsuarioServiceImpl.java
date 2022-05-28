
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

    @Override
    public Usuario obternerUsuarioPorCredenciales(Usuario usuario) {
        
       List <Usuario> listaUsuario = uRepository.findAll();
       Usuario encontrarUsuario = null;
       
       for(Usuario us : listaUsuario){
            if(usuario.getEmail().equals(us.getEmail()) && usuario.getPassword().equals(us.getPassword())){
               encontrarUsuario = us;
            }else{
                return null;
            }            
        }
        return encontrarUsuario;
    }

    @Override
    public Long obtenerIdConEmail(String email) {
        List<Usuario> listaUsuario = uRepository.findAll();
        Long idUsuario = null;
        
        for(Usuario us : listaUsuario){
            if(us.getEmail().equals(email)){
                idUsuario = us.getIdusuario();
                
            }
        }
        return idUsuario;
    }
    
}
