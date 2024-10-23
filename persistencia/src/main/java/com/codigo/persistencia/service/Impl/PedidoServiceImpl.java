package com.codigo.persistencia.service.Impl;

import com.codigo.persistencia.entity.PedidoEntity;
import com.codigo.persistencia.entity.PersonaEntity;
import com.codigo.persistencia.repository.PedidoRepository;
import com.codigo.persistencia.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidoServiceImpl implements PedidoService {


    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoEntity crearPedido(PedidoEntity pedidoEntity) {
        pedidoEntity.setEstado("PENDIENTE");
        return pedidoRepository.save(pedidoEntity);
    }

    @Override
    public List<PedidoEntity> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public List<PedidoEntity> buscarPedidoPorParametro(String estado) {
        return pedidoRepository.findAllByEstado(estado);
    }

    @Override
    public PedidoEntity buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Pedido no encontrado"));
    }

    @Override
    public PedidoEntity actualizarPedido(Long id, PedidoEntity pedidoEntity) {
        PedidoEntity pedidoExistente = buscarPedidoPorId(id);
        pedidoExistente.setDescripcion(pedidoEntity.getDescripcion());
        pedidoExistente.setCantidad(pedidoEntity.getCantidad());
        pedidoExistente.setEstado(pedidoEntity.getEstado());
        return pedidoRepository.save(pedidoExistente);
    }

    @Override
    public void eliminarPedido(Long id) {
        PedidoEntity pedidoExistente = buscarPedidoPorId(id);
        pedidoExistente.setEstado("ELIMINADO");
        pedidoRepository.save(pedidoExistente);
    }
}
