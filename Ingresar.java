
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ingresar{

public static void main(String[] args){
Login();

}

public static void Login(){
   Scanner sc= new Scanner(System.in);
   System.out.println("Ingrese su usuario: ");
   String us=sc.nextLine();
   System.out.println("Ingrese su contrasenia: ");
   String passw=sc.nextLine();
   String orden="Select * FROM Usuario";
   //conexion
    try{
    String dbClassName = "com.mysql.jdbc.Driver";
    String CONNECTION ="jdbc:mysql://52.14.132.218:3306/proyecto?autoReconnect=true&useSSL=false";
    Class.forName(dbClassName);
    // Properties for user and password. Here the user and password are both 'paulr'
    Properties p = new Properties();
    p.put("user","invitado");
    p.put("password","password");
    // Now try to connect
    Connection c = DriverManager.getConnection(CONNECTION,p);
    //crear objeto statement
    Statement myStatement=c.createStatement();
    //excecute query
    ResultSet myResultSet=myStatement.executeQuery(orden);
    String Usuario="";
    String Contrase="";
    while (myResultSet.next()){
        if((myResultSet.getString("Usuario")).equals(us)){
        Usuario="T";
        }
        if((myResultSet.getString("Pass")).equals(passw)){
        Contrase="T";
        }
    }
    System.out.println("Exito");
    c.close();
    if(Usuario.equals("T") && Contrase.equals("T")){
        System.out.println("Ingreso EXITOSO!");
    }else{
        System.out.println("Credenciales INCORRECTAS");
    }

    }catch(Exception e){
      e.printStackTrace();
    }
}
}
