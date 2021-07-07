/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_otomasyon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author brkn_
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */

    public ArrayList<Stokdto> Liste() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon1();

            ps = con.prepareStatement("SELECT * FROM BILGILER");


            rs = ps.executeQuery();


            Stokdto stok;


            while (rs.next()) {
                stok = new Stokdto(rs.getString("KULLANICIAD"), rs.getString("KULLANICISIFRE"), rs.getString("ISIM"), rs.getString("SOYISIM"), rs.getString("POZİSYON")

                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listeyedek() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon1();

            ps = con.prepareStatement("SELECT * FROM HAREKET_YEDEK");


            rs = ps.executeQuery();


            Stokdto stok;


            while (rs.next()) {
                stok = new Stokdto(rs.getString("TARIH"), rs.getInt("HAREKETNO"), rs.getString("OLAY")

                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return stoklist;
    }

    public ArrayList<Stokdto> yedekara(int no) {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon1();

            ps = con.prepareStatement("SELECT * FROM HAREKET_YEDEK WHERE HAREKETNO=?");

            ps.setInt(1, no);
            rs = ps.executeQuery();


            Stokdto stok;


            while (rs.next()) {
                stok = new Stokdto(rs.getString("TARIH"), rs.getInt("HAREKETNO"), rs.getString("OLAY")

                );
                stoklist.add(stok);
                ;

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listeara(String ad) {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon1();

            ps = con.prepareStatement("SELECT * FROM BILGILER WHERE KULLANICIAD=?");

            ps.setString(1, ad);
            rs = ps.executeQuery();


            Stokdto stok;


            while (rs.next()) {
                stok = new Stokdto(rs.getString("KULLANICIAD"), rs.getString("KULLANICISIFRE"), rs.getString("ISIM"), rs.getString("SOYISIM"), rs.getString("POZİSYON")

                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return stoklist;
    }

    public void bulara() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listeara(jTextField1.getText());


        model.setColumnIdentifiers(new Object[]{"KULLANICIAD", "KULLANICISIFRE", "ISIM", "SOYISIM", "POZİSYON"});
        Object[] row = new Object[5];

        for (int i = 0; i < stok.size(); i++) {


            row[0] = stok.get(i).getKullanıcıad();
            row[1] = stok.get(i).getKullanıcısifre();
            row[2] = stok.get(i).getIsim();
            row[3] = stok.get(i).getSoyisim();
            row[4] = stok.get(i).getPozisyon();


            model.addRow(row);


        }
//jTable1.add(model);
    }

    public void bulyedekara() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = yedekara(Integer.parseInt(jTextField7.getText()));


        model.setColumnIdentifiers(new Object[]{"HAREKETNO", "TARIH", "OLAY"});
        Object[] row = new Object[3];

        for (int i = 0; i < stok.size(); i++) {


            row[0] = stok.get(i).getHareketno();
            row[1] = stok.get(i).getTarih();
            row[2] = stok.get(i).getOlay();


            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bulyedek() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listeyedek();


        model.setColumnIdentifiers(new Object[]{"HAREKETNO", "TARIH", "OLAY"});
        Object[] row = new Object[3];

        for (int i = 0; i < stok.size(); i++) {


            row[0] = stok.get(i).getHareketno();
            row[1] = stok.get(i).getTarih();
            row[2] = stok.get(i).getOlay();


            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bul() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Liste();


        model.setColumnIdentifiers(new Object[]{"KULLANICIAD", "KULLANICISIFRE", "ISIM", "SOYISIM", "POZİSYON"});
        Object[] row = new Object[5];

        for (int i = 0; i < stok.size(); i++) {


            row[0] = stok.get(i).getKullanıcıad();
            row[1] = stok.get(i).getKullanıcısifre();
            row[2] = stok.get(i).getIsim();
            row[3] = stok.get(i).getSoyisim();
            row[4] = stok.get(i).getPozisyon();


            model.addRow(row);


        }
//jTable1.add(model);
    }


    public Admin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        aa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin paneli");

        aa.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        jScrollPane1.setViewportView(aa);

        jButton1.setText("Kullanıcı Listele");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ara");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ekle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Kullanıcı Ad");

        jLabel2.setText("Kullanıcı Şifre");

        jLabel3.setText("İsim");

        jLabel4.setText("Soy isim");

        jLabel5.setText("Pozisyon");

        jButton4.setText("Sil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Yedek Hareket");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Ara");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Şifre değiştir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setText("Yeni şifre");

        jLabel7.setText("Kullanıcı ad");

        jButton8.setText("Çıkış");
        jButton8.setActionCommand("Çıkış");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7)
                                .addGap(85, 85, 85))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(28, 28, 28)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(jButton1)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(28, 28, 28)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(65, 65, 65))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(101, 101, 101))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel6)
                                                                                                .addGap(52, 52, 52)
                                                                                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel7)
                                                                                                .addGap(52, 52, 52)
                                                                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(65, 65, 65))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(221, 221, 221)
                                                .addComponent(jButton8)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton5)
                                                .addGap(38, 38, 38))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton8)
                                                .addGap(46, 46, 46))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2)
                                        .addComponent(jLabel5)
                                        .addComponent(jButton4))
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();

        bul();
        aa.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();

        bulara();
        aa.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;

        CallableStatement cStmt = null;
        try {
            if (jTextField2.getText().equals("") || jTextField3.getText().equals("") || jTextField4.getText().equals("") || jTextField5.getText().equals("") || jTextField6.getText().equals(""))
                throw new Exception("Hata");
            conn = connect.getcon1();
            cStmt = conn.prepareCall("{call KULLANICI_EKLE(?,?,?,?,?)}");
            cStmt.setString(1, jTextField2.getText());
            cStmt.setString(2, jTextField3.getText());
            cStmt.setString(3, jTextField4.getText());
            cStmt.setString(4, jTextField5.getText());
            cStmt.setString(5, jTextField6.getText());


            cStmt.execute();

            conn.close();
            cStmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;

        CallableStatement cStmt = null;
        try {
            if (jTextField1.getText().equals(""))
                throw new Exception("Hata");
            conn = connect.getcon1();
            cStmt = conn.prepareCall("{call KULLANICI_SIL(?)}");
            cStmt.setString(1, jTextField1.getText());


            cStmt.execute();

            conn.close();
            cStmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();

        bulyedek();
        aa.setVisible(true);


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();

        bulyedekara();
        aa.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;

        CallableStatement cStmt = null;
        try {
            if (jTextField8.getText().equals("") || jTextField9.getText().equals(""))
                throw new Exception("Hata");
            conn = connect.getcon1();
            cStmt = conn.prepareCall("{call KULLANICI_DEGISTIR(?,?)}");
            cStmt.setString(1, jTextField8.getText());
            cStmt.setString(2, jTextField9.getText());


            cStmt.execute();

            conn.close();
            cStmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Giriss ulas = new Giriss();
        ulas.setVisible(true);
        super.setVisible(false);


// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(boolean a) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(a);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable aa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
