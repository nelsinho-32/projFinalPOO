package src.main.java.com.menuconnect.api;

import java.util.Scanner;

import src.main.java.com.menuconnect.api.service.PedidoService;
import src.main.java.com.menuconnect.api.service.PratoService;

public class MenuConnectMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        PratoService p1 = new PratoService("Hambúrguer", 25.0, "Lanches");
        PratoService p2 = new PratoService("Refrigerante", 7.0, "Bebidas");
        
        PedidoService pedidoAtual = new PedidoService();
        
        System.out.println("Bem vindo ao Menu Connect!");
        System.out.println("1. " + p1);
        System.out.println("2. " + p2);
        System.out.println("0. Finalizar Pedido");

        int opcao;
        do {
            System.out.print("Escolha um prato ou 0 para sair: ");
            opcao = scanner.nextInt();

            if (opcao == 1) pedidoAtual.adicionarItem(p1);
            else if (opcao == 2) pedidoAtual.adicionarItem(p2);

        } while (opcao != 0);

        pedidoAtual.exibirResumo();
        scanner.close();
    }
}
