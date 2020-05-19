package proyecto;

import java.util.Scanner;

public class AlumnoPromedio {
    int nota1;
    int nota2;
    int nota3;
    String nombre;
    float promedio;

    public AlumnoPromedio() {

    }

    public AlumnoPromedio(int n1, int n2, int n3) {
        nota1 = n1;
        nota2 = n2;
        nota3 = n3;
        calcularPromedio(n1, n2, n3);
    }

    private void calcularPromedio(int n1, int n2, int n3) {
        float total = n1 + n2 + n3;
        promedio = total / 3;
    }

    public AlumnoPromedio(int n1, int n2, int n3, String nombre) {
        nota1 = n1;
        nota2 = n2;
        nota3 = n3;
        this.nombre = nombre;
        calcularPromedio(n1, n2, n3);
    }

    public AlumnoPromedio(String mensaje) {

    }

    public static void main(String[] args) {
        System.out.println("Ingrese cantidad de alumnos:");
        Scanner scan = new Scanner(System.in);
        int cant = scan.nextInt();
        AlumnoPromedio[] ap = new AlumnoPromedio[cant];

        for (int i = 0; i < ap.length; i++) {
            System.out.println("Ingresar nombre alumno:");
            String nom = scan.next();
            System.out.println("Ingresar nota1:");
            int nota1 = scan.nextInt();
            System.out.println("Ingresar nota2:");
            int nota2 = scan.nextInt();
            System.out.println("Ingresar nota3:");
            int nota3 = scan.nextInt();

            ap[i] = new AlumnoPromedio(nota1, nota2, nota3, nom);
        }

        String nom;
        int not1;
        System.out.println("RESULTADOS " + '\n');
        System.out.println("==========");
        for (int i = 0; i < ap.length; i++) {
            nom = ap[i].getNombre();
            not1 = ap[i].getNota1();
            System.out.println(nom + " " + not1 + " " + ap[i].getNota2() + " " + ap[i].getNota3() + " [" +
                    ap[i].getPromedio());

        }

    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

}
