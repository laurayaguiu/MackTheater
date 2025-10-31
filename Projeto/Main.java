//Janaína Diogo Passos - RA: 10737888, Bárbara Diogo Passos - RA: 10737885, Laura 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Teatro teatro = new Teatro();
        int opcao = 0;

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
                    teatro.cadastrarEspetaculo();
                    break;
                case 2:
                    teatro.cadastrarCliente();
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
