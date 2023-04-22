package com.DelaCasa.dao;

import com.DelaCasa.domain.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditoDao extends JpaRepository <Credito,Long> { //Mejora, no usar Crud 
    
    
}
