package com.equipo2.Notion.NotionFinal.Controllers;

import com.equipo2.Notion.NotionFinal.Entities.Categoria;
import com.equipo2.Notion.NotionFinal.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller Categoria.
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*",
        methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},
        allowedHeaders = {"*"})
public class CategoriaController {
    //ATRIBUTOS
    @Autowired
    private CategoriaService categoriaService;
    private static final String API_BASE="/api/categorias";

    //CONTRUCTORES

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    //METODOS

    /**
     * Metodo que muestra todos los categorias de la base de datos
     * @return ResponseEntity OK y lista de categorias
     */
    @GetMapping(API_BASE+"/mostrar")
    public ResponseEntity<List<Categoria>> findAll(){
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que muestra un categoria pasando su id
     * @param id del categoria
     * @return ResponseEntity OK si existe y NOT FOUND si no existe
     */
    @GetMapping(API_BASE+"/mostrar/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        if(categoriaService.existByid(id)){
            return new ResponseEntity<>(categoriaService.findById(id), HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Metodo que crea un categoria en la base de datos
     * @param categoria objeto categoria pasado por el body
     * @return ResponseEntity CREATED y el categoria creado
     */
    @PostMapping(API_BASE+"/crear")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.save(categoria), HttpStatus.CREATED);
    }

    /**
     * Metodo que actualiza un categoria de la base de datos
     * @param categoria objeto categoria con los atributos a modificar
     * @return ResponseEntity CREATED si lo crea y existia en la base de datos, o BAD_REQUEST
     * si no exite en la base de datos
     */
    @PutMapping(API_BASE+"/modificar")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria){
        if(categoriaService.existByid(categoria.getId())){
            return new ResponseEntity<>(categoriaService.save(categoria), HttpStatus.CREATED);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Metodo que elimina todos los categorias de la base de datos
     * @return Response Entity NO_ONTENT
     */
    @DeleteMapping(API_BASE+"/eliminar")
    public ResponseEntity<Categoria> deleteAll(){
        categoriaService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Metodo que elimina un categoria de la base de datos pasada el id por parametro
     * @param id del categoria
     * @return ResponseEntity NO_CONTENT si lo borra y un NOT_FOUND si no existe en el base de datos
     */
    @DeleteMapping(API_BASE+"/eliminar/{id}")
    public ResponseEntity<Categoria> deleteById(@PathVariable Long id){
        if(categoriaService.existByid(id)){
            categoriaService.deleleById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //GETTER Y SETTER

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }
}
