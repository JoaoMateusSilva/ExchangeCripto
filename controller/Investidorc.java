package controller;

import model.Investidor;
import model.Carteira;
import database.Investidordata;
import javax.swing.JOptionPane;

public class Investidorc {
    private Investidordata investidorData;

    public Investidorc() {
        this.investidorData = new Investidordata();
    }

    public Investidor login(String cpf, String senha) {
        return investidorData.buscarPorCpfSenha(cpf, senha);
    }

    public String consultarSaldo(Investidor investidor, String senha) {
        if (investidor.getSenha().equals(senha)) {
            Carteira carteira = investidor.getCarteira();
            return "Saldo em Reais: " + carteira.getSaldoReais() + "\n" +
                   "Bitcoin: " + carteira.getQuantidade("Bitcoin") + "\n" +
                   "Ethereum: " + carteira.getQuantidade("Ethereum") + "\n" +
                   "Ripple: " + carteira.getQuantidade("Ripple");
        } else {
            return "Senha incorreta!";
        }
    }

    public void depositarReais(Investidor investidor, double valor) {
        investidor.getCarteira().depositarReais(valor);
        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
    }

    public void sacarReais(Investidor investidor, double valor) {
        if (investidor.getCarteira().getSaldoReais() >= valor) {
            investidor.getCarteira().sacarReais(valor);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque!");
        }
    }

    public void comprarCriptomoeda(Investidor investidor, String moeda, double valor, String senha) {
        if (investidor.getSenha().equals(senha)) {
            Carteira carteira = investidor.getCarteira();
            boolean sucesso = carteira.comprarCriptomoeda(moeda, valor);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Compra de " + moeda + " realizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta!");
        }
    }

    public void venderCriptomoeda(Investidor investidor, String moeda, double valor, String senha) {
        if (investidor.getSenha().equals(senha)) {
            Carteira carteira = investidor.getCarteira();
            boolean sucesso = carteira.venderCriptomoeda(moeda, valor);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Venda de " + moeda + " realizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente de " + moeda + " para venda!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta!");
        }
    }
}
