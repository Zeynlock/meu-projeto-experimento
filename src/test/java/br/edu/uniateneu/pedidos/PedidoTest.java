package br.edu.uniateneu.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class PedidoTest {

    private final Cliente cliente = new Cliente("Ana", "ana@exemplo.local");

    @Test
    void criaPedidoValido() {
        Pedido pedido = new Pedido(1, cliente, new BigDecimal("50.00"));
        assertEquals(1, pedido.getId());
        assertEquals(cliente, pedido.getCliente());
        assertEquals(new BigDecimal("50.00"), pedido.getValor());
    }

    @Test
    void valorNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido(1, cliente, new BigDecimal("-1")));
    }

    @Test
    void clienteNuloLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido(1, null, BigDecimal.TEN));
    }
}
