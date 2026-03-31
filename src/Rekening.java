public class Rekening {

    /*---------- Atribut ----------*/
    private String noRekening;
    private double saldo;
    private Nasabah pemilik;
    private static int counterRekening = 0;

    /*---------- Method -----------*/

    // Konstruktor
    public Rekening(String noRekening, double saldo, Nasabah pemilik) {
        this.noRekening = noRekening;
        this.saldo = saldo;
        this.pemilik = pemilik;
        pemilik.tambahRekening(this);
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

    // public procedure setor(input jumlah: double)
    // Mutator Tambah Jumlah Saldo / Setor
    public void setor(double jumlah) {
        saldo += jumlah;
    }

    // public procedure tarik(input jumlah: double)
    // Mutator Kurang Jumlah Saldo / Tarik
    public void tarik(double jumlah) throws Exception {
        if (saldo >= jumlah) {
            saldo -= jumlah;
        } else {
            throw new Exception ("Saldo tidak mencukupi!");
        }
    }

    // public procedure printRekening()
    // Mencetak current state objek Rekening
    public void printRekening() {
        System.out.println("No Rekening\t: " + noRekening);
        System.out.println("Saldo\t\t: " + saldo);
        System.out.println("Pemilik\t\t: " + pemilik.getNama());
        System.out.println(); // New Line
    }
}