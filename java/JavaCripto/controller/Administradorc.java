public class Administradorc {
    private Administradordata administradordata;

    public Administradorc(Administradordata administradordata) {
        this.administradordata = administradordata;
    }

    public boolean autenticarAdministrador(String cpf, String senha) {
        AdministradorM administrador = administradordata.buscarAdministrador(cpf);
        return administrador != null && administrador.getSenha().equals(senha);
    }
}
