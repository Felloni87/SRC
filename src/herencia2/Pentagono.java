package herencia2;

public class Pentagono extends FiguraGeometrica {
    public Pentagono(int base) {
        super(base);
    }

    public float perimetro() {
        return getBase() * 5;
    }

    @Override
    public int obtenerCantidadLados() {
        return 5;
    }

}
