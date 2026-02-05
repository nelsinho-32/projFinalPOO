package src.main.java.com.menuconnect.api.service;

import java.util.ArrayList;
import java.util.List;

public class AdmRestaurant {
    private List<PratoService> cardapioGeral;

    public AdmRestaurant() {
        this.cardapioGeral = new ArrayList<>();
    }

    public void cadastrarPrato(PratoService prato) {
        cardapioGeral.add(prato);
        System.out.println("Sistema: Prato '" + prato.getNome() + "' cadastrado com sucesso!");
    }

    public void listarCardapio() {
        System.out.println("\n--- Cardápio do Restaurante ---");
        for (int i = 0; i < cardapioGeral.size(); i++) {
            System.out.println((i + 1) + ". " + cardapioGeral.get(i));
        }
    }

    public List<PratoService> getCardapio() {
        return cardapioGeral;
    }
}