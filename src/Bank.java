import java.util.ArrayList;
import java.util.List;

public class Bank {
    //atrbit
    private String namaBank;
    private String alamat;
    private List<Nasabah> daftarNasabah;
    private List<Pegawai> daftarPegawai;

    //konstruktor
    public Bank(String namaBank, String alamat){
        this.namaBank = namaBank;
        this.alamat = alamat;
        this.daftarNasabah = new ArrayList<>();
        this.daftarPegawai = new ArrayList<>();
    }

    //getter setter
    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String nama) {
        this.namaBank = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Nasabah> getDaftarNasabah() {
        return daftarNasabah;
    }

    public List<Pegawai> getDaftarPegawai() {
        return daftarPegawai;

    }

    //method laen
    public int getJumlahNasabah(){
        return daftarNasabah.size();

    }

    public double getTotalDana(){
        double dana;
        dana = 0;
        for (Nasabah n : daftarNasabah) {
            dana += n.getTotalSaldo();
        }
        return dana;
    }
    public void tambahNasabah(Nasabah n){
        daftarNasabah.add(n);
    }

    public void hapusNasabah(Nasabah n){
        daftarNasabah.remove(n);
    }

    public void tambahPegawai (Pegawai p){
        daftarPegawai.add(p);
    }
    public void hapusPegawai(Pegawai p){
        daftarPegawai.remove(p);
    }

}
