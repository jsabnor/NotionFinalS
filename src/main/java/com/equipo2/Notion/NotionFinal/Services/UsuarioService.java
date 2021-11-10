package com.equipo2.Notion.NotionFinal.Services;

import com.equipo2.Notion.NotionFinal.Entities.Usuario;
import com.equipo2.Notion.NotionFinal.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service Usuario. Implementamos los metodos CRUD
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Service
public class UsuarioService {
    //ATRIBUTOS
    @Autowired
    private final UsuarioRepository usuarioRepository;
    private static final String API_BASE="/api/usuarios";


    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param usuarioRepository Repositorio de Usuario
     */
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //METODOS

    /**
     * Metodo que busca todos los usuarios en la base de datos
     * @return Lista de usuarios
     */
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    /**
     * Metodo que busca un usuario por id
     * @param id del usuario
     * @return objeto Usuario
     */
    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    /**
     * Metodo que guarda un usuario en la base de datos
     * @param usuario objeto usuario pasado por parametro
     * @return objeto usuario guardado
     */
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    /**
     * Metodo que actualiza un usuario guardado en la base de datos y modifica los datos
     * @param usuario objeto usuario pasado por parametro
     * @return objeto usuario modificado
     * @throws NoSuchElementException sino lo encuentra lanza excepcion
     */
    public Usuario update(Usuario usuario)throws NoSuchElementException{
        if(usuarioRepository.existsById(usuario.getId())){
            return usuarioRepository.save(usuario);
        }
        throw new NoSuchElementException("El usuario con id "+ usuario.getId()+" no existe");
    }

    /**
     * Metodo que elimina todos los usuarios de la base datos
     */
    public void deleteAll(){
        usuarioRepository.deleteAll();
    }

    /**
     * Metodo que elimina un usuario de la base de datos por id
     * @param id del usuario a eliminar
     * @throws NoSuchElementException si no lo encuentra lanza excepcion
     */
    public void deleleById(Long id) throws NoSuchElementException{
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }
        throw new NoSuchElementException("El usuario que de sea eliminar con id"+ id+ " no existe");
    }

    /**
     * Metodo que comprueba si existe una usuario pasando su id
     * @param id del usuario
     * @return true si existe y false si no existe
     */
    public boolean existByid(Long id) {
        return usuarioRepository.existsById(id);
    }

    //GETTER Y SETTER

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

}
