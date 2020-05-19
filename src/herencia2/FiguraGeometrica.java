package herencia2;

public  abstract class FiguraGeometrica {
    protected int base;

    public abstract int obtenerCantidadLados();

    public FiguraGeometrica(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

}
