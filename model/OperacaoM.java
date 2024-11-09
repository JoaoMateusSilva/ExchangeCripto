package model;

import java.time.LocalDateTime;

public class OperacaoM {
    private MoedaM moeda;
    private double quantidade;
    private double valorTotal;
    private LocalDateTime dataHora;
    private String tipoOperacao; // "compra" ou "venda"

    public OperacaoM(MoedaM moeda, double quantidade, double valorTotal, String tipoOperacao) {
        this.moeda = moeda;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.tipoOperacao = tipoOperacao;
        this.dataHora = LocalDateTime.now();
    }

    public MoedaM getMoeda() {
        return moeda;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }
}
