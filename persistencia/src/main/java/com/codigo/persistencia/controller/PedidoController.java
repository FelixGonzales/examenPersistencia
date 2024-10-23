package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.PedidoEntity;
import com.codigo.persistencia.entity.PersonaEntity;
import com.codigo.persistencia.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/v1")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crearPedido")
    public ResponseEntity<PedidoEntity> crearPedido(@RequestBody PedidoEntity pedidoEntity){
        PedidoEntity nuevoPedido = pedidoService.crearPedido(pedidoEntity);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/buscarTodos")
    public List<PedidoEntity> buscarTodos() {
        return pedidoService.buscarTodos();
    }

    @GetMapping("/buscarXid/{id}")
    public ResponseEntity<PedidoEntity> buscarXid(@PathVariable Long id){
        PedidoEntity pedido = pedidoService.buscarPedidoPorId(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PutMapping("/actualizarPedido/{id}")
    public ResponseEntity<PedidoEntity> actualizarPedido(
            @PathVariable Long id, @RequestBody PedidoEntity pedidoEntity){
        PedidoEntity pedidoActualizado = pedidoService.actualizarPedido(id, pedidoEntity);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPedido/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id){
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
