import java.util.ArrayList;
import java.util.List;

public class Rekening {

    /*---------- Atribut ----------*/
    private String noRekening;
    private double saldo;
    private Nasabah pemilik;
    private List<Kartu> daftarKartu;
    private static int counterRekening;

    /*---------- Method -----------*/

    // Konstruktor
    public Rekening(String noRekening, double saldo, Nasabah pemilik) {
        this.noRekening = noRekening;
        this.saldo = saldo;
        this.pemilik = pemilik;
        daftarKartu = new ArrayList<Kartu>();
        counterRekening++;
    }


    // Selektor Nomor Rekening
    public String getNoRekening() {
        return noRekening;
    }

    // Selektor Saldo
    public double getSaldo() {
        return saldo;
    }

    // Selektor Pemilik Rekening
    public Nasabah getPemilik() {
        return pemilik;
    }

    // Selektor banyaknya Rekening yang ada di Bank
    public static int getCounterRekening() {
        return counterRekening;
    }

    // Mutator Tambah Kartu ke Daftar Rekening
    public void tambahKartu(Kartu k) {
        daftarKartu.add(k);
    }
    // Mutator Hapus Kartu dari Daftar Rekening
    public void hapusKartu(Kartu k) {
        daftarKartu.remove(k);
    }

    // public procedure setor(input jumlah: double)
    // Mutator Tambah Jumlah Saldo / Setor
    public void setor(double jumlah) {
        saldo += jumlah;
    }

    // public procedure tarik(input jumlah: double)
    // Mutator Kurang Jumlah Saldo / Tarik
    public void tarik(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
        } else {
            System.out.println("Saldo tidak mencukupi");
        }
    }

    // public procedure printRekening()
    // Mencetak current state objek Rekening
    public void printRekening() {
        System.out.println("No Rekening\t: " + noRekening);
        System.out.println("Saldo\t: " + saldo);

        System.out.println("Pemilik\t: " + pemilik.getNama());
    }
}