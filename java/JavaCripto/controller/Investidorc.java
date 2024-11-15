public class Investidorc {
    private Investidordata investidordata;

    public Investidorc(Investidordata investidordata) {
        this.investidordata = investidordata;
    }

    public boolean autenticarInvestidor(String cpf, String senha) {
        return investidordata.autenticar(cpf, senha);
    }

    public boolean depositar(String cpf, double valor) {
        InvestidorM investidor = investidordata.buscarInvestidor(cpf);
        if (investidor != null && valor > 0) {

            return true;
        }
        return false;
    }

    public boolean sacar(String cpf, double valor) {

        return true;
    }

    public boolean comprarCriptomoeda(String cpf, String cripto, double valor) {
        InvestidorM investidor = investidordata.buscarInvestidor(cpf);
        if (investidor != null) {
            return true;
        }
        return false;
    }

    public boolean venderCriptomoeda(String cpf, String cripto, double valor) {
        InvestidorM investidor = investidordata.buscarInvestidor(cpf);
        if (investidor != null) {

            return true;
        }
        return false;
    }

    public String consultarSaldo(String cpf) {

        return "Saldo:\nCPF: 123.456.789-01\nReais: R$ 1000\nBitcoin: 0.5\nEthereum: 2.0\nRipple: 150.0";
    }
    public String consultarExtrato(String cpf) {

        return "Extrato:\nCPF: 123.456.789-01\n Deposito R$ 1350.00 \nCompra de Bitcoin: 0.1 BTC\n Compra de Ethereum : 2.0 ETH\n Compra de Ripple:200 XRP\nVenda de Ripple: 50 XRP";
    }
}
