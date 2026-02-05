package src.main.java.com.menuconnect.api.service;

public class PratoService {
    private String nome;
    private double preco;
    private String categoria;

    public PratoService(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }

    @Override
    public String toString() {
        return nome + " (" + categoria + ") - R$ " + preco;
    }
}
