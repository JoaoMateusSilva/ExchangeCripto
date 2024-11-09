package view;

import javax.swing.*;
import model.Investidor;

public class InvestidorMenuV extends JFrame {
    private Investidor investidor;

    public InvestidorMenuV(Investidor investidor) {
        this.investidor = investidor;
        setTitle("Menu do Investidor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton saldoButton = new JButton("Consultar Saldo");
        JButton extratoButton = new JButton("Consultar Extrato");
        JButton depositoButton = new JButton("Depositar");
        JButton saqueButton = new JButton("Sacar");
        JButton compraButton = new JButton("Comprar Criptomoedas");
        JButton vendaButton = new JButton("Vender Criptomoedas");

        panel.add(saldoButton);
        panel.add(extratoButton);
        panel.add(depositoButton);
        panel.add(saqueButton);
        panel.add(compraButton);
        panel.add(vendaButton);

        saldoButton.addActionListener(e -> new CarteiraV(investidor).setVisible(true));
        extratoButton.addActionListener(e -> new OperacaoV(investidor, "Extrato").setVisible(true));
        depositoButton.addActionListener(e -> new OperacaoV(investidor, "Depósito").setVisible(true));
        saqueButton.addActionListener(e -> new OperacaoV(investidor, "Saque").setVisible(true));
        compraButton.addActionListener(e -> new OperacaoV(investidor, "Compra").setVisible(true));
        vendaButton.addActionListener(e -> new OperacaoV(investidor, "Venda").setVisible(true));

        add(panel);
    }
}
