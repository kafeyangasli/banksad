import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PegawaiKontrak extends Pegawai {

    /*---------- Atribut ----------*/
    private String jenisPekerjaan;
    private LocalDate akhirKontrak;

    /*---------- Method -----------*/

    // Konstruktor tanpa parameter
    public PegawaiKontrak() {
        super();
        this.jenisPekerjaan = "";
        this.akhirKontrak = LocalDate.now();
    }

    // Konstruktor berparameter
    public PegawaiKontrak(String nip, String nama, LocalDate tglLahir, LocalDate tmt, double gajiPokok, String jenisPekerjaan, LocalDate akhirKontrak) {
        super(nip, nama, tglLahir, tmt, gajiPokok);
        this.jenisPekerjaan = jenisPekerjaan;
        this.akhirKontrak = akhirKontrak;
    }

    // Selektor Jenis Pekerjaan
    public String getJenisPekerjaan() {
        return jenisPekerjaan;
    }
    // Mutator Jenis Pekerjaan
    public void setJenisPekerjaan(String jenis) {
        this.jenisPekerjaan = jenis;
    }
    
    // Selektor Tanggal Akhir Kontrak
    public LocalDate getAkhirKontrak() {
        return akhirKontrak;
    }
    // Mutator Tanggal Akhir Kontrak
    public void setAkhirKontrak(LocalDate tgl) {
        this.akhirKontrak = tgl;
    }
    
    // public function hitungTunjangan() -> double
    // Mengembalikan besaran tunjangan yang diterima oleh pegawai kontrak
    public double hitungTunjangan() {
        return 0.1 * this.getGajiPokok();
    }

    // public function hitungPensiun() -> LocalDate
    // Mengembalikan tanggal pensiun pegawai kontrak
    public LocalDate hitungPensiun() {
        return akhirKontrak;
    }

    // public procedure printInfo()
    // Mencetak current state objek Pegawai Kontrak
    @Override
    public void printInfo() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy");

        super.printInfo();
        System.out.println("Jenis Pekerjaan\t: " + jenisPekerjaan);
        System.out.println("Akhir Kontrak\t: " + akhirKontrak.format(format));
        System.out.println("Tunjangan\t: " + hitungTunjangan());
        System.out.println(); // New Line
    }
}