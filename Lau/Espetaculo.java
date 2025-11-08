import java.util.Arrays;

public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[][] assentos;

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[5][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                assentos[i][j] = true; // todos disponíveis
            }
        }
    }

    public void apresentaAssentos() {
        System.out.println("\n ||| Assentos Disponíveis |||");
        int numero = 50;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (assentos[i][j]) {
                    System.out.printf("%02d ", numero);
                } else {
                    System.out.print("XX ");
                }
                numero--;
            }
            System.out.println();
        }
    }
    
    public Entrada novaEntrada(int tipo, int numero) {
        if (!estaDisponivel(numero)) return null;

        Entrada entrada = null;
        switch (tipo) {
            case 1: entrada = new EntradaInteira(numero, preco); break;
            case 2: entrada = new EntradaMeia(numero, preco); break;
            case 3: entrada = new EntradaProfessor(numero, preco); break;
            default: return null;
        }
        marcarAssento(numero);
        return entrada;
    }

    public double getPreco() {
        return preco;
    }

    public void marcarAssento(int numero) {
        if (numero < 1 || numero > 50) return;
        int index = 50 - numero; // para começar do topo
        int linha = index / 10;
        int coluna = index % 10;
        assentos[linha][coluna] = false;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s R$ %.2f", nome, data, hora, preco);
    }

    public String getNome() {
        return nome;
    }

    private boolean estaDisponivel(int numero) {
        if (numero < 1 || numero > 50) return false;
        int[] pos = converteNumeroParaPosicao(numero);
        return assentos[pos[0]][pos[1]];
    }

    private int[] converteNumeroParaPosicao(int numero) {
    // Exemplo: 50 → [0][0], 41 → [0][9], 1 → [4][9]
    int index = 50 - numero;
    int linha = index / 10;
    int coluna = index % 10;
    return new int[]{linha, coluna};
}
}