import java.util.ArrayList;
import java.util.List;

public class Investidordata {
    private List<InvestidorM> investidores;

    public Investidordata() {
        investidores = new ArrayList<>();
    }

    public void adicionarInvestidor(InvestidorM investidor) {
        investidores.add(investidor);
    }

    public InvestidorM buscarInvestidor(String cpf) {
        for (InvestidorM investidor : investidores) {
            if (investidor.getCpf().equals(cpf)) {
                return investidor;
            }
        }
        return null;
    }

    public boolean autenticar(String cpf, String senha) {
        InvestidorM investidor = buscarInvestidor(cpf);
        return investidor != null && investidor.getSenha().equals(senha);
    }
}
