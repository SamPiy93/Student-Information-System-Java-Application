/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_classes;

import Interface.Main_window;
import Interface.Login_window;
import db_connect.db_connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Madumal
 */
public class Login_class extends db_connect{
    private String username;
    private String password;
    private int count=0;
    private boolean admin=false;
    private static String userId;
    
    PreparedStatement pst=null;
    ResultSet result=null;
    
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getUserId() {
        return userId;
    }
    
    public void execute_sql(){
        try{
            String sql="select * from users where user_name='"+this.username+"'and user_password='"+this.password+"'";
            pst=connect().prepareStatement(sql);
            result=pst.executeQuery();
            
            while(result.next()){
                count++;
                admin=result.getBoolean("admin");
                userId=result.getString("user_name");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        if(count==1)
        {
            JOptionPane.showMessageDialog(null,"User Found Access Granted!");
            Main_window main=new Main_window(admin,this.username);
            main.setVisible(true);
            //to dispose the main interface after user logged in
            Login_window main_object=student_information_system_new.Student_information_system_new.getMainWindowObject();
            main_object.dispose();
        }
        else if(count==0){
            JOptionPane.showMessageDialog(null,"User Does Not Exist");
        }
    } 
}
