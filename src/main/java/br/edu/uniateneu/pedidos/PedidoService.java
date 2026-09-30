package br.edu.uniateneu.pedidos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private final CalculadoraDeDesconto calculadora;
    private final List<Pedido> pedidos = new ArrayList<>();
    private long proximoId = 1;

    public PedidoService(CalculadoraDeDesconto calculadora) {
        this.calculadora = calculadora;
    }

    public Pedido criar(Cliente cliente, BigDecimal valorBruto) {
        BigDecimal desconto = calculadora.calcular(valorBruto);
        Pedido pedido = new Pedido(proximoId++, cliente, valorBruto.subtract(desconto));
        pedidos.add(pedido);
        return pedido;
    }

    public BigDecimal totalDoCliente(Cliente cliente) {
        BigDecimal total = BigDecimal.ZERO;
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente() == cliente) {
                total = total.add(pedido.getValor());
            }
        }
        return total;
    }

    public List<Pedido> listar() {
        return List.copyOf(pedidos);
    }
}
