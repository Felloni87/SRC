package recorrido;

public class Transporte extends Recorrido {

    public Transporte(String ori, String dest, float prec) {
        super(ori, dest, prec);
    }

    public String toString() {
        return origen + " - " + destino + " - " + precio;
    }
}
