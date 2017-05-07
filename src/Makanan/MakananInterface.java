/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Makanan;

import java.util.List;

/**
 *
 * @author agasigp
 */
public interface MakananInterface {
    List<Makanan> tampilMakanan();
    void simpanMakanan (Makanan makanan);
    void ubahMakanan (Makanan makanan);
    void hapusMakanan (Makanan makanan);
}
