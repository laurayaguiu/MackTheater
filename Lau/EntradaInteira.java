/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/


public class EntradaInteira extends Entrada {
    public EntradaInteira(int numeroDoAssento, double precoBase) {
        super(numeroDoAssento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase;
    }

    @Override
    public String toString() {
        return String.format("Inteira - Assento %d  - R$ %.2f", getNumeroDoAssento(), calculaValor());
    }
}
