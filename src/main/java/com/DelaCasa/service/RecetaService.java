
package com.DelaCasa.service;

import com.DelaCasa.domain.Receta;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public interface RecetaService {
    //Se obtiene un listado de articulos en un List
    public List<Receta> getRecetas();
    
    //Se obtiene un Articulo, a partir del id de un articulo
    
    public Receta getReceta(Receta receta );
    
    //Se inserta un nuevo articulos si el id del articulo esta vacio 
    //Se actualiza un articulo si el id no esta vacio 
    public void save(Receta receta);

    //Se elimina un articulo si el id no esta vacio 
    public void delete(Receta receta);
}
