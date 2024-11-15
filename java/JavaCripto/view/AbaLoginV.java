import javax.swing.*;
import java.awt.*;

public class AbaLoginV extends JFrame {
    private Runnable loginListener;
    private Investidorc investidorController;

    public AbaLoginV(Investidorc investidorController) {
        this.investidorController = investidorController;

        setTitle("Login - Exchange de Criptomoedas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        JLabel title = new JLabel("Login do Usuário", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.CYAN);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setForeground(Color.CYAN);
        JTextField cpfField = new JTextField(20);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setForeground(Color.CYAN);
        JPasswordField senhaField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(30, 144, 255));
        loginButton.setForeground(Color.WHITE);

        loginButton.addActionListener(e -> {
            String cpf = cpfField.getText();
            String senha = new String(senhaField.getPassword());

            if (investidorController.autenticarInvestidor(cpf, senha)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                if (loginListener != null) {
                    loginListener.run();
                }
            } else {
                JOptionPane.showMessageDialog(null, "CPF ou senha incorretos.");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(cpfLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(cpfField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(senhaLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(senhaField, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(loginButton, gbc);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public void addLoginListener(Runnable listener) {
        this.loginListener = listener;
    }
}
