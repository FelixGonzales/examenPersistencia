package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.PersonaEntity;
import com.codigo.persistencia.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas/v1")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/crearPersona")
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity personaEntity){
        PersonaEntity nuevaPersona = personaService.crearPersona(personaEntity);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }

    @GetMapping("/buscarTodos")
    public List<PersonaEntity> buscarTodos() {
        return personaService.buscarTodos();
    }

    @GetMapping("/buscarXdni/{dni}")
    public ResponseEntity<PersonaEntity> buscarPersonaXnumDocumento(@PathVariable Long dni){
        PersonaEntity persona = personaService.buscarPersonaXnumDocumento(dni);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PutMapping("/actualizarPersona/{dni}")
    public ResponseEntity<PersonaEntity> actualizarPersona(
            @PathVariable Long dni,@RequestBody PersonaEntity personaEntity){
        PersonaEntity personaActualizada = personaService.actualizarPersona(dni, personaEntity);
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPersona/{dni}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long dni){
        personaService.eliminarPersona(dni);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
