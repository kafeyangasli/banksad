/*
    Nama Anggota Kelompok:
    1. Haydar Rafi’ Sultansyah			(24060124120023)
    2. Imam Alfarezel				    (24060124120028)
    3. Maulana Ghazzam Adil Al Faiq 	(24060124130083)
    4. Marco Falias Pangkado			(24060124130112)

    File: Main.java (Driver)
*/

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("---------- Test Bank Q ----------");
        Bank bank = new Bank("Bank Q", "Jl. Diponegoro 67");

        /* Nasabah */
        Nasabah n1 = new Nasabah("26122006", "Faiq");
        Nasabah n2 = new Nasabah("11092001", "Adam");

        bank.tambahNasabah(n1);
        bank.tambahNasabah(n2);

        System.out.println("\n----- Data Nasabah Sebelum -----");
        n1.printNasabah();
        n2.printNasabah();

        /* Rekening */
        Rekening r1 = new Rekening("674125030067", 1000000, n1);
        Rekening r2 = new Rekening("674125030069", 500000, n1);
        Rekening r3 = new Rekening("674126030026", 2000000, n2);

        /* Setor dan Tarik */
        System.out.println("\n----- Setor -----");
        r1.printRekening();
        System.out.println();

        try {
            Transaksi t1 = new Transaksi("setor", 250000, r1);

            t1.proses();
            t1.printTransaksi();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        r1.printRekening();

        System.out.println("\n----- Tarik Gagal -----");
        try {
            Transaksi t2 = new Transaksi("tarik", 10000000, r1);

            t2.proses();
            t2.printTransaksi();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        r1.printRekening();

        System.out.println("\n----- Tarik Sukses -----");

        try {
            Transaksi t3 = new Transaksi("tarik", 100000, r1);

            t3.proses();
            t3.printTransaksi();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        r1.printRekening();

        /* Transaksi Transfer */
        System.out.println("\n----- Transfer Gagal -----");
        try {
            Transaksi t4 = new Transaksi("transfer",60000000, r1, r3);

            t4.proses();
            t4.printTransaksi();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        r1.printRekening();
        r3.printRekening();

        System.out.println("\n----- Transfer Sukses -----");
        try {
            Transaksi t5 = new Transaksi("transfer", 670000, r1, r3);
            t5.proses();
            t5.printTransaksi();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        r1.printRekening();
        r3.printRekening();

        System.out.println("\n----- Proses Dua Kali -----");
        try {
            Transaksi t6 = new Transaksi("transfer", 67000, r1, r2);
            t6.proses();
            t6.printTransaksi();
            System.out.println("Selesai diproses, sekarang coba kedua kalinya...");
            t6.proses();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        r1.printRekening();
        r2.printRekening();

        /* Kartu */
        System.out.println("\n----- Kartu -----");

        Kartu k1 = new Kartu("reguler", r1);

        k1.printKartu();
        r1.printRekening();

        try {
            k1.tarikTunai(50000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        r1.printRekening();

        System.out.println("\n----- Data Nasabah Sekarang -----");
        n1.printNasabah();
        n2.printNasabah();

        /* Pegawai */
        System.out.println("\n----- Pegawai Bank -----");

        Pegawai p1 = new PegawaiTetap(
            "1987071220160508",
            "Siti Aisyah", 
            LocalDate.of(1987, 7, 12),
            LocalDate.now().minusYears(10).minusDays(65),
            8000000,
            "Supervisor"
        );
        Pegawai p2 = new PegawaiKontrak(
            "1997121220231210",
            "Putra Robertus", 
            LocalDate.of(1997, 12, 12),
            LocalDate.now().minusYears(3).minusMonths(2),
            2500000,
            "Teller Junior",
            LocalDate.now().plusYears(7).minusMonths(2)
        );

        bank.tambahPegawai(p1);
        bank.tambahPegawai(p2);

        for (Pegawai p : bank.getDaftarPegawai()) {
            p.printInfo();
            System.out.println();
        }

        System.out.println("Total Dana Bank\t: " + bank.getTotalDana());
        System.out.println("Jumlah Nasabah\t: " + Nasabah.getCounterNasabah());
        System.out.println("Jumlah Pegawai\t: " + Pegawai.getCounterPegawai());
        System.out.println("Jumlah Rekening\t: " + Rekening.getCounterRekening());
        System.out.println("Jumlah Transaksi: " + Transaksi.getCounterTransaksi());
        System.out.println("Jumlah Kartu\t: " + Kartu.getCounterKartu());

        System.out.println("------------ Selesai ------------");
    }
}