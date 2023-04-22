
package com.DelaCasa.service;

import com.DelaCasa.domain.Articulo;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public interface ArticuloService {
    //Se obtiene un listado de articulos en un List
    public List<Articulo> getArticulos(boolean activos);
    
    //Se obtiene un Articulo, a partir del id de un articulo
    
    public Articulo getArticulo(Articulo articulo );
    
    //Se inserta un nuevo articulos si el id del articulo esta vacio 
    //Se actualiza un articulo si el id no esta vacio 
    public void save(Articulo articulo);

    //Se elimina un articulo si el id no esta vacio 
    public void delete(Articulo articulo);
}
