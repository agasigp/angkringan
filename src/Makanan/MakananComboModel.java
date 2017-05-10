/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Makanan;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author agasigp
 */
public class MakananComboModel extends DefaultComboBoxModel<MakananTipeItem>{
    public MakananComboModel(MakananTipeItem[] items) {
        super(items);
    }
 
    @Override
    public MakananTipeItem getSelectedItem() {
        MakananTipeItem selectedMakanan = (MakananTipeItem) super.getSelectedItem();
 
        // do something with this job before returning...
 
        return selectedMakanan;
    }
}
