/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author agasigp
 */
public class Koneksi {
    public Connection connection;
    
    String username = "homestead";
    String password = "secret";
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:33060/tokring";
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.print("Koneksi dengan database gagal : ");
            System.err.println(e.getException());
        }
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi berhasil");
        } catch (SQLException e) {
            System.err.println("Username/password database anda salah " + e.getMessage());
        }
        
        return connection;
    }
}
