package database;

import model.Moeda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Moedadata {

    public boolean adicionarMoeda(Moeda moeda) {
        String sql = "INSERT INTO moedas (nome, cotacao, taxaCompra, taxaVenda) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, moeda.getNome());
            stmt.setDouble(2, moeda.getCotacao());
            stmt.setDouble(3, moeda.getTaxaCompra());
            stmt.setDouble(4, moeda.getTaxaVenda());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar moeda: " + e.getMessage());
            return false;
        }
    }

    public boolean removerMoeda(String nome) {
        String sql = "DELETE FROM moedas WHERE nome = ?";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao remover moeda: " + e.getMessage());
            return false;
        }
    }

    public List<Moeda> listarMoedas() {
        List<Moeda> moedas = new ArrayList<>();
        String sql = "SELECT * FROM moedas";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                moedas.add(new Moeda(rs.getString("nome"), rs.getDouble("cotacao"), rs.getDouble("taxaCompra"), rs.getDouble("taxaVenda")));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar moedas: " + e.getMessage());
        }
        return moedas;
    }
}
