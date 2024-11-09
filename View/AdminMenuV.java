package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuV extends JFrame {
    public AdminMenuV() {
        setTitle("Menu do Administrador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        String[] options = {
            "Cadastrar Novo Investidor",
            "Excluir Investidor",
            "Cadastrar Nova Criptomoeda",
            "Excluir Criptomoeda",
            "Consultar Saldo de Investidor",
            "Consultar Extrato de Investidor",
            "Atualizar Cotação",
            "Sair"
        };

        for (String option : options) {
            JButton button = new JButton(option);
            panel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
        }

        add(panel);
    }
}
