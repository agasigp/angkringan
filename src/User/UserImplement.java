/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Koneksi.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author agasigp
 */
public class UserImplement implements UserInterface {
    // Membuat objek koneksi
    Koneksi connection = new Koneksi();
    
    // Variabel untuk menyimpan query
    private String query;
    
    // Variabel untuk menyimpan hasil query berupa result
    ResultSet rs;

    @Override
    public List<User> tampilUser() {
        // Koneksi ke database
        connection.getConnection();
        
        try {
            // Query untuk menampilkan user
            query = "SELECT * FROM user";
            // Membuat statement untuk untuk melakukan proses query
            Statement statement = connection.getConnection().createStatement();
            // Menampung hasil query kedalam resultset
            ResultSet resultSet = statement.executeQuery(query);
            // Membuat arraylist untuk menampung hasil data query
            List<User> dataUser = new ArrayList<>();
            
            while (resultSet.next()) {                
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setNama(resultSet.getString("nama"));
                user.setEmail(resultSet.getString("email"));
                user.setUsername(resultSet.getString("username"));
                user.setCreatedAt(resultSet.getString("created_at"));
                user.setUpdatedAt(resultSet.getString("updated_at"));
                dataUser.add(user);
            }
            
            resultSet.close();
            
            return dataUser;
        } catch (SQLException e) {
            System.out.println("Data gagal ditampilkan : " + e.getMessage());
        }
        
        return null;
    }

    @Override
    public void simpanUser(User user) {
        connection.getConnection();
        
        try {
            query = "INSERT INTO user (`nama`, `email`, `username`, `password`) VALUES (?, ?, ?, md5(?))";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getNama());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.execute();
            connection.getConnection().close();
          
            JOptionPane.showMessageDialog(null, "Tambah data user berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Gagal tambah data user: " + e.getMessage());
        }
    }

    @Override
    public void ubahUser(User user) {
        connection.getConnection();
        
        try {
            query = "UPDATE user "
                    + "SET nama = ?,"
                    + "email = ?,"
                    + "username = ?,"
                    + "password = md5(?) "
                    + "WHERE id = ?";
            
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getNama());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.execute();
            
            connection.getConnection().close();
          
            JOptionPane.showMessageDialog(null, "Ubah data user berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Gagal ubah data user: " + e.getMessage());
        }
    }

    @Override
    public void hapusUser(User user) {
        connection.getConnection();
        
        try {
            query = "DELETE FROM user WHERE id = ?";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
            connection.getConnection().close();
          
            JOptionPane.showMessageDialog(null, "Hapus data user berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Gagal hapus data user: " + e.getMessage());
        }
    }

    @Override
    public boolean cekUser(int id) {
        connection.getConnection();
        
        try {
            query = "SELECT COUNT(id) as count FROM transaksi where user_id = ?";
            
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            
            int count = 0;
            
            ResultSet resultSet = preparedStatement.getResultSet();
            
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            
            if (count > 0) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Data gagal ditampilkan : " + e.getMessage());
        }
        
        return true;
    }
}
