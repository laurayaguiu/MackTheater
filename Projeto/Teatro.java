import java.util.ArrayList;
import java.util.List;

public class Teatro {

    private Pedido carrinhoAtual; 
    private Espetaculo espetaculoSelecionado; 
    private List<Espetaculo> listaEspetaculos;
    private List<Cliente> clientes; 

    public Teatro() {
        this.listaEspetaculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.carrinhoAtual = null;
        this.espetaculoSelecionado = null;
    }

    //getters
    public Pedido getCarrinhoAtual() {
        return carrinhoAtual;
    }

    public Espetaculo getEspetaculoSelecionado() {
        return espetaculoSelecionado;
    }

    public List<Espetaculo> getListaEspetaculos() {
        return listaEspetaculos;
    }

    public void adicionarEspetaculo(Espetaculo novoEspetaculo) {
        if (novoEspetaculo != null) listaEspetaculos.add(novoEspetaculo);
    }

    public void adicionarCliente(Cliente novoCliente) {
        if (novoCliente != null) clientes.add(novoCliente);
    }

    public void novaCompra() {
        this.carrinhoAtual = new Pedido();
    }

    //*
    public void apresentarEspetaculos() {
        if (listaEspetaculos.isEmpty()) {
            System.out.println("Nenhum espetáculo cadastrado ainda.");
        } else {
            System.out.println("\n=== ESPETÁCULOS CADASTRADOS ===");
             for (int i = 0; i < listaEspetaculos.size(); i++) { 
                Espetaculo e = listaEspetaculos.get(i);
                System.out.println((i + 1) + " - " + e.toString()); 
            }
        }
    }

    public boolean selecionaEspetaculo(int numero) {
        if (numero < 1 || numero > listaEspetaculos.size()) {
            return false;
        }

        
        this.espetaculoSelecionado = listaEspetaculos.get(numero - 1);
        
        novaCompra();
        return true;
    }

  
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

    
    public double finalizaCompra(String cpf) {
        if (carrinhoAtual == null || carrinhoAtual.isVazio()) {
            return 0.0;
        }

        
        Cliente cliente = encontraClientePorCpf(cpf);
        if (cliente == null) {
            for (Entrada e : carrinhoAtual.getEntradas()) {
            espetaculoSelecionado.desmarcarAssento(e.getNumeroDoAssento());
            }
            return -1.0;
        }

        
        carrinhoAtual.setCliente(cliente);
        cliente.adicionaPedido(carrinhoAtual);

        
        
        double total = carrinhoAtual.calculaValorTotal();

        
        carrinhoAtual = null;
        espetaculoSelecionado = null;

        return total;
    }

   
    public Cliente encontraClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }
}