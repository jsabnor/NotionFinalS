package com.equipo2.Notion.NotionFinal.Controllers;

import com.equipo2.Notion.NotionFinal.Entities.Usuario;
import com.equipo2.Notion.NotionFinal.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller Usuario.
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
public class UsuarioController {
    //ATRIBUTOS
    @Autowired
    private UsuarioService usuarioService;
    private static final String API_BASE="/api/usuarios";

    //CONTRUCTORES

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //METODOS

    /**
     * Metodo que muestra todos los usuarios de la base de datos
     * @return ResponseEntity OK y lista de usuarios
     */
    @GetMapping(API_BASE+"/mostrar")
    public ResponseEntity<List<Usuario>> findAll(){
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que muestra un usuario pasando su id
     * @param id del usuario
     * @return ResponseEntity OK si existe y NOT FOUND si no existe
     */
    @GetMapping(API_BASE+"/mostrar/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        if(usuarioService.existByid(id)){
            return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Metodo que crea un usuario en la base de datos
     * @param usuario objeto usuario pasado por el body
     * @return ResponseEntity CREATED y el usuario creado
     */
    @PostMapping(API_BASE+"/crear")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    /**
     * Metodo que actualiza un usuario de la base de datos
     * @param usuario objeto usuario con los atributos a modificar
     * @return ResponseEntity CREATED si lo crea y existia en la base de datos, o BAD_REQUEST
     * si no exite en la base de datos
     */
    @PutMapping(API_BASE+"/modificar")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
        if(usuarioService.existByid(usuario.getId())){
            return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Metodo que elimina todos los usuarios de la base de datos
     * @return Response Entity NO_ONTENT
     */
    @DeleteMapping(API_BASE+"/eliminar")
    public ResponseEntity<Usuario> deleteAll(){
        usuarioService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Metodo que elimina un usuario de la base de datos pasada el id por parametro
     * @param id del usuario
     * @return ResponseEntity NO_CONTENT si lo borra y un NOT_FOUND si no existe en el base de datos
     */
    @DeleteMapping(API_BASE+"/eliminar/{id}")
    public ResponseEntity<Usuario> deleteById(@PathVariable Long id){
        if(usuarioService.existByid(id)){
            usuarioService.deleleById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //GETTER Y SETTER

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

}
