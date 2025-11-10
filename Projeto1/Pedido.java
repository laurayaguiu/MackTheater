import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Entrada> entradas;
    private String cpfCliente; // será preenchido ao finalizar

    public Pedido() {
        this.entradas = new ArrayList<>();
        this.cpfCliente = "";
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

    public void setCpfCliente(String cpf) {
        this.cpfCliente = cpf;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void mostrarResumo() {
        System.out.println("\n=== RESUMO DO PEDIDO ===");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        for (Entrada e : entradas) {
            texto.append(e.toString()).append("\n");
        }
        texto.append(String.format("Total: R$ %.2f", calculaValorTotal()));
        if (cpfCliente != null && !cpfCliente.isEmpty()) {
            texto.append("\nCPF do Cliente: ").append(cpfCliente);
        }
        return texto.toString();
    }
}