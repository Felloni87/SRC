package excepciones;

public class AppException {

    public static void main(String[] args) {

//		int valor = 5;
//		int divisor = 0;
//		System.out.println(valor/divisor);

        Pasaje[] micro = new Pasaje[40];

        // PEDIR DATOS DEL PASAJERO
        Pasaje pas = new Pasaje();
        pas.setDni("123");
        pas.setNombre("ABC");
        try {

            VentaPasaje vp = new VentaPasaje();
            vp.vender(micro, pas);

        } catch (Exception e) {


        }
        finally {
            // MAS CODIGO
            System.out.println("PRUEBA FINALLY");
        }
    }
}


