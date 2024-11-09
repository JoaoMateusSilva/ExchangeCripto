package controller;

import database.AdministradorDAO;
import model.Administrador;

public class Administradorc {
    private AdministradorDAO administradorDAO;

    public Administradorc() {
        this.administradorDAO = new AdministradorDAO();
    }

    public boolean adicionarAdministrador(String nome, String cpf, String senha) {
        Administrador novoAdministrador = new Administrador(nome, cpf, senha);
        return administradorDAO.adicionarAdministrador(novoAdministrador);
    }

    public Administrador buscarAdministrador(String cpf) {
        return administradorDAO.buscarAdministradorPorCpf(cpf);
    }
}

