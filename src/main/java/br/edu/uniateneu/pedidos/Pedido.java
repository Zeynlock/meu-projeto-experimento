package br.edu.uniateneu.pedidos;

import java.math.BigDecimal;

public class Pedido {

    private final long id;
    private final Cliente cliente;
    private final BigDecimal valor;

    public Pedido(long id, Cliente cliente, BigDecimal valor) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente e obrigatorio");
        }
        if (valor == null || valor.signum() < 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
