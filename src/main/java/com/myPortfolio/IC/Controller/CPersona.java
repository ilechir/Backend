/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myPortfolio.IC.Controller;

import com.myPortfolio.IC.Dto.dtoPersona;
import com.myPortfolio.IC.Entity.Persona;
import com.myPortfolio.IC.Security.Controller.Mensaje;
import com.myPortfolio.IC.Service.PersonaServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author arace
 */
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
        
public class CPersona {
  @Autowired 
    PersonaServiceImpl personaS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaS.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaS.existsById(id)){
            return new ResponseEntity(new Mensaje("No exites el id"), HttpStatus.NOT_FOUND);
        }
       if(personaS.existsByNombre(dtopersona.getNombre()) && personaS.getByNombre(dtopersona.getNombre()).get().getId() !=id){
           return new ResponseEntity(new Mensaje("Ese nombre ya exite"), HttpStatus.BAD_REQUEST);
       }
          if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
          if(StringUtils.isBlank(dtopersona.getDescripcion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaS.getOne(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setApellido(dtopersona.getApellido());
        persona.setImg(dtopersona.getImg());
        
        personaS.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);   
       
    }
}
