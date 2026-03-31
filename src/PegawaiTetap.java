import java.time.*;

public class PegawaiTetap extends Pegawai {

    /****** ATRIBUT ******/
    private String jabatan;
    private static final int BUP = 55;

    /****** METHOD ******/
    public PegawaiTetap() {
        super();
        this.jabatan = "";
    }

    public PegawaiTetap(String nip, String nama, LocalDate tglLahir, LocalDate tmt, double gajiPokok, String jabatan) {
        super(nip, nama, tglLahir, tmt, gajiPokok);
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public LocalDate hitungPensiun() {
        return tglLahir.plusYears(BUP);
    }

    @Override
    public double hitungTunjangan() {
        return 0.2 * gajiPokok;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Jabatan        : " + jabatan);
        System.out.println("Tanggal Pensiun: " + formatTanggal(hitungPensiun()));
        System.out.println("Tunjangan      : " + hitungTunjangan());
    }
}