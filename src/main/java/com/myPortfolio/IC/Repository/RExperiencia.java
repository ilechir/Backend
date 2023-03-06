/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myPortfolio.IC.Repository;

import com.myPortfolio.IC.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author arace
 */
@Repository

public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findBynombreE(String nombreE);
    public boolean existsBynombreE(String nombreE);
}
