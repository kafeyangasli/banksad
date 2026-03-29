import java.util.ArrayList;
import java.util.List;

public class Nasabah {

    //atribut
    private String idNasabah;
    private String nama;
    private List<Rekening> daftarRekening;

    //konstrukto
    public Nasabah(String idNasabah, String nama) {
        if (idNasabah == null || idNasabah.isEmpty()) {
            throw new IllegalArgumentException("ID Nasabah tidak boleh kosong");
        }
        if (nama == null || nama.isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }

        this.idNasabah = idNasabah;
        this.nama = nama;
        this.daftarRekening = new ArrayList<>();
    }

    //getter setter
    public String getIdNasabah(){
        return idNasabah;
    }
    
    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama;
    }

    public List<Rekening> getDaftarRekening() {
        return daftarRekening;
    }

    //method lain
    public int getJumlahRekening(){
        return daftarRekening.size();

    }

    public double getTotalSaldo(){
        double total;
        total =0;
        for (Rekening r : daftarRekening){
            total += r.getSaldo();
        }
        return total;
    }

    public void tambahRekening(Rekening r) {
        if (r == null) {
            throw new IllegalArgumentException("Rekening tidak boleh null");
        }
        daftarRekening.add(r);
    }
    public void hapusRekening(Rekening r) {
        if (r == null) {
            throw new IllegalArgumentException("Rekening tidak boleh null");
        }
        if (!daftarRekening.remove(r)) {
            throw new IllegalArgumentException("Rekening tidak ditemukan");
        }
    }
}
