public abstract class Tranzactie {
    private String iTranzactie;
    private double suma;

    public Tranzactie() {
        super();
    }

    public String getiTranzactie() {
        return this.iTranzactie;
    }

    public void setiTranzactie(String iTranzactie) {
        this.iTranzactie = iTranzactie;
    }

    public double getSuma() {
        return this.suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public String verificabani() {
        if (this.suma > (double)0.0F) {
            return " E ok " + this.suma;
        } else {
            return this.suma == (double)0.0F ? " E zero man " + this.suma : " GO and get a  Job! " + this.suma;
        }
    }

    public double Taxadeprotectie() {
        double comision = 0.05 * this.suma;
        return this.suma - comision;
    }

    public String verificainternetul(boolean Online) {
        return Online ? "Plata se poate efectua!" : "Imposibila!";
    }
}

