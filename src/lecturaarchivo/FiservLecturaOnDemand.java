package lecturaarchivo;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FiservLecturaOnDemand {
    public static void main(String[] args) {
        try {
            File file = new File("c:\\datos\\fd\\reporte.txt"); // creates a new file instance
            File fileOut = new File("c:\\datos\\fd\\reporteOut.txt"); // creates a new file instance
            FileReader fr = new FileReader(file); // reads the file
            FileWriter frOut = new FileWriter(fileOut); // reads the file
            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            BufferedWriter wbr = new BufferedWriter(frOut); // creates a buffering character input stream
            StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
            String line;
            int count = 0;
            int amount = 0 ;
            Map<String, Integer> mapa = new HashMap<String, Integer>();
            while ((line = br.readLine()) != null) {

                Integer cantLinea = mapa.get(line);

                if (cantLinea == null) {
                    mapa.put(line, new Integer(1));
                }
                else {
                    amount = cantLinea + 1;
                    mapa.put(line, new Integer(amount));
                }
//				sb.append(line); // appends line to string buffer
//				sb.append("\n"); // line feed
            }

            Set<String> keys = mapa.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String clave = it.next();
                frOut.write(clave + " " + '\t' + mapa.get(clave)+ '\n');
            }

            fr.close(); // closes the stream and release the resources
            frOut.close(); // closes the stream and release the resources
            System.out.println("Contents of File: " + count);
//			System.out.println(sb.toString()); // returns a string that textually represents the object
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
