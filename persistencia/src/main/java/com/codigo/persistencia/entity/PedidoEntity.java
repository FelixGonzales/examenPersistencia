package com.codigo.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pedido")
@Getter
@Setter
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private int cantidad;

    @Column(name = "estado", nullable = false)
    private String estado;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name= "cliente_id", referencedColumnName = "id", nullable = false)
    private PersonaEntity persona;
}
