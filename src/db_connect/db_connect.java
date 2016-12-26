/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_connect;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Madumal
 */
public class db_connect {
    public static Connection connect(){
        Connection con=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/student_information_system_new","root","");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return con;
    }
} 