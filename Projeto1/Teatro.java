/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/

import java.util.ArrayList;
import java.util.List;

public class Teatro {

    private Pedido carrinhoAtual; //pedido atual *
    private Espetaculo espetaculoSelecionado; //Espetáculo da compra *
    private List<Espetaculo> listaEspetaculos; //guarda todos os espetáculos 
    private List<Cliente> clientes; //Guarda todos os clientes

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

    // add novo espetaculo a lista
    public void adicionarEspetaculo(Espetaculo novoEspetaculo) {
        if (novoEspetaculo != null) listaEspetaculos.add(novoEspetaculo);
    }

    // add novo cliente a lista
    public void adicionarCliente(Cliente novoCliente) {
        if (novoCliente != null) clientes.add(novoCliente);
    }

    // cria pedido vazio ("canhirro de compras novo")*
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
    //.size() devolve a quantidade de elementos , estilo .length mas agr com ArrayList
    //get(i) acessa um objeto específico dentro da lista
    //toString() da classe Espetaculo

    //*
    // quando cliente seleciona um espetáculo
    public boolean selecionaEspetaculo(int numero) {
        //validacao
        if (numero < 1 || numero > listaEspetaculos.size()) {
            return false;
        }

        // pega o valor (espetaculo) da posicao correta da lista e armazena em espetaculoSelecionado
        this.espetaculoSelecionado = listaEspetaculos.get(numero - 1);
        
        // novo carrinho para espetáculo especificado
        novaCompra();
        return true;
    }

    //*
    // novo ingr ao carrinho atual
    public boolean novaEntrada(int tipo, int assento) {
        //validacao
        if (espetaculoSelecionado == null || carrinhoAtual == null) {
            return false;
        }
        // cria um obj do tipo entrada q recebe uma nova entrada para o espetáculo selecionado
        Entrada entrada = espetaculoSelecionado.novaEntrada(tipo, assento);
       
        //validacao
        if (entrada == null) {
            return false;
        }
        //adiciona a entrada no pedido atual
        carrinhoAtual.adicionaEntrada(entrada);
        return true;
    }

    //*
    public double finalizaCompra(String cpf) {
        // verifica se carrinho n esta vazio
        if (carrinhoAtual == null || carrinhoAtual.isVazio()) {
            return 0.0;
        }

        // busca cliente
        Cliente cliente = encontraClientePorCpf(cpf);
        if (cliente == null) {
            for (Entrada e : carrinhoAtual.getEntradas()) {
            espetaculoSelecionado.desmarcarAssento(e.getNumeroDoAssento());
            }
            return -1.0;
        }

        // associa carrinnho ao cliente
        carrinhoAtual.setCliente(cliente);
        cliente.adicionaPedido(carrinhoAtual);

        
        // calcula valor
        double total = carrinhoAtual.calculaValorTotal();

        // zera - limpa 
        carrinhoAtual = null;
        espetaculoSelecionado = null;

        return total;
    }

    //Procura o cliente dentro da lista clientes comparando o CPF
    public Cliente encontraClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            // verifica se o cpf em questao é igual ao que estou querendo e devolve esse cliente
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }
    //c.getCpf() é cpf q estou passando
    //.equals() usa para comparação, nao se usa ==
}