/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryDAO;

import Makanan.MakananImplement;
import Makanan.MakananInterface;
import User.UserImplement;
import User.UserInterface;

/**
 *
 * @author agasigp
 */
public class FactoryDAO {
    private MakananInterface makananInterface;
    private UserInterface userInterface;
    
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
}
