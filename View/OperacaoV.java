package view;

import javax.swing.*;
import model.Investidor;

public class OperacaoV extends JFrame {
    public OperacaoV(Investidor investidor, String tipoOperacao) {
        setTitle(tipoOperacao);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Valor:");
        JTextField campoValor = new JTextField(10);
        JButton confirmarButton = new JButton("Confirmar");

        confirmarButton.addActionListener(e -> {
            double valor = Double.parseDouble(campoValor.getText());
            JOptionPane.showMessageDialog(this, tipoOperacao + " realizado com sucesso!");
            dispose();
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(campoValor);
        panel.add(confirmarButton);
        add(panel);
    }
}
