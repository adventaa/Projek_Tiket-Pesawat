/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS;

/**
 *
 * @author ADVENTA
 */
public class Tiket {

    //atribut class Tiketbeserta tipe data
    private String pesawat, noPesawat, namaPenumpang, nikPenumpang, genderPenumpang, noKursi;
    private int umur, zona, hitungZona;

    //constructor dengan parameter
    public Tiket(String pesawat, String noPesawat) {
        this.pesawat = pesawat;
        this.noPesawat = noPesawat;
    }

    //method getter
    public String getPesawat() {
        return pesawat;
    }

    public String getNoPesawat() {
        return noPesawat;
    }

    public String getNamaPenumpang() {
        return namaPenumpang;
    }

    //method setter
    public void setNamaPenumpang(String namaPenumpang) {
        this.namaPenumpang = namaPenumpang;
    }

    public String getNikPenumpang() {
        return nikPenumpang;
    }

    public void setNikPenumpang(String nikPenumpang) {
        this.nikPenumpang = nikPenumpang;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getGenderPenumpang() {
        return genderPenumpang;
    }

    public void setGenderPenumpang(String genderPenumpang) {
        this.genderPenumpang = genderPenumpang;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public String getNoKursi() {
        return noKursi;
    }

    public void setNoKursi(String noKursi) {
        this.noKursi = noKursi;
    }

    //method untuk menghitung biaya tiket berdasarkan zona
    public int hitungZona() {
        int hitung = 0;
        switch (getZona()) {
            case 1:
                hitung = 1000000;
                break;
            case 2:
                hitung = 2000000;
                break;
            case 3:
                hitung = 3000000;
                break;
        }
        return hitung;
    }

}
