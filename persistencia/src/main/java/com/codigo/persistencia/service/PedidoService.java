package com.codigo.persistencia.service;

import com.codigo.persistencia.entity.PedidoEntity;
import com.codigo.persistencia.entity.PersonaEntity;

import java.util.List;

public interface PedidoService {

    PedidoEntity crearPedido(PedidoEntity pedidoEntity);

    List<PedidoEntity> buscarTodos();

    List<PedidoEntity> buscarPedidoPorParametro(String estado);

    PedidoEntity buscarPedidoPorId(Long id);

    PedidoEntity actualizarPedido(Long id, PedidoEntity pedidoEntity);

    void eliminarPedido(Long id);


}
