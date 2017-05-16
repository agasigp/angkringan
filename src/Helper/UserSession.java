/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author agasigp
 */
public class UserSession {
    private static String username;
    private static String userId;
 
    public static void setUsername(String username) {
        UserSession.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String UserId) {
        UserSession.userId = UserId;
    }
}
