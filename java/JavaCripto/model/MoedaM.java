public class MoedaM {
    private String nome;
    private double cotacaoAtual;

    public MoedaM(String nome, double cotacaoInicial) {
        this.nome = nome;
        this.cotacaoAtual = cotacaoInicial;
    }

    public String getNome() {
        return nome;
    }

    public double getCotacaoAtual() {
        return cotacaoAtual;
    }

    public void atualizarCotacao(double novaCotacao) {
        this.cotacaoAtual = novaCotacao;
    }
}
