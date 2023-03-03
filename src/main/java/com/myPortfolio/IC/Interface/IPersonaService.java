/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myPortfolio.IC.Interface;

import com.myPortfolio.IC.Entity.Persona;
import java.util.List;

/**
 *
 * @author arace
 */
public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void delatePersona(Long id);
    
    public Persona findPersona(Long id);
    
}
