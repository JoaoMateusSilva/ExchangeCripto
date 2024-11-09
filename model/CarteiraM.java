package model;

import java.util.ArrayList;
import java.util.List;

public class CarteiraM {
    private InvestidorM investidor;
    private List<MoedaM> moedas;

    public CarteiraM(InvestidorM investidor) {
        this.investidor = investidor;
        this.moedas = new ArrayList<>();
    }

    public void adicionarMoeda(MoedaM moeda) {
        moedas.add(moeda);
    }

    public void removerMoeda(MoedaM moeda) {
        moedas.remove(moeda);
    }

    public List<MoedaM> getMoedas() {
        return moedas;
    }

    public InvestidorM getInvestidor() {
        return investidor;
    }
}
