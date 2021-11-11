package com.equipo2.Notion.NotionFinalS.DTO;

import com.sun.istack.NotNull;

import java.util.HashSet;
import java.util.Set;
/**
 * Clase Nuevousuario
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
public class NuevoUsuario {
    //ATRIBUTOS
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private Set<String> roles=new HashSet<>();

    //CONTRUCTORES

    //METODOS

    //GETTER Y SETTER

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
