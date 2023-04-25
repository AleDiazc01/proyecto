
package com.DelaCasa.dao;

import com.DelaCasa.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDao extends JpaRepository <Comentario,Long> { 
    
    
}
