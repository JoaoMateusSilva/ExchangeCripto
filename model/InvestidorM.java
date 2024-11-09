package model;

public class InvestidorM extends PessoaM {
    private String senha;

    public InvestidorM(String nome, String cpf, String senha) {
        super(nome, cpf);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
