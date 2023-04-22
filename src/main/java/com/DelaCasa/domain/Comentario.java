
package com.DelaCasa.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
/**
 *
 * @author alejadro
 */
@Data
@Entity
@Table(name="comentario")
public class Comentario implements Serializable{
 private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comentario")
    private long idComentario;
    private long idCliente;
    private long idReceta;
    private String texto;
    @JoinColumn(name="id_receta", referencedColumnName = "id_receta")
    @ManyToOne
    private Receta receta;
    
    public Comentario( String texto) {
        this.texto = texto;
    }


    public Comentario() {
    }
}
