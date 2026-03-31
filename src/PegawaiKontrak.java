import java.time.*;

public class PegawaiKontrak extends Pegawai {

    /****** ATRIBUT ******/
    private String jenisPekerjaan;
    private LocalDate akhirKontrak;

    /****** METHOD ******/
    public PegawaiKontrak() {
        super();
        this.jenisPekerjaan = "";
        this.akhirKontrak = LocalDate.now();
    }

    public PegawaiKontrak(String nip, String nama, LocalDate tglLahir, LocalDate tmt, double gajiPokok, String jenisPekerjaan, LocalDate akhirKontrak) {
        super(nip, nama, tglLahir, tmt, gajiPokok);
        this.jenisPekerjaan = jenisPekerjaan;
        this.akhirKontrak = akhirKontrak;
    }

    public String getJenisPekerjaan() {
        return jenisPekerjaan;
    }

    public void setJenisPekerjaan(String jenis) {
        this.jenisPekerjaan = jenis;
    }

    public LocalDate getAkhirKontrak() {
        return akhirKontrak;
    }

    public void setAkhirKontrak(LocalDate tgl) {
        this.akhirKontrak = tgl;
    }

    @Override
    public double hitungTunjangan() {
        return 0.1 * gajiPokok;
    }

    @Override
    public LocalDate hitungPensiun() {
        return akhirKontrak;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Jenis Pekerjaan: " + jenisPekerjaan);
        System.out.println("Akhir Kontrak  : " + formatTanggal(akhirKontrak));
        System.out.println("Tunjangan      : " + hitungTunjangan());
    }
}