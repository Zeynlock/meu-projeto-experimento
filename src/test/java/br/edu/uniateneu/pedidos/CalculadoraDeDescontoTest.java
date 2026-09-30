package br.edu.uniateneu.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CalculadoraDeDescontoTest {

    private final CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();

    @Test
    void semDescontoAbaixoDoLimite() {
        assertEquals(0, calculadora.calcular(new BigDecimal("50")).compareTo(BigDecimal.ZERO));
    }

    @Test
    void descontoDeCincoPorCentoNoLimite() {
        assertEquals(0, calculadora.calcular(new BigDecimal("100")).compareTo(new BigDecimal("5.00")));
    }

    @Test
    void descontoDeCincoPorCentoAcimaDoLimite() {
        assertEquals(0, calculadora.calcular(new BigDecimal("200")).compareTo(new BigDecimal("10.00")));
    }
}
