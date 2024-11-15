public class AbaLoginc {
    private Investidordata investidordata;

    public AbaLoginc(Investidordata investidordata) {
        this.investidordata = investidordata;
    }

    public boolean autenticar(String cpf, String senha) {
        InvestidorM investidor = investidordata.buscarInvestidor(cpf);
        return investidor != null && investidor.getSenha().equals(senha);
    }
}
