/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student.main;

/**
 *
 * @author PINDIKA
 */
public class Student {
    int regno ;
    String fname;
    String lname;
    String gender ;
    String dpt ;

    public Student(int regno, String fname, String lname, String gender, String dpt) {
        this.regno = regno;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.dpt = dpt;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public int getRegno() {
        return regno;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getGender() {
        return gender;
    }

    public String getDpt() {
        return dpt;
    }

    @Override
    public String toString() {
        return fname + " " + lname + " ["+regno+" ], a " + gender + " who studies in " + dpt;
    }
    
   
}
