import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Investidordata investidordata = new Investidordata();
            Administradordata administradordata = new Administradordata();
            Conexaodata.inicializarDados(investidordata, administradordata);
            new Main().iniciarPrograma(investidordata, administradordata);
        });
    }

    public void iniciarPrograma(Investidordata investidordata, Administradordata administradordata) {
        exibirTelaCadastro(investidordata);
    }

    private void exibirTelaCadastro(Investidordata investidordata) {
        AbaCadastroV cadastroFrame = new AbaCadastroV(investidordata);
        cadastroFrame.setVisible(true);

        cadastroFrame.addCadastroListener(() -> {
            cadastroFrame.dispose();
            exibirTelaLogin(investidordata);
        });
    }

    private void exibirTelaLogin(Investidordata investidordata) {
        Investidorc investidorController = new Investidorc(investidordata);
        AbaLoginV loginFrame = new AbaLoginV(investidorController);
        loginFrame.setVisible(true);

        loginFrame.addLoginListener(() -> {
            loginFrame.dispose();
            exibirMenuInvestidor(investidorController);
        });
    }

    private void exibirMenuInvestidor(Investidorc investidorController) {
        InvestidorMenuV investidorMenuFrame = new InvestidorMenuV(investidorController);
        investidorMenuFrame.setVisible(true);
    }
}
