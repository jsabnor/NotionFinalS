package com.equipo2.Notion.NotionFinalS.Entities;

import com.equipo2.Notion.NotionFinalS.Enums.RolNombre;
import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * Clase Rol
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Entity
public class Rol {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    //CONSTRUCTORES

    /**
     * Constructor sin parametros
     */
    public Rol() {
    }

    /**
     * Constructor con parametros
     * @param rolNombre nombre del rol
     */
    public Rol(@NonNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    //METODOS

    //GETTER Y SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(@NonNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
