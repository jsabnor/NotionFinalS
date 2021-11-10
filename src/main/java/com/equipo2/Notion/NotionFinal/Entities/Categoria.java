package com.equipo2.Notion.NotionFinal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Categoria
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Entity
@Table(name = "categorias")
public class Categoria {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoria;

    //Relacion One to Many con Articulos
    //@JsonManagedReference
    //@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
    private List<Articulo> articulos=new ArrayList<>();

    //CONSTRUCTORES

    /**
     * Constructor vacio
     */
    public Categoria() {
    }

    /**
     * Constructor con parametros
     * @param categoria nombre de la categoria
     */
    public Categoria(String categoria) {
        this.categoria = categoria;
    }


    //METODOS
    /**
     * Metodo toString
     * @return String con todos los datos de Categoria
     */
    @Override
    public String toString() {
        return "Categoria{" +
                "categoria='" + categoria + '\'' +
                '}';
    }


    //GETTER Y SETTER


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
