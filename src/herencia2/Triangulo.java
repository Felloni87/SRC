package herencia2;

public class Triangulo extends FiguraGeometrica {

    private int altura;

    public Triangulo(int base, int altura) {
        super(base);
        setAltura(altura);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public float area() {
        return getAltura() * getBase() / 2;
    }

    @Override
    public int obtenerCantidadLados() {
        return 3;
    }

}
