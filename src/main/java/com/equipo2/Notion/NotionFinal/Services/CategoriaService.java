package com.equipo2.Notion.NotionFinal.Services;

import com.equipo2.Notion.NotionFinal.Entities.Categoria;
import com.equipo2.Notion.NotionFinal.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
/**
 * Service Categoria. Implementamos los metodos CRUD
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Service
public class CategoriaService {
    //ATRIBUTOS
    @Autowired
    private CategoriaRepository categoriaRepository;
    private static final String API_BASE="/api/categorias";


    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param categoriaRepository Repositorio de Categoria
     */
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    //METODOS

    /**
     * Metodo que busca todos los categorias en la base de datos
     * @return Lista de categorias
     */
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    /**
     * Metodo que busca un categoria por id
     * @param id del categoria
     * @return objeto Categoria
     */
    public Categoria findById(Long id){
        return categoriaRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    /**
     * Metodo que guarda un categoria en la base de datos
     * @param categoria objeto categoria pasado por parametro
     * @return objeto categoria guardado
     */
    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    /**
     * Metodo que actualiza un categoria guardado en la base de datos y modifica los datos
     * @param categoria objeto categoria pasado por parametro
     * @return objeto categoria modificado
     * @throws NoSuchElementException sino lo encuentra lanza excepcion
     */
    public Categoria update(Categoria categoria)throws NoSuchElementException{
        if(categoriaRepository.existsById(categoria.getId())){
            return categoriaRepository.save(categoria);
        }
        throw new NoSuchElementException("El categoria con id "+ categoria.getId()+" no existe");
    }

    /**
     * Metodo que elimina todos los categorias de la base datos
     */
    public void deleteAll(){
        categoriaRepository.deleteAll();
    }

    /**
     * Metodo que elimina un categoria de la base de datos por id
     * @param id del categoria a eliminar
     * @throws NoSuchElementException si no lo encuentra lanza excepcion
     */
    public void deleleById(Long id) throws NoSuchElementException{
        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        }
        throw new NoSuchElementException("El categoria que de sea eliminar con id"+ id+ " no existe");
    }

    /**
     * Metodo que comprueba si existe una categoria pasando su id
     * @param id de la categoria
     * @return true si existe y false si no existe
     */
    public boolean existByid(Long id) {
        return categoriaRepository.existsById(id);
    }

    //GETTER Y SETTER

    public CategoriaRepository getCategoriaRepository() {
        return categoriaRepository;
    }


}
