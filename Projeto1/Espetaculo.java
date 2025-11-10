public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos; // true = disponível, false = ocupado

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50];

        for (int i = 0; i < assentos.length; i++) {
            assentos[i] = true;
        }
    }

    public void apresentaAssentos() {
        System.out.println("\n ||| Assentos Disponíveis |||");
        int numero = 50;
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i]) {
                System.out.printf("%02d ", numero);
            } else {
                System.out.print("XX ");
            }
            numero--;
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }

    public Entrada novaEntrada(int tipo, int numero) {
        if (numero < 1 || numero > 50) return null;

        int indice = 50 - numero; // mapeia número do assento ao índice do array

        if (!assentos[indice]) {
            return null; // já ocupado
        }

        Entrada entrada = null;
        switch (tipo) {
            case 1:
                entrada = new EntradaInteira(numero, preco);
                break;
            case 2:
                entrada = new EntradaMeia(numero, preco);
                break;
            case 3:
                entrada = new EntradaProfessor(numero, preco);
                break;
            default:
                return null;
        }

        assentos[indice] = false; // marca ocupado
        return entrada;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Espetáculo: " + nome +
               " | Data: " + data +
               " | Hora: " + hora +
               " | Preço da Inteira: R$ " + String.format("%.2f", preco);
    }

    public void marcarAssento(int numero) {
        if (numero < 1 || numero > 50) {
            System.out.println("Número de assento inválido!");
            return;
        }
        int indice = 50 - numero;
        assentos[indice] = false;
    }
}