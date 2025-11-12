/*
Laura Rocha Yaguiu RA:10736399
Janaína Passos RA: 10737888
Bárbara Passos RA: 10737885
*/

// class abs apenas para questoes de herança
public abstract class Entrada {
    protected int numeroDoAssento;
    protected double precoBase;

    public Entrada(int numeroDoAssento, double precoBase) {
        this.numeroDoAssento = numeroDoAssento;
        this.precoBase = precoBase;
    }

    public int getNumeroDoAssento() {
        return numeroDoAssento;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calculaValor();
}