/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Makanan.*;
import Koneksi.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agasigp
 */
public class UserImplement implements UserInterface {
    Koneksi connection = new Koneksi();
    
    private String query;
    
    ResultSet rs;

    @Override
    public List<User> tampilMakanan() {
        connection.getConnection();
        
        try {
            query = "SELECT * FROM makanan";
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<User> dataMakanan = new ArrayList<User>();
            
            while (resultSet.next()) {                
                User makanan = new User();
                makanan.setId(resultSet.getInt("id"));
                makanan.setNama(resultSet.getString("nama"));
                makanan.setTipe(resultSet.getString("tipe"));
                makanan.setKeterangan(resultSet.getString("keterangan"));
                makanan.setStatus(resultSet.getInt("status"));
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
    public void simpanMakanan(User makanan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ubahMakanan(User makanan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hapusMakanan(User makanan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
