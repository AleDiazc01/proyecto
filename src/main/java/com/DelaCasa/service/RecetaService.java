
package com.DelaCasa.service;

import com.DelaCasa.domain.Receta;
import java.util.List;


public interface RecetaService {
    public List<Receta> getRecetas();
    
    
    public Receta getReceta(Receta receta );
    
    public void save(Receta receta);

    public void delete(Receta receta);
}
