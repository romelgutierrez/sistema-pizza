
package proyectopizzas;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Lista extends javax.swing.JInternalFrame {

  Conexion enlace = new Conexion();
    
    public Lista() {
        initComponents();
   
        String[] columnas=new String[] {"ID", "Producto", "U. Med", "Precio", "Stock"};
        tablaListaPedidos = new JTable(reporteDatos(), columnas);
        this.invalidate();
        this.validate();
        this.repaint();
       /*  Object[][] rowData = {};
    Object[] columnNames = { "Column 1", "Column 2", "Column 3" };

    DefaultTableModel listTableModel;
    listTableModel = new DefaultTableModel(rowData, columnNames);
    for (int i = 1; i < 25; i++) {
      String rowString = "Quiz #" + i;
      listTableModel.addRow(new Object[] { rowString, "ICON", "ICON" });
    }*/
        
        //mostrarDatosLista(0,null);
    }public Object[][] reporteDatos(){

        Object[][] data=new Object[][]{
            {1, "Celular", 20, 560.50, "Huawei"},
            {2, "Laptop", 10, 1500, "Samsung"},
            {3, "Celular", 20, 560.50, "Huawei"},
            {4, "Celular", 20, 560.50, "Huawei"}
        };        
        return data;
    }
     
    public void mostrarDatosLista(int opbuscar, String valor){     
          Connection conect = enlace.conectar();
    
        
        DefaultTableModel tlista = new DefaultTableModel();
        tlista.addColumn("NOMBRE");
        tlista.addColumn("PIZZA");
        tlista.addColumn("CANTIDAD");
        tlista.addColumn("TAMAÑO");
        tlista.addColumn("BEBIDA");
        tlista.addColumn("MESA");
        tlista.addColumn("PRECIO");
       tablaListaPedidos.setModel(tlista);
       
       String codsql="";
       
       if ( opbuscar ==0 && valor == null){
           codsql = "SELECT * FROM contenidodepedido";
           System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
       }else{
           System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
           if(opbuscar == 1 && valor != null){
               codsql = "SELECT * FROM contenidodepedido WHERE NOMBRE = '"+valor+"'";
           }else{
                     if(opbuscar == 6 && valor != null){
               codsql = "SELECT * FROM contenidodepedido WHERE MESA = '"+valor+"'";
                }
       }
           System.out.println("cccccccccccccccccccccccccccccccccccccccccccccccccccc");
       String []datos = new String[7];
        try {
            System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddddddd");
            PreparedStatement ps= conect.prepareStatement(codsql);
            
            //Statement leer = conect.createStatement();
            ResultSet resultado = ps.executeQuery();
            
            while (resultado.next()){
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                datos[6] = resultado.getString(7);
                tlista.addRow(datos);
            }
               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e +"error en la consulta");
        }
    }
    }
     public void actualizardatos(){
         int fila = tablaListaPedidos.getSelectedRow();
         
         int nom = Integer.parseInt(this.tablaListaPedidos.getValueAt(fila, 0).toString());
         String pizz = tablaListaPedidos.getValueAt(fila, 1).toString();
         String cant = tablaListaPedidos.getValueAt(fila, 2).toString();
         String tam = tablaListaPedidos.getValueAt(fila, 3).toString();
         String beb = tablaListaPedidos.getValueAt(fila, 4).toString();
         String mez = tablaListaPedidos.getValueAt(fila, 5).toString();
         String pre = tablaListaPedidos.getValueAt(fila, 6).toString();
     }
   public void reportarproductos(){
       System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
       enlace = new Conexion();
    Connection conect = enlace.conectar();
    List<tablalista> ad = new ArrayList();
        try {
            System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
            
            PreparedStatement ps= conect.prepareStatement("SELECT * FROM listadepedidos");
            
            ResultSet rs = ps.executeQuery();
            System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
           // tablaListaPedidos = new JTable(buildTableModel(rs));
          Object[][] rowData = {};
    Object[] columnNames = { "Column 1", "Column 2", "Column 3" };

    DefaultTableModel listTableModel;
    listTableModel = new DefaultTableModel(rowData, columnNames);
    for (int i = 1; i < 25; i++) {
      String rowString = "Quiz #" + i;
      listTableModel.addRow(new Object[] { rowString, "ICON", "ICON" });
    }
   
    tablaListaPedidos = new JTable(listTableModel);
            System.out.println("cccccccccccccccccccccccccccccccccc");
        } catch (Exception e) {
        }
   }
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        System.out.println("colum"+metaData.getColumnName(column));
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        System.out.println("ppppppppppppppppppppppppppppppp");
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }
        System.out.println("dadsadasdasdasdsadasdasdsadsa");
    return new DefaultTableModel(data, columnNames);

}
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuContextual = new javax.swing.JPopupMenu();
        opActualizar = new javax.swing.JMenuItem();
        opEliminar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaPedidos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        comboOpcion = new javax.swing.JComboBox<>();
        campoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        opActualizar.setText("actualizar datos");
        opActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opActualizarActionPerformed(evt);
            }
        });
        menuContextual.add(opActualizar);

        opEliminar.setText("Eliminar cliente");
        menuContextual.add(opEliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("lista de pedidos");

        tablaListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaListaPedidos.setComponentPopupMenu(menuContextual);
        jScrollPane1.setViewportView(tablaListaPedidos);

        comboOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar Todo", "Nombre" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton1.setText("pagar");

        jButton2.setText("actualizar datos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(comboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(campoBuscar)
                            .addComponent(comboOpcion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       reportarproductos();
       int opcion = comboOpcion.getSelectedIndex();
       String valorbus = campoBuscar.getText();
       //mostrarDatosLista(opcion, valorbus);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void opActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opActualizarActionPerformed
   
    }//GEN-LAST:event_opActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JComboBox<String> comboOpcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuContextual;
    private javax.swing.JMenuItem opActualizar;
    private javax.swing.JMenuItem opEliminar;
    private javax.swing.JTable tablaListaPedidos;
    // End of variables declaration//GEN-END:variables
}
