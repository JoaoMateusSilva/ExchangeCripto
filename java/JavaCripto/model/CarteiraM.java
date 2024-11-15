import java.util.HashMap;

public class CarteiraM {
    private double saldoReais;
    private HashMap<String, Double> criptomoedas;

    public CarteiraM() {
        this.saldoReais = 0.0;
        this.criptomoedas = new HashMap<>();
    }

    public double getSaldoReais() {
        return saldoReais;
    }

    public void depositar(double valor) {
        saldoReais += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldoReais) {
            saldoReais -= valor;
            return true;
        }
        return false;
    }

    public void adicionarCriptomoeda(String nome, double quantidade) {
        criptomoedas.put(nome, criptomoedas.getOrDefault(nome, 0.0) + quantidade);
    }

    public double getCriptomoeda(String nome) {
        return criptomoedas.getOrDefault(nome, 0.0);
    }
}
