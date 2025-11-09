import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Espetaculo espetaculo = new Espetaculo("O Fantasma da Ópera", 80.0);
        Pedido pedido = new Pedido();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Ver mapa de assentos");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Ver pedido atual");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    espetaculo.apresentaAssentos();
                    break;

                case 2:
                    System.out.println(espetaculo); // usa o toString()
                    System.out.print("Digite o número do assento (1–50): ");
                    int numero = sc.nextInt();

                    System.out.println("Tipos de ingresso:");
                    System.out.println("1 - Inteira");
                    System.out.println("2 - Meia");
                    System.out.println("3 - Professor");
                    System.out.print("Escolha o tipo: ");
                    int tipo = sc.nextInt();

                    Entrada entrada = espetaculo.novaEntrada(tipo, numero);

                    if (entrada == null) {
                        System.out.println("❌ Não foi possível emitir o ingresso. Assento ocupado ou tipo inválido.");
                    } else {
                        pedido.adicionaEntrada(entrada);
                        System.out.println("✅ Ingresso adicionado ao pedido!");
                    }
                    break;

                case 3:
                    if (pedido.isVazio()) {
                        System.out.println("🛒 Nenhum ingresso comprado ainda.");
                    } else {
                        System.out.println("\n=== Seu Pedido ===");
                        System.out.println(pedido);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
