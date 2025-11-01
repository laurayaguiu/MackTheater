/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Teatro teatro = new Teatro();
        int opcao = 0;
        //Criar uma lista para os espetáculos?
        //Criar uma lista para os clientes?

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
                    //Criar variável acumuladora para o preço final?
                    
                    System.out.println("\n*** VENDA DE ENTRADAS - ESPETÁCULOS ***");

                    // Mostrar lista de espetáculos (for)

                    System.out.print("Selecione um espetáculo: ");
                    int num = input.nextInt();
                    
                    System.out.print("||| Assentos Disponíveis |||");
                    // Chamar método nomeEspetaculo.apresentaAssentos()
                    
                    System.out.print("Selecione um assento: ");
                    int assento = input.nextInt(); 

                    System.out.println("||| Tipos de Entrada |||");
                    System.out.println("1) Inteira");
                    System.out.println("2) Meia            50% do valor da entrada");
                    System.out.println("3) Professor       40% do valor da entrada");
                    System.out.print("Selecione um tipo de entrada: ");
                    int tipo = input.nextInt(); 

                    // Chamar método -> nomeEspetaculo.novaEntrada(tipo,assento)
                    // Chamar método -> nomeEspetaculo.marcarAssento(assento)

                    System.out.print("Deseja comprar outra entrada (S/N)?")
                    String resp = input.nextLine();
                    // Criar um if 

                    System.out.print("Informe o CPF do Cliente Cadastrado:");
                    // Verificar o CPF na lista de cientes (for) 
                    // Usar if, se estiver certo, mostrar o valor da compra

                    System.out.println(">>> Retornar ao menu principal <<<");
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
