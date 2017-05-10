/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Koneksi.Koneksi;

/**
 *
 * @author agasigp
 */
public class Login {
    public static void login() {
        Koneksi connection = new Koneksi();
        connection.getConnection();
        
        
    }
}
