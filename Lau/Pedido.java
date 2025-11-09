/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //entradas é uma lista (ArrayList) que guarda objetos do tipo Entrada.
    private List<Entrada> entradas;

    //construtor cria uma lista vazia de entradas
    public Pedido() {
        this.entradas = new ArrayList<>();
    }
 
    //adiciona uma entrada na lista do pedido.
    //Foi colocado um ingresso válido? se sim pode adicionar a lista entradas
    public void adicionaEntrada(Entrada entrada) {
        if (entrada != null) {
            entradas.add(entrada);
        }
    }
    
    //loop for-each para percorrer todas as entradas da lista e soma no total
    public double calculaValorTotal() {
        double total = 0.0;
        for (Entrada e : entradas) {
            total += e.calculaValor();
        }
        return total;
    }

   /*
   esse toString é sempre override pq vem da classe Object ("mãe de todas as class java")
   todo objeto java herda o toString automaticamente
   usamos como método de apoio - exibir informações no console
   */ 
    @Override
    public String toString() {
        String texto = ""; // começa com uma string vazia

        // percorre a lista de entradas (ingressos) com for-each
        for (Entrada e : entradas) {
            // adiciona a descrição da entrada e uma quebra de linha para separação
            texto += e.toString() + "\n";
        }
        // adiciona o valor total no final
        texto += String.format("Total: R$ %.2f", calculaValorTotal());

        // retorna o texto completo
        return texto;
    }
}
