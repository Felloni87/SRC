package herencia3;


import java.awt.*;
import java.util.Scanner;

/**
 * En el periodico tenemos anuncios y notas. Se pueden publicar en 5 vi�etas por
 * dia. Se solicita generar la estructura de clases que soporte la informacion
 * necesaria Ingresar por teclado los datos y se cargan las 5 posiciones de las
 * vi�etas del periodico, mostrar el contenido de todas
 *
 */
public class AppPeriodico {

    public static void main(String[] args) {
        System.out.println("APLICACION PERIODICO");
        Vineta[] pagina = new Vineta[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < pagina.length; i++) {
            System.out.println("Tipo (1=Publicidad 2=Articulo)");
            int tipo = sc.nextInt();

            System.out.println("Seccion:");
            String seccion = sc.next();
            // el resto de los atributos

            switch (tipo) {
                case 1: {
                    System.out.println("Auspiciante:");
                    String ausp = sc.next();
                    System.out.println("Precio:");
                    float precio = sc.nextFloat();
                    Publicidad pub = new Publicidad("", "", seccion, "", new Dimension(4, 2), ausp, precio);
                    pagina[i] = pub;
                    break;
                }
                case 2: {
                    System.out.println("Titulo:");
                    String titulo = sc.next();
                    System.out.println("Autor:");
                    String autor = sc.next();
                    System.out.println("Cuerpo:");
                    String cuerpo = sc.next();
                    Articulo art = new Articulo(titulo, autor, cuerpo, "", "", seccion, "", new Dimension(2, 2));
                    pagina[i] = art;

                    break;
                }

                default:
                    break;
            }
        }

        float total = 0;
        Publicidad itemPubli;

        for (int i = 0; i < pagina.length; i++) {
            System.out.println(pagina[i]);

            if (pagina[i].esFacturable()) {
                //casting para convertir el objeto Vi�eta
                itemPubli = (Publicidad) pagina[i];
                total += itemPubli.getPrecio();
            }
        }

        System.out.println("El total facturado es: " + total);

    }

}
