/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.List;

/**
 *
 * @author agasigp
 */
public interface UserInterface {
    List<User> tampilUser();
    boolean cekUser(int id);
    void simpanUser (User makanan);
    void ubahUser (User makanan);
    void hapusUser (User makanan);
}
