import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class Main {

    public static void main(String[] args){


        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ovchip", "postgres", "halloo");

            Statement myStmt = conn.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from reiziger");
            System.out.print("Alle Reizigers: " + "\n");

            while (myRs.next()){
                String tussen = myRs.getString("tussenvoegsel");
                if (tussen == null){
                    tussen = "";
                }
                System.out.println("#" + myRs.getString("reiziger_id") + ": " + myRs.getString("voorletters") + ". " + tussen + " " + myRs.getString("achternaam") + " (" + myRs.getString("geboortedatum") + ")");
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
