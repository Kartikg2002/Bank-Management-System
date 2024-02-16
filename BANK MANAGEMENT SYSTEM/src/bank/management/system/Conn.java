package bank.management.system;
import java.sql.*;
public class Conn {
    private static final String url="jdbc:mysql://localhost:3306/bankmanagement";
    private static final String username="root";
    private static final String password="k@rtik2002";
    Connection connection;
    Statement statement;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        try{
            connection=DriverManager.getConnection(url,username,password);
            statement=connection.createStatement();   
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        Conn c=new Conn();
    }
}
