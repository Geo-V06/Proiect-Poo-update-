public class Transfer extends Plata {
    private int timptransfer;
    private String conts;
    private String contd;
    private String idT;
    private double suma2;

    public int getTimptransfer() {
        return this.timptransfer;
    }

    public void setTimptransfer(int timptransfer) {
        this.timptransfer = timptransfer;
    }

    public String getConts() {
        return this.conts;
    }

    public void setConts(String conts) {
        this.conts = conts;
    }

    public String getContd() {
        return this.contd;
    }

    public void setContd(String contd) {
        this.contd = contd;
    }

    public String getIdT() {
        return this.idT;
    }

    public void setIdT(String idT) {
        this.idT = idT;
    }

    public double getSuma() {
        return this.suma2;
    }

    public void setSuma(double suma2) {
        this.suma2 = suma2;
    }

    public Transfer() {
        super();
        this.timptransfer = 0;
        this.conts = "Nu e el";
        this.contd = "Nici el";
        this.idT = "Nu are id";
        this.suma2 = (double)0.0F;
    }

    public Transfer(String iplata, String mon, String numeu, int timptransfer, String conts, String contd, String idT, double suma2) {
        super(iplata, mon, numeu, suma2);
        this.timptransfer = timptransfer;
        this.conts = conts;
        this.contd = contd;
        this.idT = idT;
        this.suma2 = suma2;
    }

    public double getSuma2() {
        return this.suma2;
    }

    public void setSuma2(double suma2) {
        this.suma2 = suma2;
    }

    public Transfer(Transfer c) {
        super(c);
        this.timptransfer = c.timptransfer;
        this.conts = c.conts;
        this.contd = c.contd;
        this.idT = c.idT;
        this.suma2 = c.suma2;
    }

    public double Taxadeprotectie() {
        double comision = 0.1 * this.suma2;
        return this.suma2 - comision;
    }

    public String toString() {
        return "Timpul de transfer:" + this.timptransfer + "Contul sursa:" + this.conts + "Contul destinatar:" + this.contd + "Idul Transferului" + this.idT + "Suma de bani a transferului:" + this.suma2;
    }

    public String verificabani() {
        if (this.suma2 > (double)0.0F) {
            return " E ok " + this.suma2;
        } else {
            return this.suma2 == (double)0.0F ? " E zero man " + this.suma2 : " GO and GET a  Job! " + this.suma2;
        }
    }
}