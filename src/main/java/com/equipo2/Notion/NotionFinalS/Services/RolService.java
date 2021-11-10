package com.equipo2.Notion.NotionFinalS.Services;

import com.equipo2.Notion.NotionFinalS.Entities.Rol;
import com.equipo2.Notion.NotionFinalS.Enums.RolNombre;
import com.equipo2.Notion.NotionFinalS.Repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RolService {
    //ATRIBUTOS
    @Autowired
    private RolRepository rolRepository;
    private static final String API_BASE="/api/rols";


    //CONSTRUCTORES

    /**
     * Constructor con parametros
     * @param rolRepository Repositorio de Rol
     */
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    //METODOS

    /**
     * Metodo que busca todos los rols en la base de datos
     * @return Lista de rols
     */
    public List<Rol> findAll(){
        return rolRepository.findAll();
    }

    /**
     * Metodo que busca un rol por id
     * @param id del rol
     * @return objeto Rol
     */
    public Rol findById(Long id){
        return rolRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    /**
     * Metodo que guarda un rol en la base de datos
     * @param rol objeto rol pasado por parametro
     * @return objeto rol guardado
     */
    public Rol save(Rol rol){
        return rolRepository.save(rol);
    }

    /**
     * Metodo que actualiza un rol guardado en la base de datos y modifica los datos
     * @param rol objeto rol pasado por parametro
     * @return objeto rol modificado
     * @throws NoSuchElementException sino lo encuentra lanza excepcion
     */
    public Rol update(Rol rol)throws NoSuchElementException{
        if(rolRepository.existsById(rol.getId())){
            return rolRepository.save(rol);
        }
        throw new NoSuchElementException("El rol con id "+ rol.getId()+" no existe");
    }

    /**
     * Metodo que elimina todos los rols de la base datos
     */
    public void deleteAll(){
        rolRepository.deleteAll();
    }

    /**
     * Metodo que elimina un rol de la base de datos por id
     * @param id del rol a eliminar
     * @throws NoSuchElementException si no lo encuentra lanza excepcion
     */
    public void deleleById(Long id) throws NoSuchElementException{
        if(rolRepository.existsById(id)){
            rolRepository.deleteById(id);
        }
        throw new NoSuchElementException("El rol que de sea eliminar con id"+ id+ " no existe");
    }

    /**
     * Metodo que comprueba si existe una rol pasando su id
     * @param id de la rol
     * @return true si existe y false si no existe
     */
    public boolean existByid(Long id) {
        return rolRepository.existsById(id);
    }

    /**
     * Metodo que busca un rol por nombre del rol
     * @param rolNombre enum de RolNombre
     * @return Optional de Rol
     */
    public Optional<Rol> findByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    //GETTER Y SETTER

    public RolRepository getRolRepository() {
        return rolRepository;
    }

}
