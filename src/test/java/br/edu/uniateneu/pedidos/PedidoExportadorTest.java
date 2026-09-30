package br.edu.uniateneu.pedidos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class PedidoExportadorTest {

    @TempDir
    Path pasta;

    @Test
    void exportaDadosDoPedido() throws IOException {
        Pedido pedido = new Pedido(7, new Cliente("Ana", "ana@exemplo.local"), new BigDecimal("90.00"));
        Path arquivo = pasta.resolve("pedido.txt");

        new PedidoExportador().exportar(pedido, arquivo);

        String conteudo = Files.readString(arquivo);
        assertTrue(conteudo.contains("Pedido 7"));
        assertTrue(conteudo.contains("Cliente: Ana"));
        assertTrue(conteudo.contains("Valor: 90.00"));
    }
}
