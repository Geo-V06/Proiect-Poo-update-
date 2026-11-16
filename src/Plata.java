public class Plata extends Tranzactie {
    private String iplata;
    private String mon;
    private String numeu;
    private double suma1;

    public double getSuma1() {
        return this.suma1;
    }

    public void setSuma1(double suma1) {
        this.suma1 = suma1;
    }

    public String getNumeu() {
        return this.numeu;
    }

    public void setNumeu(String numeu) {
        this.numeu = numeu;
    }

    public String getMon() {
        return this.mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getIplata() {
        return this.iplata;
    }

    public void setIplata(String iplata) {
        this.iplata = iplata;
    }

    public Plata() {
        super();
        this.iplata = "Nonexistent";
        this.mon = "Care moneda?";
        this.numeu = "MIA";
        this.suma1 = (double)0.0F;
    }

    public Plata(String iplata, String mon, String numeu, double suma1) {
        super();
        this.iplata = iplata;
        this.mon = mon;
        this.numeu = numeu;
        this.suma1 = suma1;
    }

    public Plata(Plata a) {
        super();
        this.iplata = a.iplata;
        this.mon = a.mon;
        this.numeu = a.numeu;
        this.suma1 = a.suma1;
    }

    public double Taxadeprotectie() {
        double comision = 0.2 * this.suma1;
        return this.suma1 - comision;
    }

    public String toString() {
        return "IdulPLati:" + this.iplata + "Currency:" + this.mon + " Nume utilizator:" + this.numeu + " Bani lui/ei sunt:" + this.suma1;
    }

    public String verificabani() {
        if (this.suma1 > (double)0.0F) {
            return " E ok " + this.suma1;
        } else {
            return this.suma1 == (double)0.0F ? " E zero man " + this.suma1 : " GO and GET a  Job! " + this.suma1;
        }
    }
}
