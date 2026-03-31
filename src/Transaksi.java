public class Transaksi {

    /*---------- Atribut ----------*/
    protected String idTransaksi;
    protected double nominal;
    protected String tanggal;
    protected Rekening rekening;
    private static int counterTransaksi;

    /*---------- Method -----------*/

    // Konstruktor
    public Transaksi(double nominal, String tanggal, Rekening rekening){
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.rekening = rekening;
        counterTransaksi++;
    }

    // Selektor Nominal
    public double getNominal(){
        return nominal;
    }
    // Selektor Tanggal Transaksi
    public String getTanggal(){
        return tanggal;
    }

    public Rekening getRekening(){
        return rekening;
    }

    public static int getCounterTransaksi(){
        return counterTransaksi;
    }

    /*Mutator */
    public void setNominal(double nominal){
        this.nominal = nominal;
    }

    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }

    public void setRekening(Rekening rekening){
        this.rekening = rekening;
    }

    /*Method Output */

    public void printTransaksi(){
        System.out.println("Tanggal : " + tanggal);
        System.out.println("Nominal : " + nominal);
    }
}