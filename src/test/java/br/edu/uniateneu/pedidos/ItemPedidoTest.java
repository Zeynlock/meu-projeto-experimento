package br.edu.uniateneu.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ItemPedidoTest {

    @Test
    void calculaSubtotal() {
        ItemPedido item = new ItemPedido("Caneta", 3, new BigDecimal("2.50"));
        assertEquals(0, item.subtotal().compareTo(new BigDecimal("7.50")));
        assertEquals("Caneta", item.getDescricao());
        assertEquals(3, item.getQuantidade());
    }

    @Test
    void quantidadeZeroLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido("Caneta", 0, BigDecimal.ONE));
    }
}
