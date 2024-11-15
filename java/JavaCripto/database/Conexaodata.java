public class Conexaodata {
    public static void inicializarDados(Investidordata investidordata, Administradordata administradordata) {
        investidordata.adicionarInvestidor(new InvestidorM("123.456.789-00", "invest123"));
        administradordata.adicionarAdministrador(new AdministradorM("111.222.333-44", "admin123"));
    }
}
