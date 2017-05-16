/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import Koneksi.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author agasigp
 */
public class TransaksiImplement implements TransaksiInterface {
    Koneksi connection = new Koneksi();
    
    private String query;
    
    ResultSet rs;
    
    @Override
    public void simpanTransaksi(Transaksi transaksi) {
        String generatedColumns[] = { "ID" };
        
        try {
            query = "INSERT INTO transaksi(user_id, no_transaksi) VALUES (?, ?)";
            
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query, generatedColumns);
            preparedStatement.setString(1, transaksi.getNoTransaksi());
            preparedStatement.setInt(2, transaksi.getUserId());
            preparedStatement.execute();
            
            rs = preparedStatement.getGeneratedKeys();
            
            if (rs.next()) {
                int idTransaksi = rs.getInt(1);
                simpanDetailTransaksi(idTransaksi, transaksi);
            }
            
            connection.getConnection().close();
        } catch (SQLException e) {
            System.out.println("Gagal simpan data : " + e.getMessage());
        }
    }
    
    private void simpanDetailTransaksi(int transaksiId, Transaksi transaksi) {
        try {
            query = "INSERT INTO transaksi_detail(transaksi_id, makanan_id, jumlah) VALUES (?, ?, ?)";
            
            for (TransaksiDetail transaksiDetail : transaksi.getTransaksiDetail()) {
                PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
                preparedStatement.setInt(1, transaksiId);
                preparedStatement.setInt(2, transaksiDetail.getMakananId());
                preparedStatement.setInt(3, transaksiDetail.getJumlah());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            System.out.println("Gagal simpan data : " + e.getMessage());
        }
    }
    
}
