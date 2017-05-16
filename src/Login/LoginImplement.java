/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Helper.Md5Hash;
import Helper.UserSession;
import Koneksi.Koneksi;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author agasigp
 */
public class LoginImplement implements LoginInterface {

    @Override
    public boolean login(String username, String password) {
        Koneksi connection = new Koneksi();
        connection.getConnection();
        
        try {
            String query = "SELECT * FROM user WHERE username = ?";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            
            if (preparedStatement.getResultSet().next()) {
                String passwordHash = Md5Hash.md5(password);
                
                UserSession.setUsername(preparedStatement.getResultSet().getString("username"));
                UserSession.setUserId(preparedStatement.getResultSet().getString("id"));

                return passwordHash.equals(preparedStatement.getResultSet().getString("password"));
                
            }
        } catch (SQLException e) {
            System.out.println("Data gagal ditampilkan : " + e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            
        }
        
        return false;
    }
}
