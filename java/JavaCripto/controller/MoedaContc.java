public class MoedaContc {
    private Moedadata moedadata;

    public MoedaContc(Moedadata moedadata) {
        this.moedadata = moedadata;
    }

    public void atualizarCotacao(String nome, double novaCotacao) {
        moedadata.atualizarCotacao(nome, novaCotacao);
    }

    public double consultarCotacao(String nome) {
        MoedaM moeda = moedadata.buscarMoeda(nome);
        return moeda != null ? moeda.getCotacaoAtual() : 0.0;
    }
}
