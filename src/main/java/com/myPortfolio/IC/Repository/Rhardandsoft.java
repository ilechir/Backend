/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myPortfolio.IC.Repository;

import com.myPortfolio.IC.Entity.hardandsoft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author arace
 */
@Repository

public interface Rhardandsoft extends JpaRepository<hardandsoft, Integer> {
    Optional<hardandsoft> findByNombre (String nombre);
    public boolean existsByNombre (String nombre);
}
