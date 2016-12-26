/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_classes;

import db_connect.db_connect;
import static db_connect.db_connect.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Madumal
 */
public class Student_academic {
    public Student_academic(String id,String year,String semester){
        this.stud_id=id;
        this.year=year;
        this.semester=semester;
    }
    public Student_academic(String id){
        this.stud_id=id;
    }
    Connection con=null;
    PreparedStatement state=null;
    ResultSet result=null;
    
    private String year;
    private String semester; 
    private String stud_id;
    private String sub1; 
    private String sub2; 
    private String sub3; 
    private String sub4; 
    private String sub5;
    private String mark1; 
    private String mark2; 
    private String mark3; 
    private String mark4; 
    private String mark5;

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getStud_id() {
        return stud_id;
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

    public String getMark1() {
        return mark1;
    }

    public String getMark2() {
        return mark2;
    }

    public String getMark3() {
        return mark3;
    }

    public String getMark4() {
        return mark4;
    }

    public String getMark5() {
        return mark5;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
    }

    public void setMark3(String mark3) {
        this.mark3 = mark3;
    }

    public void setMark4(String mark4) {
        this.mark4 = mark4;
    }

    public void setMark5(String mark5) {
        this.mark5 = mark5;
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

    public void setYear(String year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }
    
    public void constructor_details_connect(){
        result=null;
        String sql="SELECT * FROM pupils WHERE sid='"+stud_id+"'";
        try{
            state=db_connect.connect().prepareStatement(sql);
            result=state.executeQuery();
            
            while(result.next()){
                this.year=result.getString("year");
                this.semester=result.getString("semester");

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
    public void academic_table_connect(){
        result=null;
        String sql="SELECT * FROM student_grading_table WHERE stud_id='"+this.stud_id+"' AND year='"+this.year+"' AND semester='"+this.semester+"'";
        try{
            state=db_connect.connect().prepareStatement(sql);
            result=state.executeQuery();
            
            while(result.next()){
                this.mark1=result.getString("marks1");
                this.mark2=result.getString("marks2");
                this.mark3=result.getString("marks3");
                this.mark4=result.getString("marks4");
                this.mark5=result.getString("marks5");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public void subject_table_connect(){
        String sql="SELECT * FROM subjects WHERE stud_id='"+this.stud_id+"' AND year='"+this.year+"' AND semester='"+this.semester+"'";
        try{
            state=db_connect.connect().prepareStatement(sql);
            result=state.executeQuery();
            while(result.next()){
                sub1=result.getString("sub1");
                sub2=result.getString("sub2");
                sub3=result.getString("sub3");
                sub4=result.getString("sub4");
                sub5=result.getString("sub5");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public void update_marks_sql(){
        String sql1="UPDATE subjects SET sub1='"+this.sub1+"', sub2='"+this.sub2+"', sub3='"+this.sub3+"', sub4='"+this.sub4+"', sub5='"+this.sub5+"' WHERE stud_id='"+this.stud_id+"' AND year='"+this.year+"' AND semester='"+this.semester+"'";
        String sql2="UPDATE student_grading_table SET marks1='"+this.mark1+"', marks2='"+this.mark2+"', marks3='"+this.mark3+"', marks4='"+this.mark4+"', marks5='"+this.mark5+"' WHERE stud_id='"+this.stud_id+"' AND year='"+this.year+"' AND semester='"+this.semester+"'";
        try{
            state=db_connect.connect().prepareStatement(sql1);
            state.execute();
            
            state=db_connect.connect().prepareStatement(sql2);
            state.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public void add_marks_sql(){
        
        String sql = "INSERT INTO student_grading_table(year,semester,stud_id,marks1,marks2,marks3,marks4,marks5) VALUES ('"+this.year+"','"+this.semester+"','"+this.stud_id+"','"+this.mark1+"','"+this.mark2+"','"+this.mark3+"','"+this.mark4+"','"+this.mark5+"')"; 
        
        try {
        state = connect().prepareStatement(sql);
        state.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
    public void add_subjects_sql(){
        String sql1 = "INSERT INTO subjects(stud_id, year, semester, sub1, sub2, sub3, sub4, sub5) VALUES('"+this.stud_id+"','"+this.year+"','"+this.semester+"', '"+this.sub1+"', '"+this.sub2+"', '"+this.sub3+"', '"+this.sub4+"', '"+this.sub5+"')";
        try {
        state = connect().prepareStatement(sql1);
        state.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
}
