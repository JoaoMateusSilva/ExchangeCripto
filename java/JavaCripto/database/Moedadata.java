import java.util.HashMap;

public class Moedadata {
    private HashMap<String, MoedaM> moedas;

    public Moedadata() {
        this.moedas = new HashMap<>();
        moedas.put("Bitcoin", new BitcoinM());
        moedas.put("Ethereum", new EthereumM());
        moedas.put("Ripple", new RippleM());
    }

    public MoedaM buscarMoeda(String nome) {
        return moedas.get(nome);
    }

    public void atualizarCotacao(String nome, double novaCotacao) {
        MoedaM moeda = moedas.get(nome);
        if (moeda != null) {
            moeda.atualizarCotacao(novaCotacao);
        }
    }
}
