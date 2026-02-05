package src.main.java.com.menuconnect.api;

import java.util.Scanner;

import src.main.java.com.menuconnect.api.service.*;

public class MenuConnectMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        AdmRestaurant adm = new AdmRestaurant();
        ReservaMesas reservas = new ReservaMesas(10);
        MarketingRestaurant mkt = new MarketingRestaurant();
        
        PratoService p1 = new PratoService("Hambúrguer", 25.0, "Lanches");
        PratoService p2 = new PratoService("Refrigerante", 7.0, "Bebidas");
        adm.cadastrarPrato(p1);
        adm.cadastrarPrato(p2);

        int perfil;
        do {
            System.out.println("\n---- MENU CONNECT ---");
            System.out.println("Como você deseja acessar?");
            System.out.println("1. Cliente");
            System.out.println("2. Administrador do Restaurante");
            System.out.println("0. Sair do Sistema");
            System.out.print("Opção: ");
            perfil = scanner.nextInt();

            switch (perfil) {
                case 1:
                    menuCliente(scanner, adm, reservas);
                    break;
                case 2:
                    menuAdmin(scanner, adm, mkt, reservas);
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (perfil != 0);

        scanner.close();
    }

    //cliente
    private static void menuCliente(Scanner scanner, AdmRestaurant adm, ReservaMesas reservas) {
    PedidoService pedidoAtual = new PedidoService(); //
    int opcao;
    do {
        System.out.println("\n--- ÁREA DO CLIENTE ---");
        System.out.println("1. Ver Cardápio e Pedir");
        System.out.println("2. Reservar uma Mesa");
        System.out.println("0. Voltar");
        System.out.print("Escolha: ");
        opcao = scanner.nextInt();

        if (opcao == 1) {
            adm.listarCardapio(); // Exibe o cardápio atualizado
            System.out.print("Digite o número do prato (ou 0 para cancelar): ");
            int escolha = scanner.nextInt();
            if (escolha > 0 && escolha <= adm.getCardapio().size()) {
                PratoService selecionado = adm.getCardapio().get(escolha - 1);
                pedidoAtual.adicionarItem(selecionado); //
                System.out.println("\n[SUCESSO]: " + selecionado.getNome() + " adicionado!");
                
                // MUDANÇA: Exibe o resumo IMEDIATAMENTE após adicionar
                pedidoAtual.exibirResumo(); //
            }
        } else if (opcao == 2) {
            System.out.print("Número da mesa: ");
            int mesa = scanner.nextInt();
            System.out.print("Seu nome: ");
            String nome = scanner.next();
            
            reservas.reservarMesa(mesa, nome); //
            // MUDANÇA: Exibe o mapa de mesas para você ver a reserva feita
            reservas.exibirStatusMesas(); //
        }
    } while (opcao != 0);
}

    //adm
    private static void menuAdmin(Scanner scanner, AdmRestaurant adm, MarketingRestaurant mkt, ReservaMesas reservas) {
    int opcao;
    do {
        System.out.println("\n--- PAINEL DE GESTÃO ---");
        System.out.println("1. Cadastrar Novo Prato");
        System.out.println("2. Criar Promoção");
        System.out.println("3. Ver Mapa de Mesas");
        System.out.println("0. Voltar");
        System.out.print("Escolha: ");
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Nome do prato: ");
                String nome = scanner.next();
                System.out.print("Preço: ");
                double preco = scanner.nextDouble();
                
                adm.cadastrarPrato(new PratoService(nome, preco, "Geral")); //
                // MUDANÇA: Lista o cardápio para confirmar o cadastro
                adm.listarCardapio(); //
                break;
            case 2:
                mkt.criarPromocao("Especial do Dia", 15.0); //
                break;
            case 3:
                reservas.exibirStatusMesas(); //
                break;
        }
    } while (opcao != 0);
}
}