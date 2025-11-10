import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;


        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Espetáculo");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Compra de Entradas");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastrar Espetáculo
                    System.out.println("*** CADASTRO DE ESPETÁCULO ***");

                    System.out.print("Nome do Espetáculo: ");
                    String nome = sc.nextLine();

                    System.out.print("Data: ");
                    String data = sc.nextLine();

                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    System.out.print("Preço da Entrada Inteira: ");
                    double preco = sc.nextDouble();

                    // cria o objeto Espetaculo
                    Espetaculo espetaculo1 = new Espetaculo(nome, data, hora, preco);

                case 2:
                   // Cadastrar Cliente
                   System.out.println("*** CADASTRO DE CLIENTE ***");
                    
                   System.out.print("Nome do Cliente: ");
                   String nomeC = sc.nextLine();

                   System.out.print("CPF: ");
                   String cpf = sc.nextLine();

                   Cliente cliente1 = new Cliente(nomeC, cpf);

                    break;

                case 3:
                    //Compra de Entradas
                    System.out.println("*** VENDA DE ENTRADAS – ESPETÁCULOS ***");
                    //mostrar espetáculos cadastrados - lista?
                    System.out.print("Selecione um espetáculo:");

                    //mostar assentos disponíveis
                    System.out.print("Selecione um assento:");
                    
                    // mostrar entradas
                    System.out.print("Selecione um tipo de entrada:");
                    System.out.print("Deseja comprar outra entrada (S/N)?");
                    //which para aparecer até ele esconher N 

                    //pede cpf do cliente e mostra o valor total
                    System.out.print("Informe o CPF do Cliente Cadastrado:");
                    System.out.print("Valor Total:");
                    break;

                case 4:
                    //Sair
                    System.out.println("Programa encerrado");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
