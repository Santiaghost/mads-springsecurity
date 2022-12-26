package com.mads.springsecuritymads.config;

import com.mads.springsecuritymads.model.Usuario;
import com.mads.springsecuritymads.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MyAuthenticationManager implements AuthenticationManager {


    private List<GrantedAuthority> authorities;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) {
        authorities = new ArrayList<>();
        Usuario u = usuarioService.findByUsername(authentication.getPrincipal().toString());
        User usr;
        if(u != null && u.getPassword().equals(authentication.getCredentials())){
            authorities.add(new SimpleGrantedAuthority(u.getPermisson()));
            usr = new User(authentication.getPrincipal().toString(), authentication.getCredentials().toString(), authorities);
            Authentication auth1 = new UsernamePasswordAuthenticationToken(u, authentication.getCredentials(), authorities);
            return auth1;
        }
        else{
            usr = new User(authentication.getPrincipal().toString(), authentication.getCredentials().toString(), authorities);
            Authentication auth2 = new UsernamePasswordAuthenticationToken(u, authentication.getCredentials());
            return auth2;
        }

    }


}

