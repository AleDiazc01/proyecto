/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DelaCasa.dao;

import com.DelaCasa.domain.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author alejadro
 */
public interface RecetaDao extends JpaRepository <Receta,Long>{
    
}