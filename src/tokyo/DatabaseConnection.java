/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokyo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Orlandi
 */
public class DatabaseConnection {

    private static DatabaseConnection connection;
    
    private String ip = "192.168.183.15";
    private String port = "1521";
    private String sid = "orcl";
    private String username = "8077925";
    private String password = "a";
    
    private DatabaseConnection() {
        
    }
    
    public static DatabaseConnection getInstance() {
        if(connection == null) {
            connection = new DatabaseConnection();
        }
        
        return connection;
    }
    
    public Statement getStatement() {
        Statement statement = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid,
                    username, password);
            
            System.err.println("Connected to: "
                    + "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid
                    + "\nUsername: " + username + "\n");
            
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.err.println("Fail to connect: " + ex.getMessage());
        }
        
        return statement;
    }
    
    public ResultSet select(String script) {
        Statement statement = DatabaseConnection.getInstance().getStatement();
        ResultSet resultSet = null;
        
        try {
            resultSet = statement.executeQuery(script);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return resultSet;
    }
}
