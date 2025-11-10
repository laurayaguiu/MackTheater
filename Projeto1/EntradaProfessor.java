public class EntradaProfessor extends Entrada {
    public EntradaProfessor(int numeroDoAssento, double precoBase) {
        super(numeroDoAssento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase * 0.4; // professor paga 40% do valor da inteira
    }

    @Override
    public String toString() {
        return String.format("Professor - Assento %d  - R$ %.2f", getNumeroDoAssento(), calculaValor());
    }
}