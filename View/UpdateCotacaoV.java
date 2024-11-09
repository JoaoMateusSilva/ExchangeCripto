package view;

import javax.swing.*;
import model.Carteira;
import java.util.Random;

public class UpdateCotacaoV extends JFrame {
    public UpdateCotacaoV() {
        setTitle("Atualizar Cotação");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JButton atualizarButton = new JButton("Atualizar Cotações");

        atualizarButton.addActionListener(e -> {
            Random random = new Random();
            double[] cotacoes = {
                Carteira.getCotacao("Bitcoin"),
                Carteira.getCotacao("Ethereum"),
                Carteira.getCotacao("Ripple")
            };

            for (int i = 0; i < cotacoes.length; i++) {
                double variacao = 1 + (random.nextDouble() * 0.1 - 0.05);
                cotacoes[i] *= variacao;
            }
            Carteira.atualizarCotacao("Bitcoin", cotacoes[0]);
            Carteira.atualizarCotacao("Ethereum", cotacoes[1]);
            Carteira.atualizarCotacao("Ripple", cotacoes[2]);

            JOptionPane.showMessageDialog(this, "Cotações atualizadas!");
            dispose();
        });

        add(atualizarButton);
    }
}
