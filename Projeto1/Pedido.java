/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Entrada> entradas;
    private Cliente cliente; //  guarda o objeto Cliente inteiro

    public Pedido() {
        this.entradas = new ArrayList<>();
        this.cliente = null; // ainda não tem cliente atribuído
    }

    // Adiciona uma entrada (ingresso) ao pedido
    public void adicionaEntrada(Entrada entrada) {
        if (entrada != null) {
            entradas.add(entrada);
        }
    }

    // Calcula o valor total somando todas as entradas
    public double calculaValorTotal() {
        double total = 0.0;
        for (Entrada e : entradas) {
            total += e.calculaValor();
        }
        return total;
    }

    // Verifica se o pedido está vazio
    public boolean isVazio() {
        return entradas.isEmpty();
    }

    // Associa um cliente ao pedido
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    /*devolve a lista de entradas que o pedido guarda internamente*/
    //questao de desmarcar
    public List<Entrada> getEntradas() {
    return entradas;
    }

    

    @Override
    public String toString() {
    
        return String.format("Total: R$ %.2f", calculaValorTotal());
    }
}