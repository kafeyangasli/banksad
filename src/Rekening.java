public class Rekening {
    /*Atribut */
    private String noRekening;
    private double saldo;
    private Nasabah pemilik;
    private static int counterRekening;

    /*Konstruktor */

    // Konstruktor tanpa parameter
    public Rekening(){
        noRekening = "";
        saldo = 0;
        pemilik = null;
        counterRekening++;
    }

    // Konstruktor dengan parameter
    public Rekening(String noRekening, double saldo, Nasabah pemilik){
        this.noRekening = noRekening;
        this.saldo = saldo;
        this.pemilik = pemilik;
        counterRekening++;
    }

    /*Selektor */

    public String getNoRekening(){
        return noRekening;
    }

    public double getSaldo(){
        return saldo;
    }

    public Nasabah getPemilik(){
        return pemilik;
    }

    public static int getCounterRekening(){
        return counterRekening;
    }

    /*Mutator */
    public void setNoRekening(String noRekening){
        this.noRekening = noRekening;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setPemilik(Nasabah pemilik){
        this.pemilik = pemilik;
    }

    /*Method Tambahan */

    //Method untuk setor
    public void setor(double jumlah){
        saldo += jumlah;
    }

    // Method untuk tarik 
    public void tarik(double jumlah){
        if(saldo >= jumlah){
            saldo -= jumlah;
        } else {
            System.out.println("Saldo tidak mencukupi");
        }
    }

    /*Method Output */

    public void printRekening(){
        System.out.println("No Rekening : " + noRekening);
        System.out.println("Saldo       : " + saldo);

        if(pemilik != null){
            System.out.println("Pemilik     : " + pemilik.getNama());
        } else {
            System.out.println("Pemilik     : -");
        }
    }
}