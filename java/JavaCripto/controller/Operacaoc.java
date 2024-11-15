public class Operacaoc {
    public OperacaoM realizarOperacao(String tipo, String nomeCriptomoeda, double quantidade, double valorUnitario) {
        double valorTotal = quantidade * valorUnitario;
        return new OperacaoM(tipo, nomeCriptomoeda, quantidade, valorTotal);
    }
}
