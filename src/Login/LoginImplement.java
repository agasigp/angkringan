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
    // Implementasi dari method login
    public boolean login(String username, String password) {
        // Membuat koneksi ke database
        Koneksi connection = new Koneksi();
        connection.getConnection();
        
        try {
            // Query untuk menampilkan user berdasarkan username
            String query = "SELECT * FROM user WHERE username = ?";
            
            // Menyiapkan prepared statement kemudian mengeksekusinya
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            
            // Jika data user ditemukan, cek password nya apakah sama.
            if (preparedStatement.getResultSet().next()) {
                // hash password dengan md5
                String passwordHash = Md5Hash.md5(password);
                
                // Simpan username dan id user kedalam static class UserSession
                UserSession.setUsername(preparedStatement.getResultSet().getString("username"));
                UserSession.setUserId(preparedStatement.getResultSet().getString("id"));

                // Jika password yg telah dihash md5 tidak sesuai dengan password di database, return false
                // Jika password hash == password di db, return true
                return passwordHash.equals(preparedStatement.getResultSet().getString("password"));
                
            }
        } catch (SQLException e) {
            System.out.println("Data gagal ditampilkan : " + e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            
        }
        
        return false;
    }
}
