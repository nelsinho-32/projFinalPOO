package src.main.java.com.menuconnect.api.service;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<PratoService> itens;
    private double total;

    public PedidoService() {
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public void adicionarItem(PratoService prato) {
        itens.add(prato);
        total += prato.getPreco();
    }

    public void exibirResumo() {
        System.out.println("Resumo do Pedido");
        for (PratoService p : itens) {
            System.out.println("- " + p.getNome() + ": R$ " + p.getPreco());
        }
        System.out.println("Total: R$ " + total);
    }
}
