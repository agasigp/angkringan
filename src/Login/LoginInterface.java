/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author agasigp
 */
public interface LoginInterface {
    // abstract method untuk login dengan kembalian berupa boolean (true/false)
    boolean login(String username, String password);
}
