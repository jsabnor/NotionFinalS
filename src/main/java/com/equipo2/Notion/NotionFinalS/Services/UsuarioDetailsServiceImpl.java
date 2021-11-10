package com.equipo2.Notion.NotionFinalS.Services;

import com.equipo2.Notion.NotionFinalS.Entities.Usuario;
import com.equipo2.Notion.NotionFinalS.Entities.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Clase UsuarioDetailsServiceImpl nos devolvera un objeto UsuarioPrincipal
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario=usuarioService.findByUsername(username).get();
        return UsuarioPrincipal.build(usuario);
    }
}
