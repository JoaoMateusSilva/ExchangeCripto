package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.InvestidorC;
import model.Investidor;

public class AbaLoginV extends JFrame {
    private JTextField cpfField;
    private JPasswordField passwordField;

    public AbaLoginV() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        cpfField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Senha:"));
        panel.add(passwordField);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String password = new String(passwordField.getPassword());

                InvestidorC investidorController = new InvestidorC();
                Investidor investidor = investidorController.login(cpf, password);

                if (investidor != null) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    new InvestidorMenuV(investidor).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou senha incorretos.");
                }
            }
        });

        add(panel);
    }
}
