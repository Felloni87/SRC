package recorrido;

public class Recorrido {

    protected String origen;
    protected String destino;
    protected float precio;

    public Recorrido(String ori, String dest, float prec) {
        origen = ori;
        destino = dest;
        precio = prec;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
