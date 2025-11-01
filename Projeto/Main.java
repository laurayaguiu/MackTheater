//Janaína Diogo Passos - RA: 10737888, Bárbara Diogo Passos - RA: 10737885, Laura 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Teatro teatro = new Teatro();
        int opcao = 0;
        //Criar uma lista para os espetáculos?

        do {
            System.out.println("\n*** MACK THEATHER ***");
            System.out.println("(1) Cadastrar Espetáculo");
            System.out.println("(2) Cadastrar Cliente");
            System.out.println("(3) Compra de Entradas");
            System.out.println("(4) Sair");
            System.out.print("Selecione uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n*** CADASTRO DE ESPETÁCULO ***");
                    
                    System.out.print("Nome do Espetáculo: ");
                    String nome = input.nextLine();
                    
                    System.out.print("Data: ");
                    String data = input.nextLine();

                    System.out.print("Hora: ");
                    String hora = input.nextLine();

                    System.out.print("Preço da Entrada Inteira: ");
                    double preco = input.nextDouble();

                    //Criação do objeto Espetaculo com o construtor
                    Espetaculo novoEspetaculo = new Espetaculo(nome, data, hora, preco);

                    //Armazenar o espetáculo na lista

                    System.out.println(">>> Espetáculo cadastrado com sucesso! <<<");
                    System.out.println(">>> Retornar ao menu principal <<<");
                    break;
                    
                case 2:
                    System.out.println("\n*** CADASTRO DE CLIENTE ***");
                    
                    System.out.print("Nome do Cliente: ");
                    String nome = input.nextLine();
                    
                    System.out.print("CPF: ");
                    String cpf = input.nextLine();

                    //Criação do objeto Cliente com o construtor
                    Cliente novoCliente = new Cliente(nome, cpf);

                    //Armazenar cliente na lista

                    System.out.println(">>> Cliente cadastrado com sucesso! <<<");
                    System.out.println(">>> Retornar ao menu principal <<<");
                    break;
                    
                case 3:
                    teatro.compraDeEntradas();
                    break;
                case 4:
                    System.out.println("Sistema encerrado");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        input.close();
    }
}
