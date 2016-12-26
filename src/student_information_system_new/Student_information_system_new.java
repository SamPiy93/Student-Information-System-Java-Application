/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_information_system_new;

import Interface.Main_window;
import Interface.Login_window;
import com.thehowtotutorial.splashscreen.JSplash;
import java.awt.Color;

/**
 *
 * @author Madumal
 */
public class Student_information_system_new {

    /**
     * @param args the command line arguments
     */
    static Login_window window=null;
    
    public static void main(String[] args) {
        Login_window main=new Login_window();
        main.setVisible(true);
        
        setMainWindowObject(main);
    }
    
    private static void setMainWindowObject(Login_window m){
        window=m;
    }
    public static Login_window getMainWindowObject(){
        return window;
    }
}
