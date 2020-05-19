package herencia1;

public class AppHerencia {

    public static void main(String[] args) {

        Empleado emp1 = new Empleado();
        emp1.setNombre("A");
        emp1.setEdad(33);
        emp1.setSueldo(10000);

        Cliente cli1 = new Cliente();
        cli1.setEdad(22);
        cli1.setNombre("B");
        cli1.setSaldoCuenta(100);

    }

}
