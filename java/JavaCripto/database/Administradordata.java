import java.util.ArrayList;
import java.util.List;

public class Administradordata {
    private List<AdministradorM> administradores;

    public Administradordata() {
        administradores = new ArrayList<>();
    }

    public void adicionarAdministrador(AdministradorM administrador) {
        administradores.add(administrador);
    }

    public AdministradorM buscarAdministrador(String cpf) {
        for (AdministradorM administrador : administradores) {
            if (administrador.getCpf().equals(cpf)) {
                return administrador;
            }
        }
        return null;
    }

    public boolean autenticar(String cpf, String senha) {
        AdministradorM administrador = buscarAdministrador(cpf);
        return administrador != null && administrador.getSenha().equals(senha);
    }
}
