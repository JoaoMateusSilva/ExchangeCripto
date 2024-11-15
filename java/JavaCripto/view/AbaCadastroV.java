import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AbaCadastroV extends JFrame {
    private Runnable cadastroListener;
    private Investidordata investidordata;

    public AbaCadastroV(Investidordata investidordata) {
        this.investidordata = investidordata;

        setTitle("Cadastro - Exchange de Criptomoedas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        JLabel title = new JLabel("Cadastro de Usuário", SwingConstants.CENTER);
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

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(new Color(30, 144, 255));
        cadastrarButton.setForeground(Color.WHITE);

        cadastrarButton.addActionListener(e -> {
            String cpf = cpfField.getText();
            String senha = new String(senhaField.getPassword());
            InvestidorM novoInvestidor = new InvestidorM(cpf, senha);
            investidordata.adicionarInvestidor(novoInvestidor);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

            if (cadastroListener != null) {
                cadastroListener.run();
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
        formPanel.add(cadastrarButton, gbc);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public void addCadastroListener(Runnable listener) {
        this.cadastroListener = listener;
    }
}
