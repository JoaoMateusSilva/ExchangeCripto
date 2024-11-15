public class OperacaoM {
    private String tipo; // "Compra" ou "Venda"
    private String nomeCriptomoeda;
    private double quantidade;
    private double valorTotal;

    public OperacaoM(String tipo, String nomeCriptomoeda, double quantidade, double valorTotal) {
        this.tipo = tipo;
        this.nomeCriptomoeda = nomeCriptomoeda;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNomeCriptomoeda() {
        return nomeCriptomoeda;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
