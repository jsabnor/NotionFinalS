package com.equipo2.Notion.NotionFinalS.Entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que implementara los privilegios de usuario
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
public class UsuarioPrincipal implements UserDetails {
    //ATRIBUTOS
    private String username;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    //CONSTRUCTORES

    /**
     * Constructor con todos los atributos
     * @param username nombre de usuario
     * @param password contraseña del usuario
     * @param email del usuario
     * @param authorities coleccione de privilegios
     */
    public UsuarioPrincipal(String username, String password, String email, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    //METODOS

    /**
     * Metodo que asigna los privileg al usuario
     * @param usuario objeto usuario que le pasamos
     * @return objeto de usuario principal con los privilegios
     */
    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities=usuario.getRoles().stream()
                .map(rol-> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getUsername(),usuario.getPassword(),usuario.getEmail(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
