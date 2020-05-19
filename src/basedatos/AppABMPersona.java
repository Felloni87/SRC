package basedatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AppABMPersona {

    public static final SimpleDateFormat FT_DB = new SimpleDateFormat ( "yyyy-MM-dd" );
    public static final SimpleDateFormat FT_APP = new SimpleDateFormat ( "dd-MM-yyyy" );

    public static void main(String[] args) throws Exception {

        Connection conexion;

        try {

            conexion = AdminBD.obtenerConexion();
            Scanner sc = new Scanner(System.in);
            int opcion = Menu(sc);

            while (opcion != 0) {

                switch (opcion) {

                    case 1:

                        Alta(conexion, sc);

                        break;

                    case 2:

                        modificar(conexion, sc);

                        break;

                    case 3:

                        Baja (sc);

                        break;

                    case 4:

                        Lista(conexion);

                        break;

                    case 5:

                        Buscar(conexion, sc);

                        break;

                    case 6:
                        Veder (conexion,sc);

                        break;

                    case 0:


                        break;


                    default:

                        System.out.println("Opcion incorrecta");

                        break;

                }
                opcion = Menu(sc);
            }
            conexion.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
//---------------------------------VENDER----------------------------------
    private static void Veder(Connection conexion, Scanner sc) throws ClassNotFoundException, SQLException {
        Scanner scan = new Scanner(System.in);

        Statement st = conexion.createStatement();

        System.out.println("Ingrese ID de la persona");
        int iD = scan.nextInt();
        ResultSet rs = st.executeQuery("select * from Persona WHERE ID= " + iD + ";");

        if (rs.next()) {
            System.out.println("Nombre de la persona seleccionada: " + rs.getString(2));
            System.out.println("Ingrese importe de la venta");
            float importe = scan.nextFloat();
            Date fecha = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fecha2 = ft.format(fecha);
            st.executeUpdate("Insert into Venta (Fecha, Importe, Id_persona) values ('" + fecha2 + "'," + importe
                    + "," + iD + ");");
            System.out.println("Nueva Venta guardada");
            conexion.close();

        } else {
            System.out.println("El ID no Existe, vuelva a intentarlo");

        }

    }

    // ---------------------------ALTA------------------------------------

    private static void Alta(Connection conexion, Scanner sc) throws Exception {

        System.out.println("=====ALTA DE PERSONA =====");

        System.out.println("Ingrese NOMBRE");
        String nombre = sc.next();
        System.out.println("Ingrese FECHA DE NACIMIENTO  DD-MM-AAAA");

        Date fechaNac = scanAndParseDate ( sc);
        int edad = calcularEdad(fechaNac);
        Statement stmt = conexion.createStatement();

        String sql = "INSERT INTO PERSONA (nombre,edad,fecha_nacimiento) VALUES ('" + nombre
                + "' , " + edad + ", '" + FT_DB.format ( fechaNac ) + "');";
        System.out.println ( "sql = " + sql );
        stmt.executeUpdate( sql );

        System.out.println("Usuario agregado con exito");
        System.out.println("==========================");
        System.out.println("¿QUE DESEA HACER EN EL SISTEMA)");
        System.out.println("1.Volver al Menu Principal");
        System.out.println("0.Salir del sistema");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                Menu (sc);
                break;

            case 0:
                System.out.println("GRACIAS POR USAR EL SISTEMA");
                break;

            default:
                System.out.println("OPCION INVALIDA");
                break;
        }


    }

    private static Date scanAndParseDate(Scanner sc) {
        String fNac  = sc.next ();
        try {
            return FT_APP.parse (fNac);
        }catch (ParseException e) {
            System.out.println ( "Fecha invalida. Reintentar:" );
            return scanAndParseDate ( sc );
        }
    }

    // ------------------------------MODIFICAR----------------------------------

    private static void modificar(Connection conexion, Scanner sc) {

        System.out.println("MODIFICACION");

        System.out.println("Ingrese el ID del usuario a modificar");
        int nIde = sc.nextInt();
        System.out.println("¿QUE DESEA MODIFICAR DEL USUARIO?");
        System.out.println("ingrese una opcion");
        System.out.println("1.NOMBRE");
        System.out.println("2.EDAD");
        System.out.println("3.FECHA DE NACIMIENTO");
        System.out.println("4. Todo");

        try {


            int opcion = sc.nextInt();
            Statement stmt = conexion.createStatement();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese nuevo nombre:");
                    String nom = sc.next ();
                    stmt = conexion.createStatement();
                    String insert = "UPDATE persona SET NOMBRE = '" + nom + "' WHERE ID=" + nIde + ";";
                    String nomNew = sc.next();

                    stmt = conexion.createStatement ();
                    insert = "UPDATE persona SET NOMBRE = '" + nomNew + "' WHERE ID=" + nIde + ";";
                    stmt.executeUpdate(insert);

                    conexion.close();


                    System.out.println("Su modificacion ha sido realizada exitosamente");
                    Menu(sc);
                    break;

                case 2:

                    System.out.println("Ingrese nueva edad");
                    int nuevaEdad = sc.nextInt();
                    stmt = conexion.createStatement();

                    stmt.executeUpdate("UPDATE persona SET EDAD = '" + nuevaEdad + "' WHERE ID = '" + nIde + "'");
                    conexion.close ();
                    System.out.println("Su modificacion ha sido realizada exitosamente");
                    Menu(sc);

                    break;

                case 3:

                    System.out.println("MODIFICAR FECHA DE NACIMIENTO");
                    System.out.println("Ingrese nueva fecha de nacimiento: dd-MM-yyyy");
                    String nuevaFecha = sc.next();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    Date nuevaFechaNac = sdf.parse(nuevaFecha);

                    int edad = calcularEdad(nuevaFechaNac);
                    stmt = conexion.createStatement();


                    stmt.executeUpdate("UPDATE persona SET FECHA_NACIMIENTO ='" + nuevaFecha + "', EDAD=" + edad + " WHERE ID=" + nIde
                            + ";");
                    conexion.close();

                    System.out.println("La modificacion fue exitosa");
                    modificar(conexion, sc);

                    break;
                default:
                    throw new IllegalStateException ( "Unexpected value: " + opcion );
            }
        } catch (SQLException e) {
            System.out.println("Error en la modificacion");

            // TODO Auto-generated catch block
            //e.printStackTrace();
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Error en la fecha de nacimiento");

        }

    }



    // --------------------------BAJA------------------------------

    private static void Baja(Scanner sc) {


        try{


            Connection conexion = AdminBD.obtenerConexion ();
            Statement stmt = conexion.createStatement();

            System.out.println ("===DAR DE BAJA===");

            System.out.println ("Ingrese el numero de ID del usuario a dar de bajar");
            int nIde = sc.nextInt();
            stmt.executeUpdate ("DELETE FROM persona WHERE id= " + nIde + " ");

            System.out.println("Baja realizada con exito");
            System.out.println("==========================");
            System.out.println("¿QUE DESEA HACER EN EL SISTEMA)");
            System.out.println("1.Dar de baja otra persona");
            System.out.println("2.Mostrar menu Principal");
            System.out.println("0.Salir del sistema");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Baja( sc);
                    break;

                case 2:
                    Menu(sc);

                case 0:
                    System.out.println("GRACIAS POR USAR EL SISTEMA");
                    break;

                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }


            conexion.close();

        } catch (ClassNotFoundException | SQLException e){

            e.printStackTrace();
        }
    }

    // --------------------------LISTA--------------------------

    private static void Lista(Connection conexion) {

        System.out.println("=====LISTA=====");

        System.out.println("ID===NOMBRE===EDAD===FECHA_NACIMIENTO");
        Statement stmt;

        try {

            stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONA");

            while (rs.next()) {

                Date fNac = rs.getDate(4);

                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                        + rs.getInt(3) + " " + fNac);

            }

            System.out.println("===LISTA FINAL===");

            System.out.println();

        } catch (SQLException e) {

            System.out.println("Error al mostrar lista");

        }

    }

    // -----------------------------BUSCAR----------------------------------

    private static void Buscar(Connection conexion, Scanner sc) {

        System.out.println("===BUSCAR===");

        System.out.println("Ingrese INICIALES a buscar");
        String buscarIni = sc.next();

        try {
            Statement stmt = conexion.createStatement();
            System.out.println("Usuario encontrado: ");
            ResultSet rs = stmt.executeQuery("SELECT * FROM persona WHERE nombre LIKE '"
                    + buscarIni	+ "%';");

            while(rs.next()) {
                System.out.println(rs.getInt(1)+ "" + rs.getString(2) + "" + rs.getInt(3) + "" + rs.getDate(4));
            }

            System.out.println("==========================");
            System.out.println("¿QUE DESEA HACER EN EL SISTEMA)");
            System.out.println("1.Buscar  otra persona");
            System.out.println("2.Mostrar menu principal");
            System.out.println("0.Salir del sistema");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Buscar(conexion, sc);
                    break;

                case 2:
                    Menu (sc);

                case 0:
                    System.out.println("GRACIAS POR USAR EL SISTEMA");
                    break;

                default:
                    System.out.println("OPCION INVALIDA");
                    break;

            }
        } catch (SQLException e) {

            System.out.println("Error al buscar registro");

        }
    }


    // ------------------CALCULO DE EDAD----------------------

    private static int calcularEdad(Date fechaNac) {
        GregorianCalendar fc = new GregorianCalendar();
        GregorianCalendar hoy = new GregorianCalendar();

        fc.setTime(fechaNac);

        int anActual = hoy.get(Calendar.YEAR);
        int anNac = fc.get(Calendar.YEAR);

        int mesActual = hoy.get(Calendar.MONTH);
        int mesNac = fc.get(Calendar.MONTH);

        int diaActual = hoy.get(Calendar.DATE);
        int diaNac = fc.get(Calendar.DATE);

        int dif = anActual - anNac;

        if (mesActual < mesNac) {

            dif = dif - 1;

        }

        else {

            if (mesActual == mesNac && diaActual < diaNac) {

                dif = dif - 1;
            }
        }
        return dif;
    }

    // --------------------MENU--------------------------------

    private static int Menu(Scanner sc) {

        System.out.println("BIENVENIDO AL SISTEMA DE PERSONAS (ABM)");

        System.out.println("=========================");

        System.out.println("¿QUE DESEA HACER EN EL SISTEMA");


        System.out.println("1:  ALTA ");

        System.out.println("2: MODIFICAR ");

        System.out.println("3:  BAJA");

        System.out.println("4: MOSTRAR LISTADO");

        System.out.println("5: BUSCAR EN LISTA");

        System.out.println("6: AGREGAR VENTA ");

        System.out.println("0: SALIR DEL SISTEMA");


        return sc.nextInt ();

    }

}