/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_otomasyon;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author brkn_
 */
public class connect {
   
    public static Connection getcon() {
        Connection con1=null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Kullanıcı","123");
            //con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok?useUnicode=true&characterEncoding=utf8&useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");


            if (con1 != null) System.out.print("calıstı");


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
return con1;
    }
public static Connection getcon1() {
        Connection con1=null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Admin","123");
            //con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok?useUnicode=true&characterEncoding=utf8&useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");


            if (con1 != null) System.out.print("calıstı");


        } catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
            
        }
return con1;
    }
public static Connection getcon2() {
        Connection con1=null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Musteri","123");
            //con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/stok?useUnicode=true&characterEncoding=utf8&useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");


            if (con1 != null) System.out.print("calıstı");


        } catch (Exception e) {

           JOptionPane.showMessageDialog(null, e);
        }
return con1;
    }



}
    

