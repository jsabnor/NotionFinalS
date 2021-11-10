package com.equipo2.Notion.NotionFinal.Controllers;

import com.equipo2.Notion.NotionFinal.Entities.Articulo;
import com.equipo2.Notion.NotionFinal.Services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller Articulo.
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
public class ArticuloController {
    //ATRIBUTOS
    @Autowired
    private ArticuloService articuloService;
    private static final String API_BASE="/api/articulos";

    //CONTRUCTORES

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    //METODOS

    /**
     * Metodo que muestra todos los articulos de la base de datos
     * @return ResponseEntity OK y lista de articulos
     */
    @GetMapping(API_BASE+"/mostrar")
    public ResponseEntity<List<Articulo>> findAll(){
        return new ResponseEntity<>(articuloService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que muestra un articulo pasando su id
     * @param id del articulo
     * @return ResponseEntity OK si existe y NOT FOUND si no existe
     */
    @GetMapping(API_BASE+"/mostrar/{id}")
    public ResponseEntity<Articulo> findById(@PathVariable Long id){
        if(articuloService.existByid(id)){
            return new ResponseEntity<>(articuloService.findById(id), HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Metodo que crea un articulo en la base de datos
     * @param articulo objeto articulo pasado por el body
     * @return ResponseEntity CREATED y el articulo creado
     */
    @PostMapping(API_BASE+"/crear")
    public ResponseEntity<Articulo> save(@RequestBody Articulo articulo){
        return new ResponseEntity<>(articuloService.save(articulo), HttpStatus.CREATED);
    }

    /**
     * Metodo que actualiza un articulo de la base de datos
     * @param articulo objeto articulo con los atributos a modificar
     * @return ResponseEntity CREATED si lo crea y existia en la base de datos, o BAD_REQUEST
     * si no exite en la base de datos
     */
    @PutMapping(API_BASE+"/modificar")
    public ResponseEntity<Articulo> update(@RequestBody Articulo articulo){
        if(articuloService.existByid(articulo.getId())){
            return new ResponseEntity<>(articuloService.save(articulo), HttpStatus.CREATED);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Metodo que elimina todos los articulos de la base de datos
     * @return Response Entity NO_ONTENT
     */
    @DeleteMapping(API_BASE+"/eliminar")
    public ResponseEntity<Articulo> deleteAll(){
        articuloService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Metodo que elimina un articulo de la base de datos pasada el id por parametro
     * @param id del articulo
     * @return ResponseEntity NO_CONTENT si lo borra y un NOT_FOUND si no existe en el base de datos
     */
    @DeleteMapping(API_BASE+"/eliminar/{id}")
    public ResponseEntity<Articulo> deleteById(@PathVariable Long id){
        if(articuloService.existByid(id)){
            articuloService.deleleById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //GETTER Y SETTER

    public ArticuloService getArticuloService() {
        return articuloService;
    }
}
