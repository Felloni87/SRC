package adivinar;

public class NumeroAleatorio {
    private int valor;
    private int intentos;

    public NumeroAleatorio(int valor) {
        this.valor = valor;
        this.intentos = 1;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void acumularIntento() {
        intentos++;
    }

}
