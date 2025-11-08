

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Entrada> entradas;

    public Pedido() {
        this.entradas = new ArrayList<>();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entrada e : entradas) {
            sb.append(e.toString()).append("\n");
        }
        sb.append(String.format("Total: R$ %.2f", calculaValorTotal()));
        return sb.toString();
    }
}
