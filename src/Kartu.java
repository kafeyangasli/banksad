/*
    Nama Anggota Kelompok:
    1. Haydar Rafi’ Sultansyah			(24060124120023)
    2. Imam Alfarezel				    (24060124120028)
    3. Maulana Ghazzam Adil Al Faiq 	(24060124130083)
    4. Marco Falias Pangkado			(24060124130112)

    File: Kartu.java
*/

import java.time.LocalDate;

public class Kartu {

    /*---------- Atribut ----------*/
    private String noKartu;
    private String jenis;
    private Rekening rekening;
    private LocalDate masaBerlaku;
    private static int counterKartu = 0;

    /*---------- Method -----------*/

    // Konstruktor berparameter
    public Kartu(String jenis, Rekening rekening) {
        this.noKartu = "CID-BNQ-" + ++counterKartu;
        this.jenis = jenis;
        this.masaBerlaku = LocalDate.now().plusYears(5); // Masa berlaku 5 tahun
        this.rekening = rekening;
    }

    // Selektor Nomor Kartu
    public String getNoKartu() {
        return noKartu;
    }

    // Selektor Jenis Kartu
    public String getJenis() {
        return jenis;
    }
    // Mutator Jenis Kartu
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    // Selektor Rekening yang Terhubung
    public Rekening getRekening() {
        return rekening;
    }
    // Mutator Rekening yang Terhubung
    public void setRekening(Rekening rekening) {
        this.rekening = rekening;
    }

    // Selektor Banyaknya Kartu yang Terbuat
    public static int getCounterKartu(){
        return counterKartu;
    }

    // Selektor Masa Berlaku Kartu
    public LocalDate getMasaBerlakuKartu() {
        return masaBerlaku;
    }
    // Selektor Status Keaktifan Kartu
    public boolean isAktif() {
        return LocalDate.now().isBefore(masaBerlaku);
    }
    // Method untuk memperpanjang masa berlaku
    public void perpanjangMasaBerlaku() {
        this.masaBerlaku = LocalDate.now().plusYears(5);
    }

    // Method untuk tarik tunai via kartu
    public void tarikTunai(double jumlah) throws Exception {
        assert rekening != null : "Rekening kok null...";

        if (!this.isAktif()) throw new Exception("Kartu sudah melewati masa berlaku!");

        try {
            Transaksi T = new Transaksi("tarik", jumlah, rekening);

            T.proses();
            T.printTransaksi();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // public procedure printKartu()
    // Mencetak current state objek Kartu
    public void printKartu(){
        System.out.println("No Kartu\t: " + noKartu);
        System.out.println("Jenis\t\t: " + jenis);
        System.out.println("Rek. Terhubung\t: " + rekening.getNoRekening());
        System.out.println(); // New Line
    }
}