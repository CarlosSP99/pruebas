package com.example.pruebaExamen.service;


import com.example.pruebaExamen.model.Coche;
import com.example.pruebaExamen.model.Usuario;
import com.example.pruebaExamen.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void delteUserById(int id){
        usuarioRepository.deleteById(id);
    }

    public Usuario modifyUserById(int id, String edad){
        Optional<Usuario> cocheUsuario = usuarioRepository.findById(id);
        if (cocheUsuario.isPresent()) {
            Usuario usuario = cocheUsuario.get();
            usuario.setCspEdad(edad);
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("User not found with id: " + id); // Lanza una excepción si no se encuentra la canción
        }
    }

    public Usuario getUser(int id){
        Optional<Usuario> userOpt = usuarioRepository.findById(id);
        if (userOpt.isPresent()){
            return userOpt.get();
        }  else {
            throw new RuntimeException("User not found with id: " + id); // Lanza una excepción si no se encuentra la canción
        }
    }
}
