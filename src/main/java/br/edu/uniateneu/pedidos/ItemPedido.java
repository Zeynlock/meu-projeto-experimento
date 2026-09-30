package br.edu.uniateneu.pedidos;

import java.math.BigDecimal;

public class ItemPedido {

    private final String descricao;
    private final int quantidade;
    private final BigDecimal precoUnitario;

    public ItemPedido(String descricao, int quantidade, BigDecimal precoUnitario) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal subtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
