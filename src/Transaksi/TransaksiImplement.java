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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author agasigp
 */
public class TransaksiImplement implements TransaksiInterface {
    Koneksi connection = new Koneksi();
    
    private String queryInsertTransaksi;
    private String queryInsertDetailTransaksi;
    
    ResultSet rs;
    
    @Override
    public void simpanTransaksi(Transaksi transaksi) {
        String generatedColumns[] = { "ID" };
        
        try {
            queryInsertTransaksi = "INSERT INTO transaksi(user_id, no_transaksi) VALUES (?, ?)";
            
            PreparedStatement preparedStatement1 = connection.getConnection().prepareStatement(queryInsertTransaksi, generatedColumns);
            preparedStatement1.setInt(1, transaksi.getUserId());
            preparedStatement1.setString(2, transaksi.getNoTransaksi());
            preparedStatement1.execute();
            
            rs = preparedStatement1.getGeneratedKeys();
            
            if (rs.next()) {
                int idTransaksi = rs.getInt(1);
                queryInsertDetailTransaksi = "INSERT INTO transaksi_detail(transaksi_id, makanan_id, jumlah, total) VALUES (?, ?, ?, ?)";
                List<TransaksiDetail> listTransaksiDetail = transaksi.getListTransaksiDetail();
                
                for (TransaksiDetail transaksiDetail : listTransaksiDetail) {
                    PreparedStatement preparedStatement2 = connection.getConnection().prepareStatement(queryInsertDetailTransaksi);
                    preparedStatement2.setInt(1, idTransaksi);
                    preparedStatement2.setInt(2, transaksiDetail.getMakananId());
                    preparedStatement2.setInt(3, transaksiDetail.getJumlah());
                    preparedStatement2.setInt(4, transaksiDetail.getTotal());
                    preparedStatement2.execute();
                }
            }
            
            connection.getConnection().close();
            
            JOptionPane.showMessageDialog(null, "Tambah data transaksi berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data transaksi gagal!", "Informasi", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int countTransaksi() {
        String query = "SELECT COUNT(id) AS count FROM transaksi WHERE DATE(created_at) = ?";
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        int count = 0;
        
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, date);
            preparedStatement.execute();
            
            ResultSet resultSet = preparedStatement.getResultSet();
            
            while (resultSet.next()) {                
                count = resultSet.getInt("count");
            }

            connection.getConnection().close();
        } catch (SQLException ex) {
            
        }
        
        return count;
    }
}
