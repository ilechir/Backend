/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myPortfolio.IC.Repository;

import com.myPortfolio.IC.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author arace
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
