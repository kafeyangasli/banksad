import java.time.*;
import java.time.format.DateTimeFormatter;

public abstract class Pegawai {

    /****** ATRIBUT ******/
    protected String nip;
    protected String nama;
    protected LocalDate tglLahir;
    protected LocalDate tmt;
    protected double gajiPokok;

    /****** METHOD ******/
    public Pegawai() {
        this.nip = "";
        this.nama = "";
        this.tglLahir = LocalDate.now();
        this.tmt = LocalDate.now();
        this.gajiPokok = 0;
    }

    public Pegawai(String nip, String nama, LocalDate tglLahir, LocalDate tmt, double gajiPokok) {
        this.nip = nip;
        this.nama = nama;
        this.tglLahir = tglLahir;
        this.tmt = tmt;
        this.gajiPokok = gajiPokok;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(LocalDate tgl) {
        this.tglLahir = tgl;
    }

    public LocalDate getTmt() {
        return tmt;
    }

    public void setTmt(LocalDate tmt) {
        this.tmt = tmt;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(double gaji) {
        this.gajiPokok = gaji;
    }

    public int getUmur() {
        return Period.between(tglLahir, LocalDate.now()).getYears();
    }

    public String hitungMasaKerja() {
        Period p = Period.between(tmt, LocalDate.now());
        return p.getYears() + " tahun " + p.getMonths() + " bulan";
    }

    public String formatTanggal(LocalDate tgl) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy");
        return tgl.format(format);
    }

    public abstract double hitungTunjangan();

    public abstract LocalDate hitungPensiun();

    public void printInfo() {
        System.out.println("NIP: " + nip);
        System.out.println("Nama: " + nama);
        System.out.println("Tanggal Lahir: " + formatTanggal(tglLahir));
        System.out.println("TMT: " + formatTanggal(tmt));
        System.out.println("Umur: " + getUmur() + " tahun");
        System.out.println("Masa Kerja: " + hitungMasaKerja());
        System.out.println("Gaji Pokok: " + gajiPokok);
    }
}