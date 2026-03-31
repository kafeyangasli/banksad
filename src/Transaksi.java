import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Transaksi {

    /*---------- Atribut ----------*/
    private String idTransaksi;
    private String jenis;
    private double nominal;
    private LocalDate tanggal;
    private Rekening asal;
    private Rekening tujuan;
    private boolean statusTransaksi;
    private static int counterTransaksi = 0;
    private static List<Transaksi> daftarTransaksi = new ArrayList<Transaksi>();

    /*---------- Method -----------*/

    // Konstruktor
    public Transaksi(String jenis, double nominal, Rekening rekening) throws Exception {
        if (rekening == null) throw new Exception("Input Rekening tidak boleh null!");
        if (nominal <= 0) throw new Exception("Nominal harus lebih dari 0 rupiah!");

        if (jenis.equalsIgnoreCase("tarik")) {
            this.asal = rekening;
        } else if (jenis.equalsIgnoreCase("setor")) {
            this.tujuan = rekening;
        } else if (jenis.equalsIgnoreCase("transfer")) {
            throw new Exception("Transaksi Transfer harus memiliki rekening asal dan tujuan!");
        } else {
            throw new Exception("Jenis Transaksi tidak valid!");
        }

        this.idTransaksi = "TID-BSAD-" + ++counterTransaksi;
        this.nominal = nominal;
        this.tanggal = LocalDate.now();
        this.jenis = jenis.toUpperCase();
        daftarTransaksi.add(this);
    }

    public Transaksi(String jenis, double nominal, Rekening asal, Rekening tujuan) throws Exception {
        if (asal == null || tujuan == null) throw new Exception("Input Rekening asal maupun tujuan tidak boleh null!");
        if (nominal <= 0) throw new Exception("Nominal harus lebih dari 0 rupiah!");

        if (jenis.equalsIgnoreCase("transfer")) {
            this.asal = asal;
            this.tujuan = tujuan;
        } else if (jenis.equalsIgnoreCase("setor") || jenis.equalsIgnoreCase("tarik")) {
            throw new Exception("Transaksi" + "hanya menerima input satu rekening!");
        } else {
            throw new Exception("Jenis Transaksi tidak valid!");
        }

        this.idTransaksi = "TID-BSAD-" + ++counterTransaksi + "-" + LocalDate.now();
        this.nominal = nominal;
        this.tanggal = LocalDate.now();
        this.jenis = jenis.toUpperCase();
        daftarTransaksi.add(this);
    }

    // Selektor ID Transaksi
    public String getIDTransaksi() {
        return this.idTransaksi;
    }
    // Selektor Nominal
    public double getNominal() {
        return this.nominal;
    }
    // Selektor Jenis Transaksi
    public String getJenisTransaksi() {
        return this.jenis;
    }
    // Selektor Tanggal Transaksi
    public LocalDate getTanggal() {
        return tanggal;
    }
    // Selektor Rekening Terasosiasi
    public Rekening getRekeningAsal() {
        return asal;
    }
    public Rekening getRekeningTujuan() {
        return tujuan;
    }

    // Selektor Status Transaksi
    public boolean getStatusTransaksi() {
        return statusTransaksi;
    }

    // Selektor Banyaknya Transaksi yang telah Terbuat
    public static int getCounterTransaksi(){
        return counterTransaksi;
    }
    // Selektor Seluruh Transaksi Yang Ada
    public static List<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    // public procedure proses()
    // Memproses transaksi jika belum
    public void proses() throws Exception {
        if (this.statusTransaksi) throw new Exception("Transaksi sudah diproses!");

        switch(this.jenis) {
            case "TARIK": {
                this.asal.tarik(this.nominal);
                break;
            }
            case "SETOR": {
                this.tujuan.setor(this.nominal);
                break;
            }
            case "TRANSFER": {
                this.asal.tarik(this.nominal);
                this.tujuan.setor(this.nominal);
                break;
            }
        }

        this.statusTransaksi = true;
    }

    // public procedure printTransaksi()
    // Mencetak current state objek Transaksi
    public void printTransaksi(){
        System.out.println("Rek. Asal\t: " + (asal == null ? "-" : asal.getNoRekening()));
        System.out.println("Rek. Tujuan\t: " + (tujuan == null ? "-" : tujuan.getNoRekening()));
        System.out.println("Jenis Transaksi\t: " + jenis.toUpperCase());
        System.out.println("Tanggal\t\t: " + tanggal);
        System.out.println("Nominal\t\t: " + nominal);
        System.out.println(); // New Line
    }
}