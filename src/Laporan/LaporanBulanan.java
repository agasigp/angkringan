/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laporan;

import Koneksi.Koneksi;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author agasigp
 */
public class LaporanBulanan {
    Koneksi connection = new Koneksi();
    JasperReport jasperReport;
    JasperPrint jasperPrint;
    Map param = new HashMap();
    JasperDesign jasperDesign;
    
    public void cetak() {
        try {
            File file = new File("src/Laporan/LaporanHarian.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            param.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, connection.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
