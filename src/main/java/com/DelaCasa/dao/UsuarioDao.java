package com.DelaCasa.dao;

import com.DelaCasa.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository <Usuario, Long> {
    
    Usuario findByUsername(String username);
    
}
