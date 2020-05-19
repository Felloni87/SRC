package herencia2;

public class Cuadrado extends FiguraGeometrica {
    public Cuadrado(int base) {
        super(base);
    }

    public float area() {
        return getBase() * getBase();
    }

    public float perimetro() {
        return getBase() * 4;
    }

    @Override
    public int obtenerCantidadLados() {
        return 4;
    }

}
