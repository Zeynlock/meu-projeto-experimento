package br.edu.uniateneu.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void criaClienteComDadosValidos() {
        Cliente cliente = new Cliente("Ana", "ana@exemplo.local");
        assertEquals("Ana", cliente.getNome());
        assertEquals("ana@exemplo.local", cliente.getEmail());
    }

    @Test
    void nomeEmBrancoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente(" ", "ana@exemplo.local"));
    }
}
