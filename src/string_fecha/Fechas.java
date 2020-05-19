package string_fecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fechas {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("H:mm ss");

        Date ahora = new Date();

        long ahoraLong = System.currentTimeMillis();


        ahora.setTime(ahoraLong);
        long ahora2long = ahora.getTime();

        System.out.println(ahora);
        System.out.println(ahoraLong);
        System.out.println("format: "+ sdf.format(ahora));
        System.out.println("format2: "+ sdf2.format(ahora));
        System.out.println("format3: "+ sdf3.format(ahora));

        Date noventas = sdf.parse("11/11/1990");
        Date nov19 = sdf.parse("11/11/2019");
        Date dic19 = sdf.parse("11/11/2019");
        System.out.println("noventas " + noventas);
        if (nov19.before(noventas)) {
            System.out.println("la fecha es posterior");
        }
        else {
            System.out.println("la fecha es anterior");
        }

    }

}
