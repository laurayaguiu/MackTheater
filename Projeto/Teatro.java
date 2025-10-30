import java.util;

public class Teatro {
    private List<Espetaculo> espetaculos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();


    public void cadastrarEspetaculo() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n*** CADASTRO DE ESPETÁCULO ***");
        
        System.out.print("Nome do Espetáculo: ");
        String nome = input.nextLine();
        
        System.out.print("Data: ");
        String data = input.nextLine();
        
        System.out.print("Hora: ");
        String hora = input.nextLine();
        
        System.out.print("Preço da Entrada Inteira: ");
        double preco = input.nextDouble();

        espetaculos.add(new Espetaculo(nome, data, hora, preco));
        System.out.println("Espetáculo cadastrado!");
    }

    public void cadastrarCliente() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n*** CADASTRO DE CLIENTE ***");
        
        System.out.print("Nome do Cliente: ");
        String nome = input.nextLine();
        
        System.out.print("CPF: ");
        String cpf = input.nextLine();

        clientes.add(new Cliente(nome, cpf));
        System.out.println("Cliente cadastrado!");
    }

    public void compraDeEntradas() {
        if (espetaculos.size() == 0) {
            System.out.println("Nenhum espetáculo cadastrado");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("\n*** VENDA DE ENTRADAS - ESPETÁCULOS ***");
        for (int i = 0; i < espetaculos.size(); i++) {
            System.out.println((i + 1) + ") " + espetaculos.get(i));
        }