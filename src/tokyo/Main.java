/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokyo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Orlandi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.183.15:1521:orcl",
                    "8077925",
                    "a");
            System.err.println("Connected");
            Statement stmt = connection.createStatement();
        } catch (Exception ex) {
            System.err.println("Fail to connect: " + ex.getMessage());
        }*/
        
        DatabaseConnection d = DatabaseConnection.getInstance();
        d.getStatement();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
}
