import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Pegawai {

    /*---------- Atribut ----------*/
    protected String nip;
    protected String nama;
    protected LocalDate tglLahir;
    protected LocalDate tmt;
    protected double gajiPokok;
    private static int counterPegawai = 0;

    /*---------- Method -----------*/

    // Konstruktor tanpa parameter
    protected Pegawai() {
        this.nip = "";
        this.nama = "";
        this.tglLahir = LocalDate.now();
        this.tmt = LocalDate.now();
        this.gajiPokok = 0;
        counterPegawai++;
    }

    // Konstruktor berparameter
    protected Pegawai(String nip, String nama, LocalDate tglLahir, LocalDate tmt, double gajiPokok) {
        this.nip = nip;
        this.nama = nama;
        this.tglLahir = tglLahir;
        this.tmt = tmt;
        this.gajiPokok = gajiPokok;
        counterPegawai++;
    }

    // Selektor NIP
    public String getNIP() {
        return nip;
    }

    // Selektor Nama
    public String getNama() {
        return nama;
    }
    // Mutator Nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Selektor Tanggal Lahir
    public LocalDate getTglLahir() {
        return tglLahir;
    }

    // Selektor TMT
    public LocalDate getTmt() {
        return tmt;
    }

    // Selektor Gaji Pokok
    public double getGajiPokok() {
        return gajiPokok;
    }
    // Mutator Gaji Pokok
    public void setGajiPokok(double gaji) {
        this.gajiPokok = gaji;
    }

    // Selektor Banyaknya Pegawai yang Ada
    public static int getCounterPegawai(){
        return counterPegawai;
    }
    
    // public function getUmur() -> int
    // Mengembalikan umur dari pegawai
    public int getUmur() {
        return Period.between(tglLahir, LocalDate.now()).getYears();
    }

    // public function hitungMasaKerja() -> String
    // Mengembalikan masa kerja dari pegawai dalam bentuk String "XX tahun XX bulan"
    public String hitungMasaKerja() {
        Period p = Period.between(tmt, LocalDate.now());
        return p.getYears() + " tahun " + p.getMonths() + " bulan";
    }
    
    // public abstract function hitungTunjangan() -> double
    public abstract double hitungTunjangan();

    // public abstract function hitungPensiun() -> LocalDate
    public abstract LocalDate hitungPensiun();

    // public procedure printInfo()
    // Mencetak current state objek Pegawai
    public void printInfo() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy");

        System.out.println("NIP\t\t: " + nip);
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Tanggal Lahir\t: " + tglLahir.format(format));
        System.out.println("TMT\t\t: " + tmt.format(format));
        System.out.println("Umur\t\t: " + getUmur() + " tahun");
        System.out.println("Masa Kerja\t: " + hitungMasaKerja());
        System.out.println("Gaji Pokok\t: " + gajiPokok);
    }
}