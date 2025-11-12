/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/

public class EntradaMeia extends Entrada {
    public EntradaMeia(int numeroDoAssento, double precoBase) {
        super(numeroDoAssento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase * 0.5;
    }

    @Override
    public String toString() {
        return String.format("Meia - Assento %d  - R$ %.2f", getNumeroDoAssento(), calculaValor());
    }
}