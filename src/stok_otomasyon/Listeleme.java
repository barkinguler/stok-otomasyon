/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_otomasyon;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 * @author brkn_
 */
public class Listeleme extends javax.swing.JFrame {


    /**
     * Creates new form Listeleme
     */
    public Listeleme() {
        initComponents();
        aa.setVisible(false);

    }

    public ArrayList<Stokdto> Liste() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD");

            Stokdto stok;

            while (rs.next()) {
                System.out.print(111111111);
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
                System.out.print(stok.getUrunad());
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print(e);
        }
        return stoklist;
    }

    public ArrayList<Stokdto> Listebirimfiyat() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();

            // SELECT H.DEPONO,DEPOADI,DEPOADRES,H.URUNAD,URUNBARKOD,MIKTAR,BIRIMFIYAT,HAREKETNO,TARIH,HAREKET FROM HAREKET H,URUN U,DEPO D WHERE H.URUNAD=U.URUNAD  AND H.DEPONO=U.DEPONO and u.depono=d.depono

            rs = st.executeQuery("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD order by BIRIMFIYAT desc");
            System.out.print(111111111);
            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
                System.out.print(stok.getUrunad());
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listebirimfiyat2() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();

            // SELECT H.DEPONO,DEPOADI,DEPOADRES,H.URUNAD,URUNBARKOD,MIKTAR,BIRIMFIYAT,HAREKETNO,TARIH,HAREKET FROM HAREKET H,URUN U,DEPO D WHERE H.URUNAD=U.URUNAD  AND H.DEPONO=U.DEPONO and u.depono=d.depono
            System.out.print("OOOOO");
            rs = st.executeQuery("SELECT U.URUNAD,MIKTAR,DEPONO,URUNBARKOD,KATEGORİ,BIRIMFIYAT FROM URUN U,BARKOD B WHERE U.URUNAD=B.URUNAD order by BIRIMFIYAT desc");

            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listemiktartüm() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();

            // SELECT H.DEPONO,DEPOADI,DEPOADRES,H.URUNAD,URUNBARKOD,MIKTAR,BIRIMFIYAT,HAREKETNO,TARIH,HAREKET FROM HAREKET H,URUN U,DEPO D WHERE H.URUNAD=U.URUNAD  AND H.DEPONO=U.DEPONO and u.depono=d.depono

            rs = st.executeQuery("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD order by miktar desc");
            System.out.print(111111111);
            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
                System.out.print(stok.getUrunad());
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listearama(int deger) {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            ps = con.prepareStatement("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD AND URUNBARKOD=?");

            ps.setInt(1, deger);
            System.out.print(deger);
            rs = ps.executeQuery();


            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa" + e);
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listebirimfiyatbüyük(float deger) {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();
            //SELECT U.URUNAD,URUNBARKOD,MIKTAR,BIRIMFIYAT-? AS FARK,BIRIMFIYAT,D.DEPONO,DEPOADI,DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D full JOIN HAREKET H  ON H.DEPONO=D.DEPONO full JOIN URUN U ON D.DEPONO=U.DEPONO where BIRIMFIYAT>?
            ps = con.prepareStatement("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,BIRIMFIYAT-? AS FARK,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD AND BIRIMFIYAT>?");

            ps.setFloat(1, deger);
            ps.setFloat(2, deger);
            System.out.print("ÖNCE");
            rs = ps.executeQuery();
            System.out.print("SONRA");


            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getFloat("FARK"), rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"),
                        rs.getString("HAREKET"), rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa" + e);
        }
        return stoklist;
    }

    public ArrayList<Stokdto> Listemiktarbüyük(float deger) {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            ps = con.prepareStatement("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,MIKTAR-? AS FARK,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD AND MIKTAR>?");

            ps.setFloat(1, deger);
            ps.setFloat(2, deger);
            System.out.print("ÖNCE");
            rs = ps.executeQuery();
            System.out.print("SONRA");


            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getFloat("FARK"), rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"),
                        rs.getString("HAREKET"), rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa" + e);
        }
        return stoklist;
    }

    public ArrayList<Stokdto> Listefiyatort() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();
            // SELECT U.URUNAD,URUNBARKOD,MIKTAR,(select AVG(BIRIMFIYAT) FROM URUN) AS ORT,BIRIMFIYAT,D.DEPONO,DEPOADI,DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D full JOIN HAREKET H  ON H.DEPONO=D.DEPONO full JOIN URUN U ON D.DEPONO=U.DEPONO where BIRIMFIYAT>(select AVG(BIRIMFIYAT) FROM URUN
            ps = con.prepareStatement("SELECT U.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,(select AVG(BIRIMFIYAT) FROM URUN) AS ORT,U.BIRIMFIYAT,DEPONO FROM URUN U,BARKOD B WHERE U.URUNAD=B.URUNAD AND BIRIMFIYAT>(select AVG(BIRIMFIYAT) FROM URUN)");


            rs = ps.executeQuery();


            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getFloat("ORT"), rs.getInt("DEPONO"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa" + e);
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listemiktarort() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            ps = con.prepareStatement("SELECT U.URUNAD,URUNBARKOD,KATEGORİ,MIKTAR,(select AVG(MIKTAR) FROM URUN) AS ORT,U.BIRIMFIYAT,DEPONO FROM URUN U,BARKOD B WHERE U.URUNAD=B.URUNAD AND MIKTAR>(select AVG(MIKTAR) FROM URUN)");


            System.out.print("ÖNCE");
            rs = ps.executeQuery();
            System.out.print("SONRA");


            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getFloat("ORT"), rs.getInt("DEPONO"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa" + e);
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listearamadepoadres(String deger) {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            // "SELECT U.URUNAD,URUNBARKOD,MIKTAR,BIRIMFIYAT,D.DEPONO,DEPOADI,DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D full JOIN HAREKET H  ON H.DEPONO=D.DEPONO full JOIN URUN U ON D.DEPONO=U.DEPONO where D.DEPOADRES LIKE ?"
            String forSql = "%" + deger + "%";
            con = connect.getcon();

            ps = con.prepareStatement("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD AND  D.DEPOADRES LIKE ?"
            );

            ps.setString(1, forSql);

            rs = ps.executeQuery();


            Stokdto stok;

            while (rs.next()) {

                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);

            }
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa" + e);
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Depoliste() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("select * from depo");

            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }

    public ArrayList<Stokdto> urunliste() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("select u.urunad,b.urunbarkod,u.depono,bırımfıyat,mıktar,u.KATEGORİ  from urun u,barkod b where b.urunad=u.urunad");
            System.out.print(111111111);
            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print(e);
        }
        return stoklist;
    }

    public ArrayList<Stokdto> urunlistemiktar() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("select * from urun order by MIKTAR");
            System.out.print(111111111);
            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> hareketliste() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("select * from hareket");


            Stokdto stok;

            //int depono, int hareketno, String tarih, String hareket, String urunad


            while (rs.next()) {


                stok = new Stokdto(rs.getInt("DEPONO"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"), rs.getString("URUNAD")
                );
                stoklist.add(stok);


            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listedeponoara(int a) {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.prepareStatement("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD AND D.DEPONO=? ");

            st.setInt(1, a);

            rs = st.executeQuery();
            System.out.print(111111111);
            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listehareketnoara(int a) {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.prepareStatement("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD AND HAREKETNO=? ");

            st.setInt(1, a);

            rs = st.executeQuery();
            System.out.print(111111111);
            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listetarihsırala() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("SELECT H.URUNAD,URUNBARKOD,KATEGORİ,U.MIKTAR,U.BIRIMFIYAT,H.DEPONO,D.DEPOADI,D.DEPOADRES,HAREKETNO,TARIH,HAREKET FROM DEPO D,HAREKET H,URUN U,BARKOD B WHERE H.URUNAD=U.URUNAD AND H.DEPONO=D.DEPONO AND U.DEPONO=D.DEPONO AND H.URUNAD=B.URUNAD order by TARIH DESC");
            System.out.print(111111111);
            Stokdto stok;

            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("DEPOADI"), rs.getString("DEPOADRES"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"),
                        rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }

    public ArrayList<Stokdto> Listetarihsırala2() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("SELECT * FROM HAREKET  order by TARIH DESC");
            System.out.print(111111111);
            Stokdto stok;

            while (rs.next()) {


                stok = new Stokdto(rs.getInt("DEPONO"), rs.getInt("HAREKETNO"), rs.getString("TARIH"), rs.getString("HAREKET"), rs.getString("URUNAD")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listemiktar() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("SELECT U.URUNAD,B.URUNBARKOD,KATEGORİ,MIKTAR,BIRIMFIYAT,DEPONO FROM URUN U,BARKOD B WHERE B.URUNAD=U.URUNAD order by MIKTAR DESC");
            System.out.print(111111111);
            Stokdto stok;


            while (rs.next()) {
                stok = new Stokdto(rs.getInt("DEPONO"), rs.getString("URUNAD"), rs.getInt("URUNBARKOD"), rs.getInt("MIKTAR"), rs.getFloat("BIRIMFIYAT"), rs.getString("KATEGORİ")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }


    public ArrayList<Stokdto> Listeuruntoplam() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("SELECT count(URUNAD) AS URUNSAYISI,SUM(MIKTAR)  AS TOPLAMMIKTAR,SUM(BIRIMFIYAT) AS TOPLAMBIRIMFIYAT FROM URUN ");
            System.out.print(111111111);
            Stokdto stok;


            while (rs.next()) {
                stok = new Stokdto(rs.getInt("URUNSAYISI"), rs.getInt("TOPLAMMIKTAR"), rs.getFloat("TOPLAMBIRIMFIYAT")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print("hataaaaaaa");
        }
        return stoklist;
    }

    public ArrayList<Stokdto> Listeurunhareket() {
        ArrayList<Stokdto> stoklist = new ArrayList<Stokdto>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            con = connect.getcon();

            st = con.createStatement();


            rs = st.executeQuery("SELECT U.URUNAD,count(U.URUNAD) AS HAREKETSAYISI FROM URUN U,HAREKET H WHERE U.URUNAD=H.URUNAD GROUP BY U.URUNAD");

            Stokdto stok;


            while (rs.next()) {
                stok = new Stokdto(rs.getString("URUNAD"), rs.getInt("HAREKETSAYISI")
                );
                stoklist.add(stok);
            }
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.print(e);
        }
        return stoklist;
    }


    public void bulmiktarort() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listemiktarort();


        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "ORT", "BIRIMFIYAT", "DEPONO"});
        Object[] row = new Object[7];

        for (int i = 0; i < stok.size(); i++) {
            row[0] = stok.get(i).getUrunad();

            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();
            row[4] = stok.get(i).getFark();
            row[5] = stok.get(i).getBirimfiyat();
            row[6] = stok.get(i).getDepono();

            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bulhareketno() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listehareketnoara(Integer.parseInt(jTextField5.getText()));


        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "BIRIMFIYAT", "DEPONO", "DEPOADI", "DEPOADRES", "HAREKETNO", "TARIH", "HAREKET"});
        Object[] row = new Object[11];

        for (int i = 0; i < stok.size(); i++) {
            row[0] = stok.get(i).getUrunad();

            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();
            row[4] = stok.get(i).getBirimfiyat();
            row[5] = stok.get(i).getDepono();
            row[6] = stok.get(i).getDepoad();
            row[7] = stok.get(i).getDepoadres();
            row[8] = stok.get(i).getHareketno();
            row[9] = stok.get(i).getTarih();
            row[10] = stok.get(i).getHareket();
            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void buldepono() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listedeponoara(Integer.parseInt(jTextField4.getText()));


        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "BIRIMFIYAT", "DEPONO", "DEPOADI", "DEPOADRES", "HAREKETNO", "TARIH", "HAREKET"});
        Object[] row = new Object[11];

        for (int i = 0; i < stok.size(); i++) {
            row[0] = stok.get(i).getUrunad();

            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();
            row[4] = stok.get(i).getBirimfiyat();
            row[5] = stok.get(i).getDepono();
            row[6] = stok.get(i).getDepoad();
            row[7] = stok.get(i).getDepoadres();
            row[8] = stok.get(i).getHareketno();
            row[9] = stok.get(i).getTarih();
            row[10] = stok.get(i).getHareket();
            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bulfiyatort() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listefiyatort();


        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "ORT", "BIRIMFIYAT", "DEPONO"});
        Object[] row = new Object[7];

        for (int i = 0; i < stok.size(); i++) {
            row[0] = stok.get(i).getUrunad();

            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();

            row[4] = (int) stok.get(i).getFark();
            row[5] = stok.get(i).getBirimfiyat();
            row[6] = stok.get(i).getDepono();

            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bulfiyat(float deger) {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listemiktarbüyük(deger);


        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "FARK", "BIRIMFIYAT", "DEPONO", "DEPOADI", "DEPOADRES", "HAREKETNO", "TARIH", "HAREKET"});
        Object[] row = new Object[12];

        for (int i = 0; i < stok.size(); i++) {
            row[0] = stok.get(i).getUrunad();

            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();
            row[4] = (int) stok.get(i).getFark();
            row[5] = stok.get(i).getBirimfiyat();
            row[6] = stok.get(i).getDepono();
            row[7] = stok.get(i).getDepoad();
            row[8] = stok.get(i).getDepoadres();
            row[9] = stok.get(i).getHareketno();
            row[10] = stok.get(i).getTarih();
            row[11] = stok.get(i).getHareket();
            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bulfiyatbuyuk(float deger) {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listebirimfiyatbüyük(deger);


        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "FARK", "BIRIMFIYAT", "DEPONO", "DEPOADI", "DEPOADRES", "HAREKETNO", "TARIH", "HAREKET"});
        Object[] row = new Object[12];

        for (int i = 0; i < stok.size(); i++) {
            row[0] = stok.get(i).getUrunad();

            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();
            row[4] = stok.get(i).getFark();
            row[5] = stok.get(i).getBirimfiyat();
            row[6] = stok.get(i).getDepono();
            row[7] = stok.get(i).getDepoad();
            row[8] = stok.get(i).getDepoadres();
            row[9] = stok.get(i).getHareketno();
            row[10] = stok.get(i).getTarih();
            row[11] = stok.get(i).getHareket();
            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bulmiktarbuyuk(float deger) {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;

        stok = Listemiktarbüyük(deger);


        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "FARK", "BIRIMFIYAT", "DEPONO", "DEPOADI", "DEPOADRES", "HAREKETNO", "TARIH", "HAREKET"});
        Object[] row = new Object[12];

        for (int i = 0; i < stok.size(); i++) {
            row[0] = stok.get(i).getUrunad();

            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();
            row[4] = stok.get(i).getFark();
            row[5] = stok.get(i).getBirimfiyat();
            row[6] = stok.get(i).getDepono();
            row[7] = stok.get(i).getDepoad();
            row[8] = stok.get(i).getDepoadres();
            row[9] = stok.get(i).getHareketno();
            row[10] = stok.get(i).getTarih();
            row[11] = stok.get(i).getHareket();
            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bulhareket(int a) {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;
        if (a == 0)
            stok = hareketliste();
        else if (a == 1)
            stok = Listetarihsırala2();


        model.setColumnIdentifiers(new Object[]{"HAREKETNO", "URUNAD", "DEPONO", "TARIH", "HAREKET"});
        Object[] row = new Object[5];

        for (int i = 0; i < stok.size(); i++) {


            row[0] = stok.get(i).getHareketno();
            row[1] = stok.get(i).getUrunad();
            row[2] = stok.get(i).getDepono();
            row[3] = stok.get(i).getTarih();
            row[4] = stok.get(i).getHareket();


            model.addRow(row);


        }
//jTable1.add(model);
    }

    public void bulurunhareket() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = Listeurunhareket();


        model.setColumnIdentifiers(new Object[]{"URUNAD", "HAREKETSAYISI"});
        Object[] row = new Object[2];

        for (int i = 0; i < stok.size(); i++) {

//System.out.print(stok.get(i).getUrunad());
            row[0] = stok.get(i).getUrunad();
            row[1] = stok.get(i).getMiktar();


            model.addRow(row);


        }

    }


    public void bulurun(int a) {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;
        if (a == 0)
            stok = urunliste();
        else if (a == 1)
            stok = Listemiktar();
        else if (a == 2)
            stok = Listebirimfiyat2();


        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "BIRIMFIYAT", "DEPONO"});
        Object[] row = new Object[6];

        for (int i = 0; i < stok.size(); i++) {

//System.out.print(stok.get(i).getUrunad());
            row[0] = stok.get(i).getUrunad();
            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();
            row[4] = stok.get(i).getBirimfiyat();
            row[5] = stok.get(i).getDepono();

            model.addRow(row);


        }
