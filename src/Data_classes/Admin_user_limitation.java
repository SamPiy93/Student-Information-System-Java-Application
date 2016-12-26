/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_classes;

import Interface.Login_window;
import static db_connect.db_connect.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Madumal
 */
public class Admin_user_limitation {
    private int year;
    private int semester;
    private String std_id;
    private String sub1;
    private String sub2;
    private String sub3;
    private String sub4;
    private String sub5;
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet result=null;
    
    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }

    public void setSub3(String sub3) {
        this.sub3 = sub3;
    }

    public void setSub4(String sub4) {
        this.sub4 = sub4;
    }

    public void setSub5(String sub5) {
        this.sub5 = sub5;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }

    public String getStd_id() {
        return std_id;
    }

    public String getSub1() {
        return sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public String getSub3() {
        return sub3;
    }

    public String getSub4() {
        return sub4;
    }

    public String getSub5() {
        return sub5;
    }

    
    public void semester_details_sql(){
        try {      
            String sql = "INSERT INTO student_grading_table (year,semester,stud_id,sub1,sub2,sub3,sub4,sub5) VALUES ('"+year+"','"+semester+"','"+std_id+"','"+sub1+"','"+sub2+"','"+sub3+"','"+sub4+"','"+sub5+"')";
            pst = connect().prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    private String u_id=Login_class.getUserId();

    public void student_detail_sql(){
        
        try {
        
            String sql ="SELECT * FROM student_grading_table WHERE stud_id='"+u_id+"'";
            pst = connect().prepareStatement(sql);
            result=pst.executeQuery();
        
            while(result.next()){
                /*
                this.year=Integer.getInteger(result.getString("year"));
                this.semester=Integer.getInteger(result.getString("semester"));
                this.std_id=result.getString("stud_id");
                this.sub1=result.getString("sub1");
                this.sub2=result.getString("sub2");
                this.sub3=result.getString("sub3");
                this.sub4=result.getString("sub4");
                this.sub5=result.getString("sub5");
                */
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
