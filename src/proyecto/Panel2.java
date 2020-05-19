package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Panel2 {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appventas", "root", "");
        } catch (Exception e) {
            System.out.println("No hay conexion con la base");
        }

        return con;
    }

    public static void main(String[] args) {
        // Create frame with title Registration Demo
        JFrame frame = new JFrame();
        frame.setTitle("COMERCIO");

        // Panel to define the layout. We are using GridBagLayout
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        JPanel titulo = new JPanel();
        JLabel headingLabel = new JLabel("Listado de productos");
        titulo.add(headingLabel);

        // Panel to define the layout. We are using GridBagLayout
        JPanel columnas = new JPanel(new GridBagLayout());

        // Constraints for the layout
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(25, 25, 25, 25);
        constr.anchor = GridBagConstraints.WEST;

        // Set the initial grid values to 0,0
        constr.gridx = 0;
        constr.gridy = 0;

        JLabel imagen = new JLabel("Imagen  ");
        columnas.add(imagen, constr);
        constr.gridx = 1;
        JLabel artiulo = new JLabel("Articulo");
        columnas.add(artiulo, constr);
        constr.gridx = 2;
        JLabel descripcion = new JLabel("Descripcion");
        columnas.add(descripcion, constr);
        constr.gridx = 3;
        JLabel cantidad = new JLabel("Cantidad");
        columnas.add(cantidad, constr);
        constr.gridx = 4;
        JLabel precio = new JLabel("Precio");
        columnas.add(precio, constr);
        constr.gridx = 5;

        JLabel agrega = new JLabel("Agrega cantidad");
        columnas.add(agrega, constr);
        constr.gridx = 5;

        JCheckBox check = new JCheckBox();

        JComboBox combo;
//		panel.add(check, constr);
        constr.gridx = 0;

        // consultar la base
        Connection connection = getConnection();
        ResultSet rst = null;

        JScrollPane scroll = new JScrollPane(columnas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        int i = 1;
        try {
            Statement stmt = connection.createStatement();
            rst = stmt.executeQuery("select * from producto");

            // recorrer resultados de la base
            while (rst.next()) {
                if (rst.getInt(6) > 0) {

                    constr.gridy = i;
//			tomar imagen de la base
//			imagen = new JLabel("Foto Producto " + i);
                    imagen = new JLabel("");
                    columnas.add(imagen, constr);
                    constr.gridx = 1;
                    artiulo = new JLabel(rst.getString(2));
                    artiulo.setName("producto" + i);
                    columnas.add(artiulo, constr);
                    constr.gridx = 2;
                    descripcion = new JLabel(rst.getString(4));
                    columnas.add(descripcion, constr);
                    constr.gridx = 3;
                    cantidad = new JLabel("" + rst.getInt(6));
                    columnas.add(cantidad, constr);
                    constr.gridx = 4;
                    combo = new JComboBox();
                    combo.setName("cantidad" + i);

                    for (int j = 0; j <= rst.getInt(6); j++) {
                        combo.addItem("" + (j));
                    }
                    precio = new JLabel(String.valueOf(rst.getFloat(5)));
                    columnas.add(precio, constr);
                    constr.gridx = 5;
                    columnas.add(combo, constr);
                    constr.gridx = 0;

                    i++;
                }
            }
            // Declare the required Labels
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        constr.gridwidth = 5;
        constr.anchor = GridBagConstraints.CENTER;

//		JButton button = new JButton("Identificarse");
        JButton buttonCarrito = new JButton("Carrito");
        // add a listener to button
        buttonCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Component item;
                Component[] componentes = null; //columnas.getComponents();
                JComboBox comboCantidad;
                String nombreCombo;
                List<String> listado = new ArrayList<String>();
                for (int j = 0; j < componentes.length; j++) {
                    item = componentes[j];
                    if (item instanceof JComboBox) {
                        comboCantidad = ((JComboBox) item);
                        String valor = (String) comboCantidad.getSelectedItem();
                        int valInt = Integer.valueOf(valor);

                        if (valInt > 0) {
                            nombreCombo = comboCantidad.getName();
                            String numeroLinea = nombreCombo.substring(8);
                            String descripcion = buscarDescripcion(componentes, numeroLinea);
                            System.out.println(descripcion);
                            listado.add(descripcion);

                        }
                    }
                }
            }

            private String buscarDescripcion(Component[] componentes, String numeroLinea) {
                Component item;

                String nombre = "";
                String desc = "";
                JLabel label;
                for (int j = 0; j < componentes.length; j++) {

                    item = componentes[j];
                    nombre = item.getName();
                    if (nombre !=null && nombre.equals("producto" + numeroLinea)) {
                        desc = item.getName();
                        label = (JLabel)item;
                        System.out.println(label.getText());
                    }
                }

                return desc;
            }
        });

        // Add label and button to panel
//		panel.add(button, constr);
//		JScrollPane scroll = new JScrollPane();
//		scroll.add(panel);
        JPanel boton = new JPanel();
//		footerPanel.add(button);
        boton.add(buttonCarrito);
        panelPrincipal.add(titulo);
//		mainPanel.add(panel);
        panelPrincipal.add(scroll);
        panelPrincipal.add(boton);

        // Add panel to frame
        frame.add(panelPrincipal);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


