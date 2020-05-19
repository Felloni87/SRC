package string_fecha;

import java.util.Scanner;

public class Mayuscula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        String nombre = sc.next();
        System.out.println("Ingrese su apellido");
        String apellido = sc.next();

        char inicialNombre = nombre.charAt(0);
        char inicialApellido = apellido.charAt(0);

        String inicialNom = String.valueOf(inicialNombre);
        String inicialApe = "" + inicialApellido;

        String mayusIniNom = inicialNom.toUpperCase();
        String mayusIniApe = inicialApe.toUpperCase();

        nombre = nombre.toLowerCase();
        apellido = apellido.toLowerCase();

        nombre = nombre.substring(1);
        apellido = apellido.substring(1);

        System.out.println(mayusIniApe + apellido + ", " + mayusIniNom + nombre);
    }

}
