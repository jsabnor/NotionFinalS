package com.equipo2.Notion.NotionFinalS.Entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    @ManyToMany
    @JoinTable(name="usuario_rol",
            joinColumns = @JoinColumn(name="id_usuario"),
            inverseJoinColumns =@JoinColumn(name="id_rol"))
    private Set<Rol> roles=new HashSet<>();

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
     */
    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //METODOS

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
