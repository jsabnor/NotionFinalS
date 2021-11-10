package com.equipo2.Notion.NotionFinal.Entities;


import javax.persistence.*;
import java.util.List;

/**
 * Clase Usuario
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Entity
@Table(name = "usuarios")
public class Usuario {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer rol;

    //CONSTRUCTOR

    /**
     * Constructor sin parametros
     */
    public Usuario() {
    }

    /**
     * Cosntructor con parametros
     * @param username nombre de usuario
     * @param password password del usuario
     * @param email del usuario
     * @param rol del usuario
     */
    public Usuario(String username, String password, String email, Integer rol) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol= rol;
    }

    //METODOS

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                '}';
    }

    /**
     * Metodo toString
     * @return String con todos los datos de Usuario
     */



    //GETTER Y SETTER


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }


}
