package com.equipo2.Notion.NotionFinalS.DTO;

import com.sun.istack.NotNull;
/**
 * Clase LoginUsuario
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
public class LoginUsuario {

    //ATRIBUTOS
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String password;

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
}
