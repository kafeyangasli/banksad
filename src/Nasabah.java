import java.util.ArrayList;
import java.util.List;

public class Nasabah {

    /*---------- Atribut ----------*/
    private String idNasabah;
    private String nama;
    private List<Rekening> daftarRekening;
    private static int counterNasabah = 0;

    /*---------- Method -----------*/
    public Nasabah (String idNasabah, String nama) {
        this.idNasabah = idNasabah;
        this.nama = nama;
        this.daftarRekening = new ArrayList<>();
        counterNasabah++;
    }

    // Selektor ID Nasabah
    public String getIdNasabah() {
        return idNasabah;
    }
    
    // Selektor Nama Nasabah
    public String getNama() {
        return nama;
    }
    // Mutator Nama Nasabah
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Selektor Daftar Rekening
    public List<Rekening> getDaftarRekening() {
        return daftarRekening;
    }

    // Selektor Banyaknya Daftar Rekening
    public int getJumlahRekening() {
        return daftarRekening.size();
    }

    // Selektor banyaknya Nasabah yang ada di Bank
    public static int getCounterNasabah() {
        return counterNasabah;
    }

    // Selektor Total Saldo
    public double getTotalSaldo() {
        double total;
        total = 0;
        for (Rekening rek : daftarRekening){
            total += rek.getSaldo();
        }
        return total;
    }

    // Mutator Tambah Rekening ke Daftar Rekening
    public void tambahRekening(Rekening r){
        daftarRekening.add(r);
    }
    // Mutator Hapus Rekening dari Daftar Rekening
    public void hapusRekening(Rekening r){
        daftarRekening.remove(r);
    }
}
