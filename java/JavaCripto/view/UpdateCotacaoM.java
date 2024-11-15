package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCotacaoM extends JFrame {
    private JButton atualizarCotacaoBtn;

    public UpdateCotacaoM() {
        setTitle("Atualizar Cotação - Exchange de Criptomoedas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);

        setLayout(new GridLayout(2, 1));

        JLabel titleLabel = new JLabel("Atualizar Cotação das Criptomoedas", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.CYAN);
        add(titleLabel);

        atualizarCotacaoBtn = new JButton("Atualizar Cotação");
        atualizarCotacaoBtn.setBackground(Color.BLUE);
        atualizarCotacaoBtn.setForeground(Color.WHITE);

        add(atualizarCotacaoBtn);

        atualizarCotacaoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
