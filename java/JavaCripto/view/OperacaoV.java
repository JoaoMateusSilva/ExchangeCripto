package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacaoV extends JFrame {
    private JTextField senhaField;
    private JButton consultarExtratoBtn;

    public OperacaoV() {
        setTitle("Consultar Extrato - Carteira de Investimentos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);

        setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Consultar Extrato", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.CYAN);
        add(titleLabel);

        JPanel senhaPanel = new JPanel();
        senhaPanel.setBackground(Color.BLACK);
        senhaPanel.setLayout(new FlowLayout());

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setForeground(Color.CYAN);
        senhaField = new JTextField(10);
        senhaPanel.add(senhaLabel);
        senhaPanel.add(senhaField);

        consultarExtratoBtn = new JButton("Consultar Extrato");
        consultarExtratoBtn.setBackground(Color.BLUE);
        consultarExtratoBtn.setForeground(Color.WHITE);

        add(senhaPanel);
        add(consultarExtratoBtn);

        consultarExtratoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
