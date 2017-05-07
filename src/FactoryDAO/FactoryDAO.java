/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryDAO;

import Makanan.MakananImplement;
import Makanan.MakananInterface;

/**
 *
 * @author agasigp
 */
public class FactoryDAO {
    private MakananInterface makananInterface;
    
    public MakananInterface getMakananDAO() {
        if (makananInterface == null) {
            makananInterface = new MakananImplement();
        }
        
        return makananInterface;
    }
}
