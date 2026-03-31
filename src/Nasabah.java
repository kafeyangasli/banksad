/*
    Nama Anggota Kelompok:
    1. Haydar Rafi’ Sultansyah			(24060124120023)
    2. Imam Alfarezel				    (24060124120028)
    3. Maulana Ghazzam Adil Al Faiq 	(24060124130083)
    4. Marco Falias Pangkado			(24060124130112)

    File: Nasabah.java
*/

import java.util.ArrayList;
import java.util.List;

public class Nasabah {

    /*---------- Atribut ----------*/
    private String idNasabah;
    private String nama;
    private List<Rekening> daftarRekening;
    private static int counterNasabah = 0;

    /*---------- Method -----------*/
    public Nasabah (String idNasabah, String nama) {
        this.idNasabah = idNasabah;
        this.nama = nama;
        this.daftarRekening = new ArrayList<>();
        counterNasabah++;
    }

    // Selektor ID Nasabah
    public String getIdNasabah() {
        return idNasabah;
    }
    
    // Selektor Nama Nasabah
    public String getNama() {
        return nama;
    }
    // Mutator Nama Nasabah
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Selektor Daftar Rekening
    public List<Rekening> getDaftarRekening() {
        return daftarRekening;
    }

    // Selektor Banyaknya Daftar Rekening
    public int getJumlahRekening() {
        return daftarRekening.size();
    }

    // Selektor banyaknya Nasabah yang ada di Bank
    public static int getCounterNasabah() {
        return counterNasabah;
    }

    // Selektor Total Saldo
    public double getTotalSaldo() {
        double total;
        total = 0;
        for (Rekening rek : daftarRekening){
            total += rek.getSaldo();
        }
        return total;
    }

    // Mutator Tambah Rekening ke Daftar Rekening Nasabah
    public void tambahRekening(Rekening r){
        daftarRekening.add(r);
    }
    // Mutator Hapus Rekening dari Daftar Rekening Nasabah
    public void hapusRekening(Rekening r){
        daftarRekening.remove(r);
    }

    // public procedure printNasabah()
    // Mencetak current state objek Nasabah
    public void printNasabah() {
        System.out.println("ID Nasabah\t: " + idNasabah);
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Total Rekening\t: " + getJumlahRekening());
        System.out.println("Saldo Total\t: " + getTotalSaldo());
        System.out.println(); // New Line
    }
}
