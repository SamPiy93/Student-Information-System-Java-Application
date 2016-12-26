/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_classes;

import com.mysql.jdbc.ResultSetRow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Madumal
 */
public class Personal_details extends db_connect.db_connect {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet result=null;
    
    private String fname;
    private String sname;
    private String mname;
    private String sid;
    private String nic;
    private String dob;
    private String gender;
    private String add;
    private String email;
    private String phn;
    private String year;
    private String sem;
    private String pass;
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getFname() {
        return fname;
    }

    public String getSname() {
        return sname;
    }
    public String getMname() {
        return mname;
    }

    public String getNic() {
        return nic;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getAdd() {
        return add;
    }

    public String getEmail() {
        return email;
    }

    public String getPhn() {
        return phn;
    }
    
    public void personal_details_db_sql(){
        try{
            pass=this.sid+"@#1";
            String sql1="INSERT INTO pupils VALUES('"+this.fname+"', '"+this.sname+"', '"+this.mname+"', '"+this.sid+"', '"+this.nic+"', '"+this.dob+"', '"+this.gender+"', '"+this.add+"', '"+this.email+"', '"+this.phn+"', '"+this.year+"','"+this.sem+"')";
            pst = connect().prepareStatement(sql1);
            pst.execute();

            String sql2="INSERT INTO users(user_name,user_password) VALUES('"+this.sid+"','"+this.pass+"')";
            pst = connect().prepareStatement(sql2);
            pst.execute();
        }catch (Exception e){
            System.out.println("Personal details sql query error: "+e.getMessage());
        }
    }
    public void personal_details_update(){
        try{
        String sql="UPDATE pupils SET address='"+this.add+"',email='"+this.email+"',phn='"+this.phn+"' WHERE sid='"+Login_class.getUserId()+"'";
        pst=connect().prepareStatement(sql);
        pst.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Sql Error: "+e.getMessage());
        }
    }
    public void view_personal_details_sql(){
        String sql="SELECT * FROM pupils WHERE sid='"+Login_class.getUserId()+"'";
        try{
            pst=connect().prepareStatement(sql);
            result=pst.executeQuery();
            while(result.next()){
                fname=result.getString("fname");
                sname=result.getString("sname");
                mname=result.getString("mname");
                sid=result.getString("sid");
                nic=result.getString("nic");
                dob=result.getString("dob");
                gender=result.getString("gender");
                add=result.getString("address");
                email=result.getString("email");
                phn=result.getString("phn");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error :"+e.getMessage());
        }
    }

}
