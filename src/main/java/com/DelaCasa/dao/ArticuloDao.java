
package com.DelaCasa.dao;

import com.DelaCasa.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Laboratorios
 */
public interface ArticuloDao extends JpaRepository <Articulo,Long> { //Mejora, no usar Crud 
    
    
}
