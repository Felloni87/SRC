package recorrido;

public class Turistico  extends Recorrido {

    private String nombre;

    public Turistico(String ori, String dest, float prec, String nombre) {
        super(ori, dest, prec);
        setNombre(nombre);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return origen + " - " + destino + " - " + precio + " - " + this.nombre;
    }
}