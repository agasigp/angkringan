/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Makanan;

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
public class MakananImplement implements MakananInterface {
    Koneksi connection = new Koneksi();
    
    private String query;
    
    ResultSet rs;

    @Override
    public List<Makanan> tampilMakanan() {
        connection.getConnection();
        
        try {
            query = "SELECT * FROM makanan";
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Makanan> dataMakanan = new ArrayList<>();
            
            while (resultSet.next()) {                
                Makanan makanan = new Makanan();
                makanan.setId(resultSet.getInt("id"));
                makanan.setNama(resultSet.getString("nama"));
                makanan.setTipe(resultSet.getString("tipe"));
                makanan.setKeterangan(resultSet.getString("keterangan"));
                makanan.setHarga(resultSet.getInt("harga"));
                
                dataMakanan.add(makanan);
            }
            
            resultSet.close();
            return dataMakanan;
        } catch (SQLException e) {
            System.out.println("Data gagal ditampilkan : " + e.getMessage());
        }
        
        return null;
    }

    @Override
    public void simpanMakanan(Makanan makanan) {
        connection.getConnection();
        
        try {
            query = "INSERT INTO makanan (nama, tipe, harga, keterangan) VALUES (?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, makanan.getNama());
            preparedStatement.setString(2, makanan.getTipe());
            preparedStatement.setInt(3, makanan.getHarga());
            preparedStatement.setString(4, makanan.getKeterangan());
            preparedStatement.execute();
            connection.getConnection().close();
          
            JOptionPane.showMessageDialog(null, "Tambah data makanan berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data makanan gagal!", "Informasi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void ubahMakanan(Makanan makanan) {
        connection.getConnection();
        
        try {
            String query = "UPDATE makanan "
                    + "SET nama = ?,"
                    + "tipe = ?,"
                    + "harga = ?,"
                    + "keterangan = ?"
                    + "WHERE id = ?";
            
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, makanan.getNama());
            preparedStatement.setString(2, makanan.getTipe());
            preparedStatement.setInt(3, makanan.getHarga());
            preparedStatement.setString(4, makanan.getKeterangan());
            preparedStatement.setInt(5, makanan.getId());
            preparedStatement.execute();
            
            connection.getConnection().close();
          
            JOptionPane.showMessageDialog(null, "Ubah data makanan berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Gagal ubah data user: " + e.getMessage());
        }
    }

    @Override
    public void hapusMakanan(Makanan makanan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
