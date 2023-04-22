
package com.DelaCasa.dao;

import com.DelaCasa.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Laboratorios
 */
public interface CategoriaDao extends JpaRepository <Categoria,Long> { //Mejora, no usar Crud 
    
    
}
