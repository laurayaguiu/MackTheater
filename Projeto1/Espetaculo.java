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
    private boolean[] assentos; 

   
    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50]; 

         // inicializa todos os assentos como disponíveis (true = disponível) 
        for (int i = 0; i < assentos.length; i++) {
            assentos[i] = true;
        }
    }

 
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
            // a cada 10 assentos, quebra a linha para simular as fileiras
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }

    public Entrada novaEntrada(int tipo, int numero) {
        // validar o número (null = ausência de objeto)
        if (numero < 1 || numero > 50) return null;

        //converte o número do assento para o índice do vetor
        int indice = 50 - numero; 

        if (assentos[indice] == false) {
            return null; 
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

        
        marcarAssento(numero);
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

  
    @Override
    public String toString() {
        return "Espetáculo " + nome +
               " | Data: " + data +
               " | Hora: " + hora +
               " | R$: " + String.format("%.2f", preco);
    }

    public void marcarAssento(int numero) {
        if (numero < 1 || numero > 50) {
            System.out.println("Número de assento inválido!");
            return;
        }
        int indice = 50 - numero;
        assentos[indice] = false;
    }

    public void desmarcarAssento(int numero) {
        if (numero < 1 || numero > 50) {
            System.out.println("Número de assento inválido!");
            return;
        }
        int indice = 50 - numero;
        assentos[indice] = true;
    }

}
