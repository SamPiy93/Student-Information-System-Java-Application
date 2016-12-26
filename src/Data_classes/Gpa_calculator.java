/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Madumal
 */
public class Gpa_calculator {
    /*
    private String mark1;
    private String mark2;
    private String mark3;
    private String mark4;
    private String mark5;
    */
    private String marksArray[]=new String[5];
    
    public void setMark1(String mark1) {
        this.marksArray[0] = mark1;
    }

    public void setMark2(String mark2) {
        this.marksArray[1] = mark2;
    }

    public void setMark3(String marks3) {
        this.marksArray[2] = marks3;
    }

    public void setMark4(String mark4) {
        this.marksArray[3] = mark4;
    }

    public void setMark5(String mark5) {
        this.marksArray[4] = mark5;
    }
    
    public float calc_gpa(){
        float new_gpa=0;
        try{
            for(int i=0;i<5;i++){
                switch(marksArray[i]){
                    case "A+":
                    case "A":new_gpa=new_gpa+4.0f;
                            break;
                    case "A-":new_gpa=new_gpa+3.7f;
                            break;
                    case "B+":new_gpa=new_gpa+3.3f;
                            break;
                    case "B":new_gpa=new_gpa+3.0f;
                            break;
                    case "B-":new_gpa=new_gpa+2.7f;
                            break;
                    case "C+":new_gpa=new_gpa+2.3f;
                            break;
                    case "C":new_gpa=new_gpa+2.0f;
                            break;
                    case "C-":new_gpa=new_gpa+1.7f;
                            break;
                    case "D+":new_gpa=new_gpa+1.3f;
                            break;
                    case "D":new_gpa=new_gpa+1.0f;
                            break;
                    case "E":new_gpa=new_gpa+0.0f;
                            break;
                    default :JOptionPane.showMessageDialog(null, "Invalid Grading !!!");
                }
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return (new_gpa/5);
    }
}
