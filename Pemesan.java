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
public class Pemesan {

    //atribut class Pemesan beserta tipe data
    private String namaPemesan, emailPemesan, baru;
    private Tiket[] daftarTiket;

    //constructor tanpa parameter
    public Pemesan() {
    }

    //method getter
    public String getNamaPemesan() {
        return namaPemesan;
    }

    //method setter
    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getEmailPemesan() {
        return emailPemesan;
    }

    public void setEmailPemesan(String emailPemesan) {
        this.emailPemesan = emailPemesan;
    }

    //method getter dengan bertipe array
    public Tiket[] getDaftarTiket() {
        return daftarTiket;
    }

    public void setDaftarTiket(Tiket[] daftarTiket) {
        this.daftarTiket = daftarTiket;
    }

    public String getBaru() {
        return baru;
    }

    public void setBaru(String baru) {
        this.baru = baru;
    }

    //method untuk menghitung total
    public int cariTotal() {
        int total = 0;
        for (int i = 0; i < this.daftarTiket.length; i++) {
            total += this.daftarTiket[i].hitungZona();
        }
        return total;
    }

    //method untuk mencari penumpang termuda
    public Tiket cariPenumpangTermuda() {
        int min = this.daftarTiket[0].getUmur();
        int indeks = 0;
        for (int i = 0; i < this.daftarTiket.length; i++) {
            if (this.daftarTiket[i].getUmur() < min) {
                min = this.daftarTiket[i].getUmur();
                indeks = i;
            }
        }
        return daftarTiket[indeks];
    }

    //method untuk mencari penumpang tertua
    public Tiket cariPenumpangTertua() {
        int mak = this.daftarTiket[0].getUmur();
        int indeks = 0;
        for (int i = 0; i < this.daftarTiket.length; i++) {
            if (this.daftarTiket[i].getUmur() > mak) {
                mak = this.daftarTiket[i].getUmur();
                indeks = i;
            }
        }
        return daftarTiket[indeks];
    }

    //method untuk menambahkan tiket pemesan
    public void addTiket(int n, Tiket tkt) {
        this.daftarTiket[n] = new Tiket(tkt.getPesawat(), tkt.getNoPesawat());
        this.daftarTiket[n].setNamaPenumpang(tkt.getNamaPenumpang());
        this.daftarTiket[n].setNikPenumpang(tkt.getNikPenumpang());
        this.daftarTiket[n].setGenderPenumpang(tkt.getGenderPenumpang());
        this.daftarTiket[n].setNikPenumpang(tkt.getNikPenumpang());
        this.daftarTiket[n].setNoKursi(tkt.getNoKursi());
        this.daftarTiket[n].setZona(tkt.getZona());
        this.daftarTiket[n].hitungZona();
    }

}
