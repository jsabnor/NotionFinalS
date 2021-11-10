package com.equipo2.Notion.NotionFinal.Services;

import com.equipo2.Notion.NotionFinal.Entities.Articulo;
import com.equipo2.Notion.NotionFinal.Repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service Articulo. Implementamos los metodos CRUD
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Service
public class ArticuloService {
    //ATRIBUTOS
    @Autowired
    private ArticuloRepository articuloRepository;

    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param articuloRepository Repositorio de Articulo
     */
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    //METODOS

    /**
     * Metodo que busca todos los articulos en la base de datos
     * @return Lista de articulos
     */
    public List<Articulo> findAll(){
        return articuloRepository.findAll();
    }

    /**
     * Metodo que busca un articulo por id
     * @param id del articulo
     * @return objeto Articulo
     */
    public Articulo findById(Long id){
        return articuloRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    /**
     * Metodo que guarda un articulo en la base de datos
     * @param articulo objeto articulo pasado por parametro
     * @return objeto articulo guardado
     */
    public Articulo save(Articulo articulo){
        return articuloRepository.save(articulo);
    }

    /**
     * Metodo que actualiza un articulo guardado en la base de datos y modifica los datos
     * @param articulo objeto articulo pasado por parametro
     * @return objeto articulo modificado
     * @throws NoSuchElementException sino lo encuentra lanza excepcion
     */
    public Articulo update(Articulo articulo)throws NoSuchElementException{
        if(articuloRepository.existsById(articulo.getId())){
            return articuloRepository.save(articulo);
        }
        throw new NoSuchElementException("El articulo con id "+ articulo.getId()+" no existe");
    }

    /**
     * Metodo que elimina todos los articulos de la base datos
     */
    public void deleteAll(){
        articuloRepository.deleteAll();
    }

    /**
     * Metodo que elimina un articulo de la base de datos por id
     * @param id del articulo a eliminar
     * @throws NoSuchElementException si no lo encuentra lanza excepcion
     */
    public void deleleById(Long id) throws NoSuchElementException{
        if(articuloRepository.existsById(id)){
            articuloRepository.deleteById(id);
        }
        throw new NoSuchElementException("El articulo que de sea eliminar con id"+ id+ " no existe");
    }

    /**
     * Metodo que comprueba si existe un articulo pasando su id
     * @param id del articulo
     * @return true si existe y false si no existe
     */
    public Boolean existByid(Long id){
       return articuloRepository.existsById(id);
    }

    //GETTER Y SETTER

    public ArticuloRepository getArticuloRepository() {
        return articuloRepository;
    }
}
