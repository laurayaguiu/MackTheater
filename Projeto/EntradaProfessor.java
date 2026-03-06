public class EntradaProfessor extends Entrada {
    public EntradaProfessor(int numeroDoAssento, double precoBase) {
        super(numeroDoAssento, precoBase);
    }

    @Override
    public double calculaValor() {
        return precoBase * 0.4; // professor paga 40% do valor da inteira
    }

}
