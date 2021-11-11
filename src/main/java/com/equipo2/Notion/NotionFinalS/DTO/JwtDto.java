package com.equipo2.Notion.NotionFinalS.DTO;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Clase JWTDTO
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
public class JwtDto {
    //ATRIBUTOS
    private String token;
    private String bearer="Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    //CONSTRUCTORES

    /**
     * Constuctor con parametros
     * @param token token
     * @param nombreUsuario nombre de usuario
     * @param authorities coleccion de authorities
     */
    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }

    //METODOS

    //GETTER Y SETTER

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
