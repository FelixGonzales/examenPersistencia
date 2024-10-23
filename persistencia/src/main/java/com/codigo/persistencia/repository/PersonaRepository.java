package com.codigo.persistencia.repository;

import com.codigo.persistencia.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
    List<PersonaEntity> findAllByEstado(String estado);
}
