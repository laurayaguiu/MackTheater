public class EntradaMeia extends Entrada {
    public EntradaMeia(int numeroDoAssento, double precoBase) {
        super(numeroDoAssento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase * 0.5;
    }

}