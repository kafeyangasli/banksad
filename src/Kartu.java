public class Kartu {
    /*Atribut */
    private String noKartu;
    private String jenis;
    private Rekening rekening;
    private static int counterKartu;

    /*Konstruktor */

    // Konstruktor tanpa parameter
    public Kartu(){
        noKartu = "";
        jenis = "";
        rekening = null;
        counterKartu++;
    }

    //Konstruktor dengan parameter
    public Kartu(String noKartu, String jenis, Rekening rekening){
        this.noKartu = noKartu;
        this.jenis = jenis;
        this.rekening = rekening;
        counterKartu++;
    }

    /*Selektor */

    public String getNoKartu(){
        return noKartu;
    }

    public String getJenis(){
        return jenis;
    }

    public Rekening getRekening(){
        return rekening;
    }

    public static int getCounterKartu(){
        return counterKartu;
    }

    /*Mutator */
    public void setNoKartu(String noKartu){
        this.noKartu = noKartu;
    }

    public void setJenis(String jenis){
        this.jenis = jenis;
    }

    public void setRekening(Rekening rekening){
        this.rekening = rekening;
    }

    /*Method Tambahan */

    // Method untuk cek saldo
    public void cekSaldo(){
        if(rekening != null){
            System.out.println("Saldo : " + rekening.getSaldo());
        } else {
            System.out.println("Saldo : 0");
        }
    }

    // Method untuk tarik tunai via kartu
    public void tarikTunai(double jumlah){
        if(rekening != null){
            rekening.tarik(jumlah);
        } else {
            System.out.println("Saldo anda tidak mencukupi");
        }
    }

    /*Method Output */

    public void printKartu(){
        System.out.println("No Kartu : " + noKartu);
        System.out.println("Jenis    : " + jenis);

        if(rekening != null){
            System.out.println("No Rekening : " + rekening.getNoRekening());
        } else {
            System.out.println("No Rekening : -");
        }
    }
}