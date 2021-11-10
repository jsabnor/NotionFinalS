package com.equipo2.Notion.NotionFinalS.Repositories;

import com.equipo2.Notion.NotionFinalS.Entities.Rol;
import com.equipo2.Notion.NotionFinalS.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface rol hereda de JPARepository para las funciones CRUD
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
