public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos; // array simples com 50 posições

    //construtor inicializa 
    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50]; // já é definido, não é um dado q o cliente coloca

        // inicializa todos os assentos como disponíveis (true)
        for (int i = 0; i < assentos.length; i++) {
            assentos[i] = true;
        }
    }

    // verifica se o assento está disponível
    /*
    public boolean estaDisponivel(int numero) {
        if (numero < 1 || numero > 50) {
            return false; // número inválido
        }
        int indice = 50 - numero;
        return assentos[indice];
    }
     */

    // marca o assento como ocupado
    public void marcarAssento(int numero) {
        if (numero < 1 || numero > 50) {
            System.out.println("Número de assento inválido!");
            return;
        }
        int indice = 50 - numero;
        assentos[indice] = false;
    }

    // cria uma nova entrada de acordo com o tipo
    public Entrada novaEntrada(int tipo, int numero) {
        if (!estaDisponivel(numero)) return null;

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

        marcarAssento(numero);
        return entrada;
    }

    // exibe o mapa de assentos (formato 5x10)
    public void apresentaAssentos() {
        System.out.println("\n ||| Assentos Disponíveis |||");

        int numero = 50;
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i] == true) {
                System.out.printf("%02d ", numero);
            } else {
                System.out.print("XX ");
            }

            numero--;

            // quebra linha a cada 10 assentos
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    // método toString para mostrar informações do espetáculo
    @Override
    public String toString() {
        return String.format("Nome do Espetáculo: %s \n Data: %s \n Hora: %s \n Preço da Entrada Inteira: %.2f ", getNome(), getData(), getHora(), getPreco());
    }

    // getters
    public double getPreco() {
        return preco;
    }

    /* 
    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
    */
    
}