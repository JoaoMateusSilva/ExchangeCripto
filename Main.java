import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.SwingUtilities;
import view.AbaLoginV;

public class Main {
    public static void main(String[] args) {
        Properties config = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            config.load(input);
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de configuração: " + e.getMessage());
            return;
        }

        SwingUtilities.invokeLater(() -> {
            AbaLoginV loginView = new AbaLoginV(config);
            loginView.setVisible(true);
        });
    }
}
