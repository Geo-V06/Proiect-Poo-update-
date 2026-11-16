import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfata1 extends JFrame {

    private ArrayList<Plata> listaPlati;
    private ArrayList<Transfer> listaTransferuri;

    private JTextField txtValoare;
    private JTextArea txtRezultate;

    public Interfata1(ArrayList<Plata> plati, ArrayList<Transfer> transferuri) {
        this.listaPlati = plati;
        this.listaTransferuri = transferuri;


        setTitle("Interfață Gestionare Tranzacții - POO");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());


        JPanel panelSus = new JPanel();
        panelSus.setLayout(new FlowLayout());

        panelSus.add(new JLabel("Valoare / Lungime ID:"));
        txtValoare = new JTextField(10);
        panelSus.add(txtValoare);

        JButton btnFrauda = new JButton("Verifică Fraude ID (<5)");
        JButton btnSuma = new JButton("Filtrează după Sumă Minimă");

        panelSus.add(btnFrauda);
        panelSus.add(btnSuma);

        add(panelSus, BorderLayout.NORTH);


        txtRezultate = new JTextArea();
        txtRezultate.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtRezultate);
        add(scrollPane, BorderLayout.CENTER);


        btnFrauda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtRezultate.setText("");
                txtRezultate.append("=== VERIFICARE TENTATIVE FRAUDĂ ===\n");

                boolean gasit = false;
                for (Plata p : listaPlati) {
                    if (p.getIplata() != null && p.getIplata().length() < 5) {
                        txtRezultate.append("[SUSPECT] Plată: " + p.toString() + "\n");
                        gasit = true;
                    }
                }
                for (Transfer t : listaTransferuri) {
                    if (t.getIdT() != null && t.getIdT().length() < 5) {
                        txtRezultate.append("[SUSPECT] Transfer: " + t.toString() + "\n");
                        gasit = true;
                    }
                }
                if (!gasit) {
                    txtRezultate.append("Nu s-au detectat ID-uri suspecte.\n");
                }
            }
        });


        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double sumaMinima = Double.parseDouble(txtValoare.getText());
                    if (sumaMinima < 0) {
                        JOptionPane.showMessageDialog(null, "Suma nu poate fi negativă!", "Eroare", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    txtRezultate.setText("");
                    txtRezultate.append("=== REZULTATE FILTRARE DUPĂ SUMA >= " + sumaMinima + " ===\n");

                    boolean gasit = false;
                    for (Plata p : listaPlati) {
                        if (p.getSuma1() >= sumaMinima) {
                            txtRezultate.append("Plată: " + p.toString() + "\n");
                            gasit = true;
                        }
                    }
                    for (Transfer t : listaTransferuri) {
                        if (t.getSuma2() >= sumaMinima) {
                            txtRezultate.append("Transfer: " + t.toString() + "\n");
                            gasit = true;
                        }
                    }
                    if (!gasit) {
                        txtRezultate.append("Niciun rezultat găsit peste această sumă.\n");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Te rog introdu un număr valid în căsuță!", "Eroare de format", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}