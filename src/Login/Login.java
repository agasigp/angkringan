/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Helper.Md5Hash;
import Koneksi.Koneksi;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agasigp
 */
public class Login {
    public static boolean login(String username, String password) {
        Koneksi connection = new Koneksi();
        connection.getConnection();
        
        try {
            String query = "SELECT * FROM user WHERE username = ?";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            
            if (preparedStatement.getResultSet().next()) {
                String passwordHash = Md5Hash.md5(password);
                
                if (passwordHash.equals(preparedStatement.getResultSet().getString("password"))) {
                    return true;
                } else {
                    return false;
                }
                
            } else {
                return false;
            }  
        } catch (SQLException e) {
            System.out.println("Data gagal ditampilkan : " + e.getMessage());
//            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
