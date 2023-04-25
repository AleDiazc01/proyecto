
package com.DelaCasa.dao;

import com.DelaCasa.domain.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author alejadro
 */
public interface RecetaDao extends JpaRepository <Receta,Long>{
    
}