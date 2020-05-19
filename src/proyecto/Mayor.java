package proyecto;

import java.util.Scanner;

public class Mayor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("APLICACION DE NUMERO MAYOR");
        System.out.println("==========================");
        System.out.print("Ingrese un numero (1): ");
        int varA = sc.nextInt();
        System.out.print("Ingrese un numero (2) : ");
        int varB = sc.nextInt();
        System.out.print("Ingrese un numero (3): ");
        int varC = sc.nextInt();
        int varM;
        if (varA > varB && varA > varC) {
            varM = varA;
        } else {
            if (varB > varC) {
                varM = varB;
            } else {
                varM = varC;
            }
        }
        System.out.println("El numero Mayor es : " + varM);
    }
}

