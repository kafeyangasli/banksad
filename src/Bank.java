import java.util.ArrayList;
import java.util.List;

public class Bank {
    
    /*---------- Atribut ----------*/
    private String namaBank;
    private String alamat;
    private List<Nasabah> daftarNasabah;
    private List<Pegawai> daftarPegawai;

    /*---------- Method -----------*/
    public Bank(String namaBank, String alamat) {
        this.namaBank = namaBank;
        this.alamat = alamat;
        this.daftarNasabah = new ArrayList<Nasabah>();
        this.daftarPegawai = new ArrayList<Pegawai>();
    }

    // Selektor Nama Bank
    public String getNamaBank() {
        return namaBank;
    }
    // Mutator Nama Bank
    public void setNamaBank(String nama) {
        this.namaBank = nama;
    }

    // Selektor Alamat Bank
    public String getAlamat() {
        return alamat;
    }
    // Mutator Alamat Bank
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    // Selektor Daftar Nasabah
    public List<Nasabah> getDaftarNasabah() {
        return daftarNasabah;
    }
    // Selektor Banyaknya Nasabah Bank
    public int getJumlahNasabah() {
        return daftarNasabah.size();
    }
    // Method menambahkan Nasabah
    public void tambahNasabah(Nasabah n) {
        daftarNasabah.add(n);
    }
    // Method menghapus Nasabah
    public void hapusNasabah(Nasabah n) {
        daftarNasabah.remove(n);
    }

    // Method untuk menghitung total dana seluruh Nasabah
    public double getTotalDana() {
        double dana;
        dana = 0;
        for (Nasabah n : daftarNasabah) {
            dana += n.getTotalSaldo();
        }
        return dana;
    }

    // Selektor Daftar Pegawai
    public List<Pegawai> getDaftarPegawai() {
        return daftarPegawai;
    }
    // Selektor Banyaknya Nasabah Bank
    public int getJumlahPegawai() {
        return daftarNasabah.size();
    }
    // Method menambahkan Pegawai
    public void tambahPegawai (Pegawai p) {
        daftarPegawai.add(p);
    }
    // Method menghapus Pegawai
    public void hapusPegawai(Pegawai p) {
        daftarPegawai.remove(p);
    }

}
