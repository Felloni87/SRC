package interfaz2;

public class Archivo implements Ejecutable  {

    @Override
    public void ejecutar(String texto) {

        System.out.println("ejecutando archivo con texto: " + texto);

    }
}
