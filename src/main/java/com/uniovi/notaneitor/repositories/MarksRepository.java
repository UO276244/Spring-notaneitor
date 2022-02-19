package com.uniovi.notaneitor.repositories;

import com.uniovi.notaneitor.entities.Mark;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository<Clase Entidad, Clase de la clave primaria>
 */
public interface MarksRepository extends CrudRepository<Mark,Long> {

}
