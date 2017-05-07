/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Makanan.*;
import java.util.List;

/**
 *
 * @author agasigp
 */
public interface UserInterface {
    List<User> tampilMakanan();
    void simpanMakanan (User makanan);
    void ubahMakanan (User makanan);
    void hapusMakanan (User makanan);
}
