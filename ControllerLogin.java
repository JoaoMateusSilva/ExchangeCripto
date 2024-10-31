package controller;

import view.janelaLogin;
import model.Investidor;
import java.util.Map;

public class LoginController {
    private janelaLogin loginView;
    private Map<String, Investidor> investidores;

    public LoginController(janelaLogin loginView, Map<String, Investidor> investidores) {
        this.loginView = loginView;
        this.investidores = investidores;
    }

    public boolean autenticar(String cpf, int senha) {
        Investidor investidor = investidores.get(cpf);
        if (investidor != null && investidor.getSenha().equals(String.valueOf(senha))) {
            System.out.println("Login bem-sucedido!");
            return true;
        } else {
            System.out.println("CPF ou senha incorretos.");
            return false;
        }
    }

    public void setLoginView(janelaLogin loginView) {
        this.loginView = loginView;
    }

    public janelaLogin getLoginView() {
        return loginView;
    }
}
