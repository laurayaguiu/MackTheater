/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/


import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;//*
    private String cpf;//*
    private List<Pedido> pedidos; //do cliente em específico

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }

    // getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    //adicionar uma compra à lista do cliente.
    public void adicionaPedido(Pedido pedido) {
        if (pedido != null && !pedido.isVazio()) {
            pedidos.add(pedido);
        }
    }

    @Override
    public String toString() {
        return String.format ("Nome : %s \n CPF: %s", getNome(), getCpf());
    }
}