//jTable1.add(model);
    }

    public void buluruntoplam() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = Listeuruntoplam();


        model.setColumnIdentifiers(new Object[]{"URUNSAYISI", "TOPLAMMIKTAR", "TOPLAMBIRIMFIYAT"});
        Object[] row = new Object[3];

        for (int i = 0; i < stok.size(); i++) {

//System.out.print(stok.get(i).getUrunad());

            row[0] = stok.get(i).getHareketno();
            row[1] = stok.get(i).getMiktar();
            row[2] = stok.get(i).getBirimfiyat();

            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void buldepo() {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = Depoliste();


        model.setColumnIdentifiers(new Object[]{"DEPONO", "DEPOADI", "DEPOADRES"});
        Object[] row = new Object[3];

        for (int i = 0; i < stok.size(); i++) {

//System.out.print(stok.get(i).getUrunad());

            row[0] = stok.get(i).getDepono();
            row[1] = stok.get(i).getDepoad();
            row[2] = stok.get(i).getDepoadres();

            model.addRow(row);


        }
//jTable1.add(model);
    }


    public void bul(int a) {
        DefaultTableModel model = (DefaultTableModel) aa.getModel();
        ArrayList<Stokdto> stok = null;
        if (a == 0) {
            stok = Liste();
            //model=(DefaultTableModel)aa.getModel() ;
        } else if (a == 1) {
            stok = Listearama(Integer.parseInt(jTextField1.getText()));

        } else if (a == 2) {
            stok = Listetarihsırala();

        } else if (a == 3)
            stok = Listemiktartüm();
        else if (a == 4)
            stok = Listebirimfiyat();
        else if (a == 5)
            stok = Listearamadepoadres(jTextField2.getText());

        model.setColumnIdentifiers(new Object[]{"URUNAD", "URUNBARKOD", "KATEGORİ", "MIKTAR", "BIRIMFIYAT", "DEPONO", "DEPOADI", "DEPOADRES", "HAREKETNO", "TARIH", "HAREKET"});
        Object[] row = new Object[11];

        for (int i = 0; i < stok.size(); i++) {
            row[0] = stok.get(i).getUrunad();

            row[1] = stok.get(i).getUrunbarkod();
            row[2] = stok.get(i).getKategori();
            row[3] = stok.get(i).getMiktar();
            row[4] = stok.get(i).getBirimfiyat();
            row[5] = stok.get(i).getDepono();
            row[6] = stok.get(i).getDepoad();
            row[7] = stok.get(i).getDepoadres();
            row[8] = stok.get(i).getHareketno();
            row[9] = stok.get(i).getTarih();
            row[10] = stok.get(i).getHareket();
            model.addRow(row);


        }
//jTable1.add(model);
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jCheckBox4 = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listeleme ekranı");

        aa.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        jScrollPane1.setViewportView(aa);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Hepsini listele");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Depoları listele");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Ürünleri listele");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Hareketleri listele");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Tarihe göre sırala");

        jCheckBox2.setText("Miktara göre sırala");

        jCheckBox3.setText("Birim fiyata göre sırala");

        jLabel1.setText("Ürün barkod");

        jButton2.setText("Ara");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Depo adres");

        jButton6.setText("Ara");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setText("Depo no");

        jLabel5.setText("Hareket no");

        jButton8.setText("Ara");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Ara");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBox3)
                                                        .addComponent(jCheckBox2)
                                                        .addComponent(jCheckBox1)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(13, 13, 13))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton6))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton8)
                                        .addComponent(jButton9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jCheckBox3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jCheckBox2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addContainerGap())
        );

        jCheckBox4.setText("Birim fiyatından büyük");

        jButton7.setText("Ara");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel3.setText("Birimfiyat/miktar");

        jCheckBox5.setText("Miktarından büyük");

        jCheckBox6.setText("Ortalama miktardan fazla ürünler");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setText("Ortalama birim fiyattan fazla ürünler");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setText("Toplam ürün bilgileri");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jCheckBox9.setText("Ürünlerin hareket sayıları");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBox5)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jCheckBox4)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(119, 119, 119)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBox8)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jCheckBox9)
                                                        .addComponent(jCheckBox7)
                                                        .addComponent(jCheckBox6))))
                                .addContainerGap(643, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jCheckBox4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBox5)
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addComponent(jButton7)
                                                .addGap(32, 32, 32)
                                                .addComponent(jCheckBox6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBox8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBox9)
                                                .addContainerGap())
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();

        if (jCheckBox1.isSelected()) {
            bul(2);

        } else if (!(jCheckBox1.isSelected()) && !(jCheckBox2.isSelected()) && !(jCheckBox3.isSelected())) {
            bul(0);
        } else if (jCheckBox2.isSelected())
            bul(3);
        else if (jCheckBox3.isSelected())
            bul(4);
        aa.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        bul(1);
        aa.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        buldepo();
        aa.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        if (jCheckBox2.isSelected())
            bulurun(1);
        else if (jCheckBox3.isSelected())
            bulurun(2);
        else
            bulurun(0);
        aa.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        if (jCheckBox1.isSelected())
            bulhareket(1);
        else
            bulhareket(0);
        aa.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        bul(5);
        aa.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        if (jCheckBox4.isSelected()) {
            bulfiyatbuyuk(Float.parseFloat(jTextField3.getText()));
            aa.setVisible(true);

        } else if (jCheckBox5.isSelected()) {
            bulmiktarbuyuk(Float.parseFloat(jTextField3.getText()));
            aa.setVisible(true);
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        buldepono();
        aa.setVisible(true);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        bulhareketno();
        aa.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        buluruntoplam();
        aa.setVisible(true);


    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        bulurunhareket();
        aa.setVisible(true);


    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        bulfiyatort();
        aa.setVisible(true);
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed


        DefaultTableModel dm = (DefaultTableModel) aa.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
        bulmiktarort();
        aa.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

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
            java.util.logging.Logger.getLogger(Listeleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listeleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listeleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listeleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listeleme().setVisible(a);
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
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
