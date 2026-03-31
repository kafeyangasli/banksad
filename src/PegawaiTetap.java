/*
    Nama Anggota Kelompok:
    1. Haydar Rafi’ Sultansyah			(24060124120023)
    2. Imam Alfarezel				    (24060124120028)
    3. Maulana Ghazzam Adil Al Faiq 	(24060124130083)
    4. Marco Falias Pangkado			(24060124130112)

    File: PegawaiTetap.java
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PegawaiTetap extends Pegawai {

    /*---------- Atribut ----------*/
    private String jabatan;
    private static final int BUP = 55;

    /*---------- Method -----------*/

    // Konstruktor tanpa parameter
    public PegawaiTetap() {
        super();
        this.jabatan = "";
    }

    // Konstruktor berparameter
    public PegawaiTetap(String nip, String nama, LocalDate tglLahir, LocalDate tmt, double gajiPokok, String jabatan) {
        super(nip, nama, tglLahir, tmt, gajiPokok);
        this.jabatan = jabatan;
    }

    // Selektor Jabatan
    public String getJabatan() {
        return jabatan;
    }
    // Mutator Jabatan
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    // public function hitungPensiun() -> LocalDate
    // Mengembalikan tanggal pensiun pegawai tetap
    public LocalDate hitungPensiun() {
        return this.getTglLahir().plusYears(BUP);
    }

    // public function hitungTunjangan() -> double
    // Mengembalikan besaran tunjangan yang diterima oleh pegawai tetap
    public double hitungTunjangan() {
        return 0.2 * this.getGajiPokok();
    }
    
    // public procedure printInfo()
    // Mencetak current state objek Pegawai Tetap
    @Override
    public void printInfo() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy");
        
        super.printInfo();
        System.out.println("Jabatan\t\t: " + jabatan);
        System.out.println("Tanggal Pensiun\t: " + hitungPensiun().format(format));
        System.out.println("Tunjangan\t: " + hitungTunjangan());
        System.out.println(); // New Line
    }
}