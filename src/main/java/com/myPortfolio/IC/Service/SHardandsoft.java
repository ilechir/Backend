/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myPortfolio.IC.Service;

import com.myPortfolio.IC.Entity.hardandsoft;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myPortfolio.IC.Repository.hardandsoftRepository;

/**
 *
 * @author arace
 */
@Transactional
@Service
public class SHardandsoft {
    @Autowired
    hardandsoftRepository rhys;
    
    public List<hardandsoft> list() {
        return rhys.findAll();
    }
    
    public Optional<hardandsoft> getOne(int id){
        return rhys.findById(id);
    }
    
    public Optional<hardandsoft> getByNombre(String nombre){
        return rhys.findByNombre(nombre);
    }
    
    public void save(hardandsoft skill){
        rhys.save(skill);
    }
    
    public void delete(int id){
        rhys.deleteById(id);
    }
    
    public boolean exists(int id){
       return rhys.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre);
    }
    
}
