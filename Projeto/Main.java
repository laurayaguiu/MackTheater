import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Teatro teatro = new Teatro();
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Espetáculo");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Compra de Entradas");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("*** CADASTRO DE ESPETÁCULO ***");
                    System.out.print("Nome do Espetáculo: ");
                    String nome = sc.nextLine();
                    System.out.print("Data: ");
                    String data = sc.nextLine();
                    System.out.print("Hora: ");
                    String hora = sc.nextLine();
                    System.out.print("Preço da Entrada Inteira: ");
                    double preco = sc.nextDouble();
                    sc.nextLine(); 

                    Espetaculo novoEspetaculo = new Espetaculo(nome, data, hora, preco);
                    teatro.adicionarEspetaculo(novoEspetaculo);
                    System.out.println("Espetáculo cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("*** CADASTRO DE CLIENTE ***");
                    System.out.print("Nome do Cliente: ");
                    String nomeC = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    Cliente cliente1 = new Cliente(nomeC, cpf);
                    teatro.adicionarCliente(cliente1);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("*** VENDA DE ENTRADAS – ESPETÁCULOS ***");
                    teatro.apresentarEspetaculos();
                    if (teatro.getListaEspetaculos().isEmpty()) break;

                    System.out.print("Selecione um espetáculo (número): ");
                    int numEsp = sc.nextInt();
                    if (!teatro.selecionaEspetaculo(numEsp)) {
                        System.out.println("Espetáculo inválido.");
                        break;
                    }

                    Espetaculo selecionado = teatro.getEspetaculoSelecionado();
                    String continuar;
                    do {
                        selecionado.apresentaAssentos();
                        System.out.print("\nSelecione o número do assento desejado: ");
                        int assento = sc.nextInt();

                        System.out.println("\nTipos de entrada disponíveis:");
                        System.out.println("1 - Inteira (R$ " + String.format("%.2f", selecionado.getPreco()) + ")");
                        System.out.println("2 - Meia (R$ " + String.format("%.2f", (selecionado.getPreco() / 2)) + ")");
                        System.out.println("3 - Professor (R$ " + String.format("%.2f", (selecionado.getPreco() * 0.4)) + ")");
                        System.out.print("Escolha o tipo: ");
                        int tipo = sc.nextInt();

                        boolean ok = teatro.novaEntrada(tipo, assento);
                        if (!ok) {
                             System.out.println("Inválido, tente novamente!");
                        } 

                        System.out.print("\nDeseja selecionar outro assento? (s/n): ");
                        continuar = sc.next().toLowerCase();
                    } while (continuar.equals("s"));

                    sc.nextLine();
                    System.out.print("Informe o CPF do Cliente Cadastrado: ");
                    String cpfCliente = sc.nextLine();
                    double total = teatro.finalizaCompra(cpfCliente);
                    if (total == -1.0) {
                        System.out.println("Cliente não encontrado. Compra cancelada.");
                    } else if (total == 0.0) {
                        System.out.println("Carrinho vazio. Nenhuma compra realizada.");
                    } else {
                        System.out.println("Compra finalizada. Valor Total: R$ " + String.format("%.2f", total));
                    }
                    break;

                case 4:
                    System.out.println("Programa encerrado");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        sc.close();
    }
}