/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/

public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos; // true = disponível, false = ocupado

    //construtor inicializa
    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50]; // já é definido, não é um dado q o cliente coloca

         // inicializa todos os assentos como disponíveis (true = disponível) 
        for (int i = 0; i < assentos.length; i++) {
            assentos[i] = true;
        }
    }

    //Mostrar assentos visualmente
    public void apresentaAssentos() {
        System.out.println("\n ||| Assentos Disponíveis |||");
        int numero = 50; //quantidade de ass
        //loop q percorre todos os ass
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i] == true) {
                // numero formatado com 2 dígitos
                System.out.printf("%02d ", numero);
            } else {
                System.out.print("XX ");
            }
            numero--;
            // a cada 10 pula linha - para mostrar certinho as fileiras
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }

    // nova entrada
    public Entrada novaEntrada(int tipo, int numero) {
        // validar o número (null = ausência de objeto)
        if (numero < 1 || numero > 50) return null;

        // converter N do ass para indice do arry
        // EX: o primeiro ass (50) é indice 0
        int indice = 50 - numero; 

        // validar ass ocupado
        if (assentos[indice] == false) {
            return null; 
        }

        // cria obj entrada, inicialmente sem valor
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

        // chamada de um método
        marcarAssento(numero);// marca ocupado
        return entrada;
    }

    //getters
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

    /*
   esse toString é sempre override pq vem da classe Object ("mãe de todas as class java")
   todo objeto java herda o toString automaticamente
   usamos como método de apoio - exibir informações no console
   */ 
    @Override
    public String toString() {
        return "Espetáculo " + nome +
               " | Data: " + data +
               " | Hora: " + hora +
               " | R$: " + String.format("%.2f", preco);
    }

    // método para marcar ass como ocupado
    public void marcarAssento(int numero) {
        if (numero < 1 || numero > 50) {
            System.out.println("Número de assento inválido!");
            return;
        }
        int indice = 50 - numero;
        assentos[indice] = false;
    }

    // método para desmarcar assento (liberar)
    public void desmarcarAssento(int numero) {
        if (numero < 1 || numero > 50) {
            System.out.println("Número de assento inválido!");
            return;
        }
        int indice = 50 - numero;
        assentos[indice] = true;
    }
    

}