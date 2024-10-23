package com.codigo.persistencia.service.Impl;

import com.codigo.persistencia.entity.PedidoEntity;
import com.codigo.persistencia.entity.PersonaEntity;
import com.codigo.persistencia.repository.PedidoRepository;
import com.codigo.persistencia.repository.PersonaRepository;
import com.codigo.persistencia.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public PersonaEntity crearPersona(PersonaEntity personaEntity) {
        personaEntity.setEstado("ACTIVO");
        return personaRepository.save(personaEntity);
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return personaRepository.findAllByEstado("ACTIVO");
    }

    @Override
    public PersonaEntity buscarPersonaXnumDocumento(Long dni) {
        return personaRepository.findById(dni).orElseThrow(() ->
                new NoSuchElementException("Error Persona no encontrada"));
    }

    @Override
    public PersonaEntity actualizarPersona(Long dni, PersonaEntity personaActual) {
        PersonaEntity personaExistente = buscarPersonaXnumDocumento(dni);
        personaExistente.setNombre(personaActual.getNombre());
        personaExistente.setApellido(personaActual.getApellido());
        personaExistente.setDireccionEntity(personaActual.getDireccionEntity());
        return personaRepository.save(personaExistente);
    }



    @Override
    public void eliminarPersona(Long dni) {
        PersonaEntity personaExistente = buscarPersonaXnumDocumento(dni);
        personaExistente.setEstado("INACTIVO");
        personaRepository.save(personaExistente);
    }
}
