package com.DelaCasa.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="receta")
public class Receta implements Serializable{
    
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private long idReceta;
    private String nombre;
    private String descripcion;
    private String ingredientes;
    private String preparacion;
    private String imagen;

    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente cliente;
    
    public Receta() {
    }

    public Receta(String nombre, String descripcion, String ingredientes, String preparacion,String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.imagen = imagen;

    }

}
