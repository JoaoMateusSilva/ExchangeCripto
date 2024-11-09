package database;

import model.Investidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Investidordata {

    public boolean adicionarInvestidor(Investidor investidor) {
        String sql = "INSERT INTO investidores (nome, cpf, senha) VALUES (?, ?, ?)";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, investidor.getNome());
            stmt.setString(2, investidor.getCpf());
            stmt.setString(3, investidor.getSenha());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar investidor: " + e.getMessage());
            return false;
        }
    }

    public boolean removerInvestidor(String cpf) {
        String sql = "DELETE FROM investidores WHERE cpf = ?";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao remover investidor: " + e.getMessage());
            return false;
        }
    }

    public Investidor buscarInvestidorPorCpf(String cpf) {
        String sql = "SELECT * FROM investidores WHERE cpf = ?";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Investidor(rs.getString("nome"), rs.getString("cpf"), rs.getString("senha"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar investidor: " + e.getMessage());
        }
        return null;
    }

    public List<Investidor> listarInvestidores() {
        List<Investidor> investidores = new ArrayList<>();
        String sql = "SELECT * FROM investidores";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                investidores.add(new Investidor(rs.getString("nome"), rs.getString("cpf"), rs.getString("senha")));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar investidores: " + e.getMessage());
        }
        return investidores;
    }
}
