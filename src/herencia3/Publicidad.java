package herencia3;

import java.awt.*;

public class Publicidad extends Vineta {

    private String auspiciante;
    private float precio;


    public Publicidad(String imagen, String link, String seccion, String posicion, Dimension dimension,
                      String auspiciante, float precio) {
        super(imagen, link, seccion, posicion, dimension);
        this.auspiciante = auspiciante;
        this.precio = precio;
    }

    public String getAuspiciante() {
        return auspiciante;
    }

    public void setAuspiciante(String auspiciante) {
        this.auspiciante = auspiciante;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Publicidad: Seccion: " + seccion + " Auspiciante: " + auspiciante + '\n' + "Precio: $" + precio;
    }

    public boolean esFacturable() {

        return true;
    }

}

