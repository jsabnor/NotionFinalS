package com.equipo2.Notion.NotionFinalS.Repositories;

import com.equipo2.Notion.NotionFinalS.Entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface articulo hereda de JPARepository para las funciones CRUD
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
