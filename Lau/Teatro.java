

import java.util.ArrayList;
import java.util.List;

public class Teatro {
    private List<Pedido> carrinhos; // opcional histórico de carrinhos
    private Pedido carrinhoAtual;
    private Espetaculo espetaculoSelecionado;
    private List<Espetaculo> espetaculos;
    private List<Cliente> clientes;

    public Teatro() {
        this.espetaculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.carrinhos = new ArrayList<>();
        this.carrinhoAtual = null;
        this.espetaculoSelecionado = null;
    }

    public Espetaculo getEspetaculoSelecionado() {
        return espetaculoSelecionado;
    }

    public void adicionarEspetaculo(Espetaculo e) {
        if (e != null) espetaculos.add(e);
    }

    public void adicionarCliente(Cliente c) {
        if (c != null) clientes.add(c);
    }

    public void novaCompra() {
        this.carrinhoAtual = new Pedido();
    }

    public void apresentaEspetaculos() {
        if (espetaculos.isEmpty()) {
            System.out.println("Nenhum espetáculo cadastrado.");
            return;
        }
        for (int i = 0; i < espetaculos.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, espetaculos.get(i).toString());
        }
    }

    public boolean selecionaEspetaculo(int numero) {
        if (numero < 1 || numero > espetaculos.size()) {
            return false;
        }
        this.espetaculoSelecionado = espetaculos.get(numero - 1);
        novaCompra(); // inicia carrinho para essa compra
        return true;
    }

    /**
     * Tenta adicionar uma nova entrada ao carrinho atual a partir do espetáculo selecionado.
     * Retorna true se adicionou; false caso contrário.
     */
    public boolean novaEntrada(int tipo, int assento) {
        if (espetaculoSelecionado == null || carrinhoAtual == null) {
            return false;
        }
        Entrada entrada = espetaculoSelecionado.novaEntrada(tipo, assento);
        if (entrada == null) {
            return false;
        }
        carrinhoAtual.adicionaEntrada(entrada);
        return true;
    }

    /**
     * Finaliza compra: associa o pedido ao cliente de cpf informado e retorna o valor total.
     * Se cliente não encontrado, retorna -1.
     */
    public double finalizaCompra(String cpf) {
        if (carrinhoAtual == null || carrinhoAtual.isVazio()) {
            return 0.0;
        }
        Cliente cliente = encontraClientePorCpf(cpf);
        if (cliente == null) {
            return -1.0;
        }
        cliente.adicionaPedido(carrinhoAtual);
        carrinhos.add(carrinhoAtual);
        double total = carrinhoAtual.calculaValorTotal();
        carrinhoAtual = null;
        espetaculoSelecionado = null;
        return total;
    }

    private Cliente encontraClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }
}
