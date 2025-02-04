/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS;

import java.util.Scanner;

/**
 *
 * @author ADVENTA
 */
public class KelolaTiket {

    public static void main(String[] args) {
        //deklarasi array
        Pemesan[] pmsn;
        Scanner uts = new Scanner(System.in);
        int n, jum;
        
        //perulangan do while
        do {
            System.out.print("Jumlah Pemesan Tiket\t: ");
            n = uts.nextInt();
            pmsn = new Pemesan[n];
        } while (pmsn.length == 0);
        
        //perulangan for untuk input data pemesan
        for (int i = 0; i < pmsn.length; i++) {
            pmsn[i] = new Pemesan();
            System.out.println("Pemesan ke-" + (i + 1));
            System.out.print("Nama Pemesan\t\t: ");
            pmsn[i].setNamaPemesan(uts.next());
            System.out.print("Email Pemesan\t\t: ");
            pmsn[i].setEmailPemesan(uts.next());
            System.out.print("Jumlah Pesanan\t\t: ");
            jum = uts.nextInt();
            Tiket[] tkt;
            tkt = new Tiket[jum];
            pmsn[i].setDaftarTiket(tkt);
            System.out.println("");
            
            //perulangan for untuk  input data tiket pesawat
            for (int j = 0; j < tkt.length; j++) {
                tkt[j] = new Tiket("Lion Air", "JT-667");
                System.out.println("Data Diri Penumpang ke-" + (j + 1));
                System.out.print("Nama\t\t\t: ");
                tkt[j].setNamaPenumpang(uts.next());
                System.out.print("NIK\t\t\t: ");
                tkt[j].setNikPenumpang(uts.next());
                System.out.print("Umur\t\t\t: ");
                tkt[j].setUmur(uts.nextInt());
                System.out.print("Jenis Kelamin\t\t: ");
                tkt[j].setGenderPenumpang(uts.next());
                
                //perulangan do while untuk zona 
                do {
                    System.out.println("Zona\t\t\t: (1. Ekonomi 2. Bussiness 3. First Class)");
                    System.out.print("Pilihan\t\t\t: ");
                    tkt[j].setZona(uts.nextInt());
                } while (tkt[j].getZona() != 1 && tkt[j].getZona() != 2 && tkt[j].getZona() != 3);
                tkt[j].hitungZona();
                System.out.print("Nomor Kursi\t\t: ");
                tkt[j].setNoKursi(uts.next());
            }
            System.out.println("");
        }
        System.out.println("\t\t\t\t\t ~~PEMESANAN TIKET~~");
        
        //perulangan for unutk menampilkan data seluruh pemesan tiket
        for (int i = 0; i < pmsn.length; i++) {
            System.out.print("Pemesanan Atas Nama : ");
            System.out.println(pmsn[i].getNamaPemesan() + "\t" + pmsn[i].getEmailPemesan() + "\t");
            Tiket[] Daftar = pmsn[i].getDaftarTiket();
            do {
                System.out.println("================================================================================================================");
                System.out.println("Nama\tNIK\tUmur\tJenis Kelamin\tZona\tBiaya\t\tNomor Kursi\tPesawat\t\tNomor Pesawat");
                System.out.println("================================================================================================================");
            } while (pmsn.length == i);
            for (int j = 0; j < Daftar.length; j++) {
                System.out.println(Daftar[j].getNamaPenumpang() + "\t" + Daftar[j].getNikPenumpang() + "\t" + Daftar[j].getUmur() + "\t" + Daftar[j].getGenderPenumpang() + "\t\t"
                        + Daftar[j].getZona() + "\t" + Daftar[j].hitungZona() + "\t\t" + Daftar[j].getNoKursi() + "\t\t" + Daftar[j].getPesawat() + "\t" + Daftar[j].getNoPesawat());
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.println("Total Tagihan\t: " + pmsn[i].cariTotal());
            System.out.println("================================================================================================================");
            System.out.println("");
        }
        
        //method untuk mencari zona duduk
        System.out.println("\t\t\t\t\t~~PENCARIAN ZONA DUDUK~~");
        int searchZona;
        int jumZona = 0;
        System.out.print("Masukkan Zona Tempat Duduk\t\t: ");
        searchZona = uts.nextInt();
        for (int i = 0; i < pmsn.length; i++) {
            Tiket[] Search = pmsn[i].getDaftarTiket();
            for (int j = 0; j < Search.length; j++) {
                if (j < Search.length && Search[j].getZona() == searchZona) {
                    jumZona += 1;
                }
            }
        }
        
        //menampilkan zona dengan jumlah penumpang 
        System.out.println("~~Ditemukan~~");
        System.out.println("Jumlah Penumpang yang duduk pada Zona " + searchZona + " ada " + jumZona + " Penumpang");
        System.out.println("\t\t\t\t\t~~UMUR PENUMPANG TERTUA DAN TERMUDA~~");

        Tiket t1 = new Tiket("Lion Air", "JT-667");
        Tiket t2 = new Tiket("Lion Air", "JT-667");
        
        //perulangan for untuk mencari penumpang termuda dan tertua
        for (int i = 0; i < pmsn.length; i++) {
            t1 = pmsn[i].cariPenumpangTermuda();
            t2 = pmsn[i].cariPenumpangTertua();
        }
        
        //menampilkan data - data penumpang termuda
        System.out.println("Penumpang dengan Umur Termuda");
        System.out.println("Nama\t\t: " + t1.getNamaPenumpang());
        System.out.println("NIK\t\t: " + t1.getNikPenumpang());
        System.out.println("Jenis Kelamin\t: " + t1.getGenderPenumpang());
        System.out.println("Umur\t\t: " + t1.getUmur());

        //menampilkan data - data penumpang tertua
        System.out.println("Penumpang dengan Umur Tertua");
        System.out.println("Nama\t\t: " + t2.getNamaPenumpang());
        System.out.println("NIK\t\t: " + t2.getNikPenumpang());
        System.out.println("Jenis Kelamin\t: " + t2.getGenderPenumpang());
        System.out.println("Umur\t\t: " + t2.getUmur());

        //perulangan for untuk menambahkan pemesan baru
        for (int i = 0; i < pmsn.length; i++) {
            do {
                System.out.print("Apakah anda ingin menambahkan pemesan baru : (Yes/No)");
                pmsn[i].setBaru(uts.next());
                if (pmsn[i].getBaru().equals("Yes")) {
                    Tiket tk1 = new Tiket("Lion Air", "JT-667");
                    tk1.setNamaPenumpang("Yosef Krismyanto");
                    tk1.setNikPenumpang("215314045");
                    tk1.setGenderPenumpang("Laki-Laki");
                    tk1.setUmur(17);
                    tk1.setZona(2);
                    tk1.hitungZona();
                    tk1.setNoKursi("17");
                    pmsn[i].addTiket(0, tk1);
                    System.out.println("Nama\t\t: " + tk1.getNamaPenumpang());
                    System.out.println("NIK\t\t: " + tk1.getNikPenumpang());
                    System.out.println("Jenis Kelamin\t: " + tk1.getGenderPenumpang());
                    System.out.println("Umur\t\t: " + tk1.getUmur());
                    System.out.println("Zona\t\t: " + tk1.getZona());
                    System.out.println("Biaya\t\t: " + tk1.hitungZona());
                    System.out.println("Nomor Kursi\t: " + tk1.getNoKursi());
                    System.out.println("Pesawat\t\t: " + tk1.getPesawat());
                    System.out.println("Nomor Pesawat\t: " + tk1.getNoPesawat());
                    System.exit(0);
                } else if (pmsn[i].getBaru().equals("No")) {
                    System.out.println("Terima Kasih telah Menggunakan Layanan Kami");
                }
            } while (!pmsn[i].getBaru().equals("Yes") && !pmsn[i].getBaru().equals("No"));

        }
    }

}
