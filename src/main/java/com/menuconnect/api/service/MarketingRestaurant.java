package src.main.java.com.menuconnect.api.service;

public class MarketingRestaurant {
    
    public void criarPromocao(String nomePrato, double desconto) {
        System.out.println("\n--- Ação de Marketing ---");
        System.out.println("Promoção Ativa: " + nomePrato + " com " + desconto + "% de desconto!");
        System.out.println("Notificação enviada para a lista de clientes.");
    }

    public void anunciarRestaurante(String nomeRestaurante) {
        System.out.println("\n[MARKETING]: Venha conhecer o " + nomeRestaurante + "! Os melhores sabores da cidade.");
    }
}