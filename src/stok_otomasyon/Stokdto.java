/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_otomasyon;

/**
 * @author brkn_
 */
public class Stokdto {
    private float fark;
    private int depono;
    private String depoad;
    private String depoadres;
    private int hareketno;
    private String tarih;
    private String hareket;
    private String urunad;
    private int urunbarkod;
    private int miktar;
    private float birimfiyat;
    private String kullanıcıad;
    private String kullanıcısifre;
    private String isim;
    private String soyisim;
    private String pozisyon;
    private String olay;
    private String kategori;

    public Stokdto(int depono, String urunad, int urunbarkod, int miktar, float birimfiyat, String kategori) {
        this.urunad = urunad;
        this.urunbarkod = urunbarkod;
        this.miktar = miktar;
        this.birimfiyat = birimfiyat;
        this.kategori = kategori;
        this.depono = depono;

    }

    public Stokdto(float fark, int depono, String urunad, int urunbarkod, int miktar, float birimfiyat, String kategori) {
        this.urunad = urunad;
        this.urunbarkod = urunbarkod;
        this.miktar = miktar;
        this.birimfiyat = birimfiyat;
        this.kategori = kategori;
        this.depono = depono;
        this.fark = fark;

    }


    public Stokdto(int depono, String depoad, String depoadres, int hareketno, String tarih, String hareket, String urunad, int urunbarkod, int miktar, float birimfiyat, String kategori) {
        this.depono = depono;
        this.depoad = depoad;
        this.depoadres = depoadres;
        this.hareketno = hareketno;
        this.tarih = tarih;
        this.hareket = hareket;
        this.urunad = urunad;
        this.urunbarkod = urunbarkod;
        this.miktar = miktar;
        this.birimfiyat = birimfiyat;
        this.kategori = kategori;
    }


    public Stokdto(int hareketno, int miktar, float birimfiyat) {
        this.hareketno = hareketno;
        this.miktar = miktar;
        this.birimfiyat = birimfiyat;
    }

    public Stokdto(String urunad, int miktar) {
        this.urunad = urunad;
        this.miktar = miktar;
    }


    public Stokdto(String tarih, int hareketno, String olay) {
        this.tarih = tarih;
        this.hareketno = hareketno;
        this.olay = olay;

    }


    public Stokdto(String kullanıcıad, String kullanıcısifre, String isim, String soyisim, String pozisyon) {
        this.kullanıcıad = kullanıcıad;
        this.kullanıcısifre = kullanıcısifre;
        this.isim = isim;
        this.soyisim = soyisim;
        this.pozisyon = pozisyon;
    }

    public Stokdto(int depono, String depoad, String depoadres, int hareketno, String tarih, String hareket, String urunad, int urunbarkod, int miktar, float birimfiyat) {
        this.depono = depono;
        this.depoad = depoad;
        this.depoadres = depoadres;
        this.hareketno = hareketno;
        this.tarih = tarih;
        this.hareket = hareket;
        this.urunad = urunad;
        this.urunbarkod = urunbarkod;
        this.miktar = miktar;
        this.birimfiyat = birimfiyat;
    }

    public Stokdto(int depono, String depoad, String depoadres) {
        this.depono = depono;
        this.depoad = depoad;
        this.depoadres = depoadres;
    }

    public Stokdto(int depono, int hareketno, String tarih, String hareket, String urunad) {
        this.depono = depono;
        this.hareketno = hareketno;
        this.tarih = tarih;
        this.hareket = hareket;
        this.urunad = urunad;
    }

    public Stokdto(int depono, String urunad, int urunbarkod, int miktar, float birimfiyat) {
        this.depono = depono;
        this.urunad = urunad;
        this.urunbarkod = urunbarkod;
        this.miktar = miktar;
        this.birimfiyat = birimfiyat;
    }

    public Stokdto(float fark, int depono, String depoad, String depoadres, int hareketno, String tarih, String hareket, String urunad, int urunbarkod, int miktar, float birimfiyat, String kategori) {
        this.fark = fark;
        this.depono = depono;
        this.depoad = depoad;
        this.depoadres = depoadres;
        this.hareketno = hareketno;
        this.tarih = tarih;
        this.hareket = hareket;
        this.urunad = urunad;
        this.urunbarkod = urunbarkod;
        this.miktar = miktar;
        this.birimfiyat = birimfiyat;
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public String getOlay() {
        return olay;
    }

    public String getKullanıcıad() {
        return kullanıcıad;
    }

    public String getKullanıcısifre() {
        return kullanıcısifre;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public int getDepono() {
        return depono;
    }

    public String getDepoad() {
        return depoad;
    }

    public String getDepoadres() {
        return depoadres;
    }

    public int getHareketno() {
        return hareketno;
    }

    public String getTarih() {
        return tarih;
    }

    public float getFark() {
        return fark;
    }

    public String getHareket() {
        return hareket;
    }

    public String getUrunad() {
        return urunad;
    }

    public int getUrunbarkod() {
        return urunbarkod;
    }

    public int getMiktar() {
        return miktar;
    }

    public float getBirimfiyat() {
        return birimfiyat;
    }


}
