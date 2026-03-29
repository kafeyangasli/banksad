public abstract class Transaksi {
    /*Atribut */
    protected double nominal;
    protected String tanggal;
    protected Rekening rekening;
    private static int counterTransaksi;

    /*Konstruktor */

    public Transaksi(){
        nominal = 0;
        tanggal = "";
        rekening = null;
        counterTransaksi++;
    }

    public Transaksi(double nominal, String tanggal, Rekening rekening){
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.rekening = rekening;
        counterTransaksi++;
    }

    /*Selektor */

    public double getNominal(){
        return nominal;
    }

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