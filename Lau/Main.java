import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner sc = new Scanner(System.in);
        Teatro teatro = new Teatro();

        // opcional: alguns espetáculos iniciais para teste (pode remover)
        // teatro.adicionarEspetaculo(new Espetaculo("Espetáculo 01", "15/11/2025", "19h30", 30.0));
        // teatro.adicionarEspetaculo(new Espetaculo("Espetáculo 02", "30/11/2025", "20h30", 50.0));
        // teatro.adicionarEspetaculo(new Espetaculo("Espetáculo 03", "02/12/2025", "21h30", 35.0));

        boolean executar = true;
        while (executar) {
            System.out.println("\n*** MACK THEATHER ***");
            System.out.println("1) Cadastrar Espetáculo");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.print("Selecione uma opção: ");
            String opc = sc.nextLine().trim();

            switch (opc) {
                case "1":
                    System.out.println("\n*** CADASTRO DE ESPETÁCULO ***");
                    System.out.print("Nome do Espetáculo: ");
                    String nome = sc.nextLine();
                    System.out.print("Data: ");
                    String data = sc.nextLine();
                    System.out.print("Hora: ");
                    String hora = sc.nextLine();
                    double preco = 0;
                    while (true) {
                        System.out.print("Preço da Entrada Inteira: ");
                        try {
                            preco = Double.parseDouble(sc.nextLine().replace(',', '.'));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido. Digite um número (ex: 30 ou 30.00).");
                        }
                    }
                    Espetaculo esp = new Espetaculo(nome, data, hora, preco);
                    teatro.adicionarEspetaculo(esp);
                    System.out.println("\n>>> Retornar ao menu principal <<<");
                    break;

                case "2":
                    System.out.println("\n*** CADASTRO DE CLIENTE ***");
                    System.out.print("Nome do Cliente: ");
                    String nomeC = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    Cliente cliente = new Cliente(nomeC, cpf);
                    teatro.adicionarCliente(cliente);
                    System.out.println("\n>>> Retornar ao menu principal <<<");
                    break;

                case "3":
                    System.out.println("\n*** VENDA DE ENTRADAS – ESPETÁCULOS ***");
                    teatro.apresentaEspetaculos();
                    System.out.print("Selecione um espetáculo: ");
                    int numEsp;
                    try {
                        numEsp = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Número inválido. Voltando ao menu.");
                        break;
                    }
                    if (!teatro.selecionaEspetaculo(numEsp)) {
                        System.out.println("Espetáculo inválido. Voltando ao menu.");
                        break;
                    }

                    boolean comprando = true;
                    while (comprando) {
                        teatro.getEspetaculoSelecionado().apresentaAssentos();
                        System.out.print("Selecione um assento: ");
                        int assento;
                        try {
                            assento = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Assento inválido.");
                            continue;
                        }

                        System.out.println("\n ||| Tipos de Entrada ||| ");
                        System.out.println("1) Inteira");
                        System.out.println("2) Meia  50% do valor da entrada");
                        System.out.println("3) Professor 40% do valor da entrada");
                        System.out.print("Selecione um tipo de entrada: ");
                        int tipo;
                        try {
                            tipo = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Tipo inválido.");
                            continue;
                        }

                        boolean sucesso = teatro.novaEntrada(tipo, assento);
                        if (!sucesso) {
                            System.out.println("Não foi possível reservar este assento (inválido ou já ocupado).");
                        } else {
                            System.out.print("\nDeseja comprar outra entrada (S/N)? ");
                            String resp = sc.nextLine().trim();
                            if (!resp.equalsIgnoreCase("S")) {
                                comprando = false;
                            }
                        }
                    }

                    System.out.print("\nInforme o CPF do Cliente Cadastrado: ");
                    String cpfCliente = sc.nextLine().trim();
                    double total = teatro.finalizaCompra(cpfCliente);
                    if (total == -1.0) {
                        System.out.println("CPF não encontrado. Compra cancelada.");
                    } else {
                        System.out.printf("Valor Total: R$ %.2f\n", total);
                        System.out.println("\n>>> Retornar ao menu principal <<<");
                    }
                    break;

                case "4":
                    executar = false;
                    System.out.println("Saindo... Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
    }
}