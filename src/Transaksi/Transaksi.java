/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agasigp
 */
public class Transaksi {
    private int id;
    private int userId;
    private String noTransaksi;
    private List<TransaksiDetail> listTransaksiDetail = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public List<TransaksiDetail> getListTransaksiDetail() {
        return listTransaksiDetail;
    }

    public void addTransaksiDetail(TransaksiDetail transaksiDetail) {
        this.listTransaksiDetail.add(transaksiDetail);
    }
}
