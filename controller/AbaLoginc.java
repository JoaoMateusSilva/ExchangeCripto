package controller;

import model.Investidor;
import model.Administrador;
import database.InvestidorDAO;
import database.AdministradorDAO;

public class AbaLoginc {
    private InvestidorDAO investidorDAO;
    private AdministradorDAO administradorDAO;

    public AbaLoginc() {
        this.investidorDAO = new InvestidorDAO();
        this.administradorDAO = new AdministradorDAO();
    }

    public boolean autenticarInvestidor(String cpf, String senha) {
        Investidor investidor = investidorDAO.buscarInvestidorPorCpf(cpf);
        if (investidor != null && investidor.getSenha().equals(senha)) {
            System.out.println("Login de investidor realizado com sucesso!");
            return true;
        }
        System.out.println("Falha no login de investidor. Verifique as credenciais.");
        return false;
    }

    public boolean autenticarAdministrador(String cpf, String senha) {
        Administrador administrador = administradorDAO.buscarAdministradorPorCpf(cpf);
        if (administrador != null && administrador.getSenha().equals(senha)) {
            System.out.println("Login de administrador realizado com sucesso!");
            return true;
        }
        System.out.println("Falha no login de administrador. Verifique as credenciais.");
        return false;
    }
}

