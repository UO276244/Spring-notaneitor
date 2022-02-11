package com.example.notaneitor.repositories;

import com.example.notaneitor.entities.Mark;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository<Clase Entidad, Clase de la clave primaria>
 */
public interface MarksRepository extends CrudRepository<Mark,Long> {

}
