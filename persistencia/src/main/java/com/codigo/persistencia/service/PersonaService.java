package com.codigo.persistencia.service;

import com.codigo.persistencia.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    PersonaEntity crearPersona(PersonaEntity persona);

    List<PersonaEntity> buscarTodos();

    PersonaEntity buscarPersonaXnumDocumento(Long dni);

    PersonaEntity actualizarPersona(Long dni, PersonaEntity persona);

    void eliminarPersona(Long dni);
}
