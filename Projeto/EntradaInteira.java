public class EntradaInteira extends Entrada {
    public EntradaInteira(int numeroDoAssento, double precoBase) {
        super(numeroDoAssento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase;
    }
    
}