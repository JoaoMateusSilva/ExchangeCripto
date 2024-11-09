package controller;

import database.MoedaDAO;
import model.Moeda;
import java.util.List;

public class MoedaCont {
    private MoedaDAO moedaDAO;

    public MoedaCont() {
        this.moedaDAO = new MoedaDAO();
    }

    public boolean adicionarMoeda(String nome, double cotacao, double taxaCompra, double taxaVenda) {
        Moeda novaMoeda = new Moeda(nome, cotacao, taxaCompra, taxaVenda);
        return moedaDAO.adicionarMoeda(novaMoeda);
    }

    public boolean removerMoeda(String nome) {
        return moedaDAO.removerMoeda(nome);
    }

    public List<Moeda> listarMoedas() {
        return moedaDAO.listarMoedas();
    }
}
