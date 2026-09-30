package br.edu.uniateneu.pedidos;

public class Cliente {

    private final String nome;
    private final String email;

    public Cliente(String nome, String email) {
        this.nome = validarNome(nome);
        this.email = email;
    }

    private static String validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente e obrigatorio");
        }
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
