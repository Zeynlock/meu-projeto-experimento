package br.edu.uniateneu.pedidos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraDeDesconto {

    private static final BigDecimal FAIXA_BAIXA = new BigDecimal("100");
    private static final BigDecimal FAIXA_ALTA = new BigDecimal("500");
    private static final BigDecimal TAXA_BAIXA = new BigDecimal("0.05");
    private static final BigDecimal TAXA_ALTA = new BigDecimal("0.10");

    public BigDecimal calcular(BigDecimal valor) {
        if (valor.compareTo(FAIXA_ALTA) >= 0) {
            return valor.multiply(TAXA_ALTA).setScale(2, RoundingMode.HALF_UP);
        }
        if (valor.compareTo(FAIXA_BAIXA) >= 0) {
            return valor.multiply(TAXA_BAIXA).setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO.setScale(2);
    }
}
