package travel.management.system;
import java.sql.*; 

public class conn {
    Connection c;
    Statement s;
    conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");                                //regustring the driver
            c =DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","1234"); 
            s = c.createStatement(); 
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
