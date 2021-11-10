package com.equipo2.Notion.NotionFinal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Clase Articulo.
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Entity
@Table(name="articulos")
public class Articulo {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private LocalDate fechaCreacion;
    private String titulo;
    private String contenido;

    //Relacion Many To One
    //@JsonManagedReference
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    //CONSTRUCTORES

    /**
     * Constructor sin parametros
     */
    public Articulo() {
    }

    /**
     * Constructor con todos los parametros
     * @param autor usuario que crea el articulo
     * @param fechaCreacion fecha de creacion del articulo
     * @param titulo del articulo
     * @param contenido del articulo
     * @param categoria del articulo
     */
    public Articulo(String autor, LocalDate fechaCreacion, String titulo, String contenido, Categoria categoria) {
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.categoria= categoria;
    }

    //METODOS

    /**
     * Metodo toString
     * @return String con todos los datos de Articulo
     */
    @Override
    public String toString() {
        return "Articulo{" +
                "autor=" + autor +
                ", fechaCreacion=" + fechaCreacion +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", categoria=" + categoria +
                '}';
    }


    //GETTER Y SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
