public class Assento {
    private boolean ocupado;

    public Assento (boolean ocupado) {
        this.ocupado = false;
    }
    public boolean isOcupado() {
        return ocupado;
    }

    public void marcarComoOcupado() {
        this.ocupado = true;
    }

    public void desmarcar() {
        this.ocupado = false;
    }
}