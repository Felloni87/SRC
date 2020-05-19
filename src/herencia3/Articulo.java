package herencia3;

import java.awt.*;

public class Articulo extends Vineta {

    private String autor;
    private String titulo;
    private String cuerpo;

    public Articulo(String autor, String titulo, String cuerpo,
                    String imagen, String link, String seccion, String posicion,
                    Dimension dimension) {
        super(imagen, link, seccion, posicion, dimension);
        this.autor = autor;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String toString() {
        return "Art. seccion: " + seccion +  " titulo: " + titulo + '\n' + "Autor: " + autor;
    }

    @Override
    public boolean esFacturable() {
        return false;
    }

}

