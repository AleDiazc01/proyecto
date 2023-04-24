
package com.DelaCasa.service.impl;

import com.DelaCasa.dao.RecetaDao;
import com.DelaCasa.domain.Receta;
import com.DelaCasa.service.RecetaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laboratorios
 */
@Service
public class RecetaServicesImpl implements RecetaService {
    
    @Autowired

    private RecetaDao recetaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Receta> getRecetas() {
        var lista=recetaDao.findAll();
        
        
       return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Receta getReceta(Receta receta) {
        return recetaDao.findById(receta.getIdReceta()).orElse(null);
    }

    @Override
    @Transactional()
    public void save(Receta receta) {
        recetaDao.save(receta);
    }

    @Override
    @Transactional()
    public void delete(Receta receta) {
        recetaDao.delete(receta);
    }
    
}
