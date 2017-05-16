/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryDAO;

import Login.LoginImplement;
import Login.LoginInterface;
import Makanan.MakananImplement;
import Makanan.MakananInterface;
import Transaksi.TransaksiImplement;
import Transaksi.TransaksiInterface;
import User.UserImplement;
import User.UserInterface;

/**
 *
 * @author agasigp
 */
public class FactoryDAO {
    private MakananInterface makananInterface;
    private UserInterface userInterface;
    private TransaksiInterface transaksiInterface;
    private LoginInterface loginInterface;
    
    public MakananInterface getMakananDAO() {
        if (makananInterface == null) {
            makananInterface = new MakananImplement();
        }
        
        return makananInterface;
    }
    
    public UserInterface getUserDAO() {
        if (userInterface == null) {
            userInterface = new UserImplement();
        }
        
        return userInterface;
    }
    
    public TransaksiInterface getTransaksiDAO() {
        if (transaksiInterface == null) {
            transaksiInterface = new TransaksiImplement();
        }
        
        return transaksiInterface;
    }
    
    public LoginInterface getLoginDAO() {
        if (loginInterface == null) {
            loginInterface = new LoginImplement();
        }
        
        return loginInterface;
    }
}
