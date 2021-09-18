/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PINDIKA
 */
public class DBA {

    Connection conn = connect(Const.DBNAME);
    public Connection connect(String dbname) {
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+dbname;
            c = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ConnectError: " + e);
        }
        return c;
    }

    public boolean insertStudent(Student s) {
        boolean ok = false;
        try {
            String qry = "insert into student values(?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(qry);
            pst.setInt(1, s.getRegno());
            pst.setString(2, s.getFname());
            pst.setString(3, s.getLname());
            pst.setString(4, s.getGender());
            pst.setString(5, s.getDpt());
            int a = pst.executeUpdate();
            if (a == 1) {
                ok = true;
                String m = s.toString() + " was saved into database!";
                JOptionPane.showMessageDialog(null, m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "InsertError: " + e);
        }
        return ok;
    }

    public List<Student> getStudents() {
        List<Student> sts = new ArrayList<>();
        try {
            String qry = "select * from student";
            ResultSet rs = conn.createStatement().executeQuery(qry);
            while (rs.next()) {
                int regno = rs.getInt("reg_no");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String gender = rs.getString("gender");
                String dpt = rs.getString("department");
                Student s = new Student(regno, fname, lname, gender, dpt);
                sts.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "RetrieveError: " + e);
        }
        return sts;
    }

    public boolean updateStudent(Student s) {
        boolean ok = false;
        try {
            String qry = "update student set "
                    + "first_name=?,"//1
                    + "last_name=?,"//2
                    + "gender=?,"//3
                    + "department=? "//4
                    + "where reg_no=?";//5
            PreparedStatement pst = conn.prepareStatement(qry);
            pst.setString(1, s.getFname());
            pst.setString(2, s.getLname());
            pst.setString(3, s.getGender());
            pst.setString(4, s.getDpt());
            pst.setInt(5, s.getRegno());
            //ok = (1 == pst.executeUpdate());
            int n = pst.executeUpdate();
            if (n == 1) {
                ok = true;
                JOptionPane.showMessageDialog(null, s + " Was Deleted successfully!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UpdateError: " + e);
        }
        return ok;
    }

    public boolean deleteStudent(Student s) {
        boolean ok = false;
        try {
            String qry = "delete from students "
                    + "where reg_no=?";
            PreparedStatement pst = conn.prepareStatement(qry);
            pst.setInt(1, s.getRegno());
            //ok = (1 == pst.executeUpdate());
            int n = pst.executeUpdate();
            if (n == 1) {
                ok = true;
                JOptionPane.showMessageDialog(null, s + " Was Deleted successfully!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UpdateError: " + e);
        }
        return ok;
    }
}
