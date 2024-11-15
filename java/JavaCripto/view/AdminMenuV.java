import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuV extends JFrame {

    private JButton cadastrarInvestidorButton;
    private JButton consultarSaldoButton;
    private JButton atualizarCotacaoButton;

    public AdminMenuV() {
        setTitle("Menu do Administrador - Exchange de Criptomoedas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        cadastrarInvestidorButton = new JButton("Cadastrar Investidor");
        cadastrarInvestidorButton.addActionListener(new CadastroInvestidorAction());
        panel.add(cadastrarInvestidorButton);

        consultarSaldoButton = new JButton("Consultar Saldo");
        consultarSaldoButton.addActionListener(new ConsultarSaldoAction());
        panel.add(consultarSaldoButton);

        atualizarCotacaoButton = new JButton("Atualizar Cotação");
        atualizarCotacaoButton.addActionListener(new AtualizarCotacaoAction());
        panel.add(atualizarCotacaoButton);

        add(panel);
    }

    private class CadastroInvestidorAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null, "Função de cadastro em desenvolvimento.");
        }
    }

    private class ConsultarSaldoAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null, "Função de consulta de saldo em desenvolvimento.");
        }
    }

 
    private class AtualizarCotacaoAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Função de atualização de cotação em desenvolvimento.");
        }
    }
}
