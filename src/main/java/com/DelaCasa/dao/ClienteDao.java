package com.DelaCasa.dao;

import com.DelaCasa.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository <Cliente, Long> {
    
}
