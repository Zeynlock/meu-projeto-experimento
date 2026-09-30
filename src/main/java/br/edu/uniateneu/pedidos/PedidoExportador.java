package br.edu.uniateneu.pedidos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class PedidoExportador {

    public void exportar(Pedido pedido, Path destino) throws IOException {
        try (FileWriter escritor = new FileWriter(destino.toFile())) {
            escritor.write("Pedido " + pedido.getId() + "\n");
            escritor.write("Cliente: " + pedido.getCliente().getNome() + "\n");
            escritor.write("Valor: " + pedido.getValor() + "\n");
        }
    }
}
