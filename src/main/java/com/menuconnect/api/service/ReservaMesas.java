package src.main.java.com.menuconnect.api.service;

import java.util.HashMap;
import java.util.Map;

public class ReservaMesas {
    private Map<Integer, String> mesas; // Mapa de <NumeroDaMesa, Status>

    public ReservaMesas(int quantidadeMesas) {
        mesas = new HashMap<>();
        for (int i = 1; i <= quantidadeMesas; i++) {
            mesas.put(i, "Disponível");
        }
    }

    public void reservarMesa(int numeroMesa, String nomeCliente) {
        if (mesas.containsKey(numeroMesa) && mesas.get(numeroMesa).equals("Disponível")) {
            mesas.put(numeroMesa, "Reservada para: " + nomeCliente);
            System.out.println("Sucesso: Mesa " + numeroMesa + " reservada para " + nomeCliente + ".");
        } else {
            System.out.println("Erro: Mesa " + numeroMesa + " já ocupada ou inexistente.");
        }
    }

    public void exibirStatusMesas() {
        System.out.println("\n--- Mapa de Mesas ---");
        mesas.forEach((numero, status) -> {
            System.out.println("Mesa " + numero + ": " + status);
        });
    }
}