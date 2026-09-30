package br.edu.uniateneu.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class PedidoServiceTest {

    private final Cliente ana = new Cliente("Ana", "ana@exemplo.local");
    private final Cliente bia = new Cliente("Bia", "bia@exemplo.local");
    private final PedidoService service = new PedidoService(new CalculadoraDeDesconto());

    @Test
    void criarAplicaDesconto() {
        Pedido pedido = service.criar(ana, new BigDecimal("200"));
        assertEquals(0, pedido.getValor().compareTo(new BigDecimal("190.00")));
    }

    @Test
    void totalDoClienteSomaSoSeusPedidos() {
        service.criar(ana, new BigDecimal("200"));
        service.criar(ana, new BigDecimal("50"));
        service.criar(bia, new BigDecimal("300"));
        assertEquals(0, service.totalDoCliente(ana).compareTo(new BigDecimal("240.00")));
    }

    @Test
    void listarRetornaPedidosCriados() {
        service.criar(ana, new BigDecimal("10"));
        service.criar(bia, new BigDecimal("20"));
        assertEquals(2, service.listar().size());
    }
}
