public class AdministradorM {
    private String cpf;
    private String senha;

    public AdministradorM(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}
