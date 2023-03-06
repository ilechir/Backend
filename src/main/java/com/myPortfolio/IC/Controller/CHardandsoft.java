/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myPortfolio.IC.Controller;

import com.myPortfolio.IC.Dto.dtoHardandsoft;
import com.myPortfolio.IC.Entity.hardandsoft;
import com.myPortfolio.IC.Security.Controller.Mensaje;
import com.myPortfolio.IC.Service.SHardandsoft;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author arace
 */
@RestController
@CrossOrigin(origins =  "https://localhost4200")
//@CrossOrigin(origins =  "https://frontend-ic.web.app")/
@RequestMapping("/skill")
public class CHardandsoft {
    @Autowired
    SHardandsoft shys;
    
    @GetMapping("/lista")
    public ResponseEntity<List<hardandsoft>> list(){
        List<hardandsoft> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<hardandsoft> getById(@PathVariable("id") int id){
        if(!shys.exists(id))
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        hardandsoft hys = shys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
      @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHardandsoft dtoHYS) {
        if (StringUtils.isBlank(dtoHYS.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shys.existsByNombre(dtoHYS.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        hardandsoft hys = new hardandsoft(dtoHYS.getNombre(), dtoHYS.getPorcentaje());
        shys.save(hys);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHardandsoft dtoHYS) {
        if (!shys.exists(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
         if (shys.existsByNombre(dtoHYS.getNombre()) && shys.getByNombre(dtoHYS.getNombre()).get().getId() !=id){ 
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoHYS.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        hardandsoft hys = shys.getOne(id).get();
        hys.setNombre(dtoHYS.getNombre());
        hys.setPorcentaje(dtoHYS.getPorcentaje());

        shys.save(hys);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id ){
        if(!shys.exists(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        shys.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
}
