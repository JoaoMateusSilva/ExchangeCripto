package model;

public class MoedaM {
    private String nome;
    private double cotacao;
    private double taxaCompra;
    private double taxaVenda;

    public MoedaM(String nome, double cotacao, double taxaCompra, double taxaVenda) {
        this.nome = nome;
        this.cotacao = cotacao;
        this.taxaCompra = taxaCompra;
        this.taxaVenda = taxaVenda;
    }

    public String getNome() {
        return nome;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public double getTaxaCompra() {
        return taxaCompra;
    }

    public void setTaxaCompra(double taxaCompra) {
        this.taxaCompra = taxaCompra;
    }

    public double getTaxaVenda() {
        return taxaVenda;
    }

    public void setTaxaVenda(double taxaVenda) {
        this.taxaVenda = taxaVenda;
    }
}
