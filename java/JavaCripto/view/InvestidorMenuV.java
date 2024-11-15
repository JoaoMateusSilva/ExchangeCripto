import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvestidorMenuV extends JFrame {
    private Investidorc investidorController;

    public InvestidorMenuV(Investidorc investidorController) {
        this.investidorController = investidorController;

        setTitle("Menu do Investidor - Exchange de Criptomoedas");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        JLabel title = new JLabel("Menu do Investidor", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.CYAN);

        JPanel actionPanel = new JPanel(new GridBagLayout());
        actionPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel depositarLabel = new JLabel("Depositar Saldo:");
        depositarLabel.setForeground(Color.CYAN);
        JTextField depositarField = new JTextField(20);
        JButton depositarButton = new JButton("Depositar");
        depositarButton.setBackground(new Color(30, 144, 255));
        depositarButton.setForeground(Color.WHITE);

        JLabel sacarLabel = new JLabel("Sacar Saldo:");
        sacarLabel.setForeground(Color.CYAN);
        JTextField sacarField = new JTextField(20);
        JButton sacarButton = new JButton("Sacar");
        sacarButton.setBackground(new Color(30, 144, 255));
        sacarButton.setForeground(Color.WHITE);

        JLabel comprarLabel = new JLabel("Comprar Criptomoeda:");
        comprarLabel.setForeground(Color.CYAN);
        JTextField comprarField = new JTextField(20);
        JComboBox<String> criptoCompraCombo = new JComboBox<>(new String[]{"Bitcoin", "Ethereum", "Ripple"});
        JButton comprarButton = new JButton("Comprar");
        comprarButton.setBackground(new Color(30, 144, 255));
        comprarButton.setForeground(Color.WHITE);

        JLabel venderLabel = new JLabel("Vender Criptomoeda:");
        venderLabel.setForeground(Color.CYAN);
        JTextField venderField = new JTextField(20);
        JComboBox<String> criptoVendaCombo = new JComboBox<>(new String[]{"Bitcoin", "Ethereum", "Ripple"});
        JButton venderButton = new JButton("Vender");
        venderButton.setBackground(new Color(30, 144, 255));
        venderButton.setForeground(Color.WHITE);

        JButton consultarSaldoButton = new JButton("Consultar Saldo");
        consultarSaldoButton.setBackground(new Color(30, 144, 255));
        consultarSaldoButton.setForeground(Color.WHITE);

        JButton consultarExtratoButton = new JButton("Consultar Extrato");
        consultarExtratoButton.setBackground(new Color(30, 144, 255));
        consultarExtratoButton.setForeground(Color.WHITE);

        depositarButton.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(depositarField.getText());
                if (investidorController.depositar("123.456.789-00", valor)) {
                    JOptionPane.showMessageDialog(null, "Depósito de R$ " + valor + " realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar depósito.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido para depósito.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        sacarButton.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(sacarField.getText());
                if (investidorController.sacar("123.456.789-00", valor)) {
                    JOptionPane.showMessageDialog(null, "Saque de R$ " + valor + " realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido para saque.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        comprarButton.addActionListener(e -> {
            String cripto = (String) criptoCompraCombo.getSelectedItem();
            try {
                double valor = Double.parseDouble(comprarField.getText());
                if (investidorController.comprarCriptomoeda("123.456.789-00", cripto, valor)) {
                    JOptionPane.showMessageDialog(null, "Compra de " + valor + " " + cripto + " realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido para compra.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        venderButton.addActionListener(e -> {
            String cripto = (String) criptoVendaCombo.getSelectedItem();
            try {
                double valor = Double.parseDouble(venderField.getText());
                if (investidorController.venderCriptomoeda("123.456.789-00", cripto, valor)) {
                    JOptionPane.showMessageDialog(null, "Venda de " + valor + " " + cripto + " realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Quantidade insuficiente para venda.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido para venda.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        consultarSaldoButton.addActionListener(e -> {
            String saldo = investidorController.consultarSaldo("123.456.789-00");
            JOptionPane.showMessageDialog(null, saldo, "Saldo Atual", JOptionPane.INFORMATION_MESSAGE);
        });

        consultarExtratoButton.addActionListener(e -> {
            String extrato = investidorController.consultarExtrato("123.456.789-00");
            JOptionPane.showMessageDialog(null, extrato, "Extrato de Operações", JOptionPane.INFORMATION_MESSAGE);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        actionPanel.add(depositarLabel, gbc);
        gbc.gridx = 1;
        actionPanel.add(depositarField, gbc);
        gbc.gridx = 2;
        actionPanel.add(depositarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        actionPanel.add(sacarLabel, gbc);
        gbc.gridx = 1;
        actionPanel.add(sacarField, gbc);
        gbc.gridx = 2;
        actionPanel.add(sacarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        actionPanel.add(comprarLabel, gbc);
        gbc.gridx = 1;
        actionPanel.add(comprarField, gbc);
        gbc.gridx = 2;
        actionPanel.add(criptoCompraCombo, gbc);
        gbc.gridx = 3;
        actionPanel.add(comprarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        actionPanel.add(venderLabel, gbc);
        gbc.gridx = 1;
        actionPanel.add(venderField, gbc);
        gbc.gridx = 2;
        actionPanel.add(criptoVendaCombo, gbc);
        gbc.gridx = 3;
        actionPanel.add(venderButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        actionPanel.add(consultarSaldoButton, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        actionPanel.add(consultarExtratoButton, gbc);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(actionPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
}
