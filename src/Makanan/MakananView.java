/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Makanan;

import FactoryDAO.FactoryDAO;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author agasigp
 */
public class MakananView extends javax.swing.JFrame {

    private List<Makanan> listMakanan;
    private final String[] tbHeader;
    
    private DefaultTableModel tabelModel;
    private boolean updSQLFlag = false;
    private int baris;
    
    FactoryDAO factoryDAO = new FactoryDAO();
    MakananInterface makananInterface = factoryDAO.getMakananDAO();
    
    /**
     * Creates new form MakananView
     */
    public MakananView() {
        initComponents();
        
        tbHeader = new String[]{"ID", "NAMA", "HARGA", "TIPE", "KETERANGAN", "CREATED AT", "UPDATED AT"};
        tabelModel = new DefaultTableModel(null, tbHeader);
        tabelMakanan.setModel(tabelModel);
        addMakananItem();
        tampilMakanan();
    }

    private void tampilMakanan() {
        listMakanan = makananInterface.tampilMakanan();
        tabelModel = (DefaultTableModel) tabelMakanan.getModel();
        tabelModel.setRowCount(0);
        
        for (Makanan dataMakanan : listMakanan) {
            tabelModel.addRow(new Object[]{dataMakanan.getId(), dataMakanan.getNama(), dataMakanan.getHarga(), getTipe(dataMakanan.getTipe()), dataMakanan.getKeterangan() });
        }
        
        int ambilBaris = tabelMakanan.getRowCount();
        
        if (ambilBaris > 0) {
            tabelMakanan.addRowSelectionInterval(0, 0);
        }
    }
    
    private void addMakananItem() {
        cmbTipe.addItem(new MakananTipeItem("MKN", "Makanan"));
        cmbTipe.addItem(new MakananTipeItem("MMN", "Minuman"));
        cmbTipe.addItem(new MakananTipeItem("LK", "Lauk"));
    }
    
    private String getTipe(String tipe) {
        switch (tipe) {
            case "MKN":
                return "Makanan";
            case "MMN":
                return "Minuman";
            default:
                return "Lauk";
        }
    }
    
    private void clearForm() {
        txtId.setText("");
        txtNama.setText("");
        txtHarga.setText("");
        txtKeterangan.setText("");
    }
    
    public final void tampilText() {
        baris = tabelMakanan.getSelectedRow();
        
        if (baris >= 0) {
            txtId.setText(tabelModel.getValueAt(baris, 0).toString());
            txtNama.setText(tabelModel.getValueAt(baris, 1).toString());
            txtHarga.setText(tabelModel.getValueAt(baris, 2).toString());
            txtKeterangan.setText(tabelModel.getValueAt(baris, 4).toString());        
        }
 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMakanan = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        cmbTipe = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        txtHarga = new javax.swing.JFormattedTextField(formatter);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSimpan.setText("Tambah");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        tabelMakanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "Harga", "Keterangan", "Dibuat", "Diupdate"
            }
        ));
        tabelMakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMakananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMakanan);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        cmbTipe.setMaximumRowCount(100);

        jLabel1.setText("Nama");

        jLabel2.setText("Harga");

        jLabel3.setText("Tipe");

        jLabel4.setText("Keterangan");

        txtId.setEditable(false);

        jLabel5.setText("Id");

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addGap(121, 121, 121))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNama)
                                    .addComponent(txtKeterangan)
                                    .addComponent(txtId)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtHarga))))
                        .addGap(504, 504, 504))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Makanan makanan = new Makanan();
        MakananTipeItem tipeMakananModel = (MakananTipeItem) cmbTipe.getSelectedItem();
        
        String namaMakanan = txtNama.getText();
        String tipeMakanan = tipeMakananModel.getKey();
        int hargaMakanan = Integer.parseInt(txtHarga.getText());
        String keteranganMakanan = txtKeterangan.getText();
        
        makanan.setNama(namaMakanan);
        makanan.setTipe(tipeMakanan);
        makanan.setHarga(hargaMakanan);
        makanan.setKeterangan(keteranganMakanan);
        
        if (updSQLFlag == false) {
            if (txtNama.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama harus diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                txtNama.grabFocus();
            } else if (txtHarga.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Harga harus diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                txtHarga.grabFocus();
            } else {
                makananInterface.simpanMakanan(makanan);
//                JOptionPane.showMessageDialog(null, "", "Info", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        tampilMakanan();
        clearForm();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tabelMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMakananMouseClicked
        // TODO add your handling code here:
        tampilText();
        
    }//GEN-LAST:event_tabelMakananMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        Makanan makanan = new Makanan();
        MakananTipeItem tipeMakananModel = (MakananTipeItem) cmbTipe.getSelectedItem();
        
        int idMakanan = Integer.parseInt(txtId.getText());
        String namaMakanan = txtNama.getText();
        String tipeMakanan = tipeMakananModel.getKey();
        int hargaMakanan = Integer.parseInt(txtHarga.getText());
        String keteranganMakanan = txtKeterangan.getText();
        
        makanan.setId(idMakanan);
        makanan.setNama(namaMakanan);
        makanan.setTipe(tipeMakanan);
        makanan.setHarga(hargaMakanan);
        makanan.setKeterangan(keteranganMakanan);
        
        if (updSQLFlag == false) {
            if (txtNama.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama harus diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                txtNama.grabFocus();
            } else if (txtHarga.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Harga harus diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
                txtHarga.grabFocus();
            } else {
                makananInterface.ubahMakanan(makanan);
//                JOptionPane.showMessageDialog(null, "", "Info", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        tampilMakanan();
        clearForm();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        Makanan makanan = new Makanan();
        makanan.setId(Integer.parseInt(txtId.getText()));
        
        if (makananInterface.cekMakanan(makanan.getId())) {
            makananInterface.hapusMakanan(makanan);
            clearForm();
            tampilMakanan();
        } else {
            JOptionPane.showMessageDialog(null, "Gagal hapus makanan!", "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox cmbTipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMakanan;
    private javax.swing.JFormattedTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
