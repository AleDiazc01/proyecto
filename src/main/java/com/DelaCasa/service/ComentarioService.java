
package com.DelaCasa.service;

import com.DelaCasa.domain.Comentario;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public interface ComentarioService {
    //Se obtiene un listado de comentarios en un List
    public List<Comentario> getComentarios();
    //Se obtiene un Comentario, a partir del id de un comentario
    
    public Comentario getComentario(Comentario comentario );
    
    
    //Se inserta un nuevo comentarios si el id del comentario esta vacio 
    //Se actualiza un comentario si el id no esta vacio 
    public void save(Comentario comentario);

    //Se elimina un comentario si el id no esta vacio 
    public void delete(Comentario comentario);
}
