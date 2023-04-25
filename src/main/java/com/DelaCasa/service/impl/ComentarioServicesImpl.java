
package com.DelaCasa.service.impl;

import com.DelaCasa.dao.ComentarioDao;
import com.DelaCasa.domain.Comentario;
import com.DelaCasa.service.ComentarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioServicesImpl implements ComentarioService {
    
    @Autowired

    private ComentarioDao comentarioDao;

    @Override
    @Transactional(readOnly=true)
    public List<Comentario> getComentarios() {
        var lista=comentarioDao.findAll();
        
        
       return lista;
    }


    @Override
    @Transactional(readOnly=true)
    public Comentario getComentario(Comentario comentario) {
        return comentarioDao.findById(comentario.getIdComentario()).orElse(null);
    }

    @Override
    @Transactional()
    public void save(Comentario comentario) {
        comentarioDao.save(comentario);
    }

    @Override
    @Transactional()
    public void delete(Comentario comentario) {
        comentarioDao.delete(comentario);
    }
    
}
