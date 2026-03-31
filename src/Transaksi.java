import java.time.LocalDate;

public class Transaksi {

    /*---------- Atribut ----------*/
    private String idTransaksi;
    private String jenis;
    private double nominal;
    private LocalDate tanggal;
    private Rekening asal;
    private Rekening tujuan;
    private boolean statusTransaksi;
    private static int counterTransaksi;

    /*---------- Method -----------*/

    // Konstruktor
    public Transaksi(String jenis, double nominal, Rekening rekening) throws Exception {
        if (rekening == null) throw new Exception("Input Rekening tidak boleh null!");

        if (jenis.equalsIgnoreCase("tarik")) {
            this.asal = rekening;
        } else if (jenis.equalsIgnoreCase("setor")) {
            this.tujuan = rekening;
        } else if (jenis.equalsIgnoreCase("transfer")) {
            throw new Exception("Transaksi Transfer harus memiliki rekening asal dan tujuan!");
        } else {
            throw new Exception("Jenis Transaksi tidak valid!");
        }

        this.idTransaksi = "TID-BSAD-" + LocalDate.now().toString();
        this.nominal = nominal;
        this.tanggal = LocalDate.now();
        this.jenis = jenis.toUpperCase();
        counterTransaksi++;
    }

    public Transaksi(String jenis, double nominal, Rekening asal, Rekening tujuan) throws Exception {
        if (asal == null || tujuan == null) throw new Exception("Input Rekening asal maupun tujuan tidak boleh null!");
        
        if (jenis.equalsIgnoreCase("transfer")) {
            this.asal = asal;
            this.tujuan = tujuan;
        } else if (jenis.equalsIgnoreCase("setor") || jenis.equalsIgnoreCase("tarik")) {
            throw new Exception("Transaksi" + "hanya menerima input satu rekening!");
        } else {
            throw new Exception("Jenis Transaksi tidak valid!");
        }

        this.idTransaksi = "TID-BSAD-" + LocalDate.now().toString();
        this.nominal = nominal;
        this.tanggal = LocalDate.now();
        this.jenis = jenis.toUpperCase();
        counterTransaksi++;
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
        System.out.println("No. Rekening Asal\t: " + asal == null ? "-" : asal.getNoRekening());
        System.out.println("No. Rekening Tujuan\t: " + tujuan == null ? "-" : tujuan.getNoRekening());
        System.out.println("Jenis Transaksi\t: " + jenis.toUpperCase());
        System.out.println("Tanggal\t\t: " + tanggal);
        System.out.println("Nominal\t\t: " + nominal);
    }
}