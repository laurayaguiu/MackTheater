import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Entrada> entradas; //guarda os ingressos comprados no pedido
    private Cliente cliente; //quem fez a compra

    public Pedido() {
        this.entradas = new ArrayList<>();
        this.cliente = null;
    }

    public void adicionaEntrada(Entrada entrada) {
        if (entrada != null) {
            entradas.add(entrada);
        }
    }

    public double calculaValorTotal() {
        double total = 0.0;
        for (Entrada e : entradas) {
            total += e.calculaValor();
        }
        return total;
    }

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

    public List<Entrada> getEntradas() {
    return entradas;
    }


    @Override
    public String toString() {
    
        return String.format("Total: R$ %.2f", calculaValorTotal());
    }
}
