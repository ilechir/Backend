/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myPortfolio.IC.Service;

import com.myPortfolio.IC.Entity.Persona;
import com.myPortfolio.IC.Repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arace
 */

@Service
@Transactional

public class ImpPersonaService{
    
    @Autowired 
    RPersona rPersona;

    
    public List<Persona> list(){
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return rPersona.findByNombre(nombre);
    }
    
    public void save(Persona persona){
        rPersona.save(persona);
    }
    
    public void delete(int id){
        rPersona.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rPersona.existsByNombre(nombre);
    }
      
}
