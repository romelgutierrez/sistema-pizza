package proyectopizzas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dr Efrain
 */
public class Conexion {
    private static Connection cnx = null;
   public static Connection conectar() {
      
      if (cnx == null) {
         
         try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3307/pizzeriazafari", "root", "");
             System.out.println("conexion satisfactoria");
         } catch (SQLException ex) {
           // throw new SQLException(ex);
             System.out.println(ex.getMessage());
         } catch (ClassNotFoundException ex) {
             System.out.println(ex.getMessage());
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
   public void registroTotal() throws ClassNotFoundException{
       
       try {
           
           cnx=conectar();
           
        Statement pst = cnx.createStatement();
        ResultSet rs=pst.executeQuery("select * from clientes");
        while(rs.next() ){
            System.out.println(rs.getString("nombre"));
        }
           
       }catch(Exception ex){
           
       }
   }
    
}










/*package proyectopizzas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    Connection enlazar = null;
    
    public Connection conectar(){
        try {
            if(enlazar != null){
                
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            Class.forName("com.mysql.jdbc.Driver");
                System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
            enlazar = DriverManager.getConnection("jdbc:mysql://localhost:3307/pizzeriazafari","root","");
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage() + " no fue posible establecer la conexion");
        }
        return enlazar;
    }
    
}*/
