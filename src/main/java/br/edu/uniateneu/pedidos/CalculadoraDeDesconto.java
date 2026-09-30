package br.edu.uniateneu.pedidos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraDeDesconto {

    private static final BigDecimal LIMITE = new BigDecimal("100");
    private static final BigDecimal TAXA = new BigDecimal("0.05");

    public BigDecimal calcular(BigDecimal valor) {
        if (valor.compareTo(LIMITE) < 0) {
            return valor.multiply(TAXA).setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO.setScale(2);
    }
}
