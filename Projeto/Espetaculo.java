public class Espetaculo {

    
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean [50] assentos; 

    //construtor
    public Espetaculo(String nome, String data, String hora, double preco){
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
    }

    public double getPreco(){
        return preco;
    }

    public String toString(){
        return "Espetáculo: " + nome + "\n" + 
            "Data: " + data + "\n" +
            "Hora:" + hora + "\n" + 
            "Preço da entrada inteira: R$ " + preco; 
    }

    public void apresentaAssentos(){
        
    }
    
    public Entrada novaEntrada(int tipo, int assento){

    }

    private void marcarAssento(int assento){

    }
    


}
