package com.mads.springsecuritymads.service;

import com.mads.springsecuritymads.model.Usuario;
import com.mads.springsecuritymads.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> todosUsuarios(){
        List<Usuario> todos = new ArrayList<>();
        for (Usuario u : repository.findAll()){
            todos.add(u);
        }
        return todos;
    }

    public Usuario findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Usuario findByUsername(String username){
        return repository.findByUsername(username).orElse(null);
    }


}
