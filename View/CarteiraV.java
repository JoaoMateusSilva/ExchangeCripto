package view;

import javax.swing.*;
import controller.InvestidorC;
import model.Investidor;

public class CarteiraV extends JFrame {
    public CarteiraV(Investidor investidor) {
        setTitle("Carteira");
        setSize(300, 200);
        setLocationRelativeTo(null);

        InvestidorC investidorController = new InvestidorC();
        String saldo = investidorController.consultarSaldo(investidor);

        JTextArea saldoArea = new JTextArea(saldo);
        saldoArea.setEditable(false);
        add(new JScrollPane(saldoArea));
    }
}
