package database;

import model.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administradordata {

    public boolean adicionarAdministrador(Administrador administrador) {
        String sql = "INSERT INTO administradores (nome, cpf, senha) VALUES (?, ?, ?)";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, administrador.getNome());
            stmt.setString(2, administrador.getCpf());
            stmt.setString(3, administrador.getSenha());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar administrador: " + e.getMessage());
            return false;
        }
    }

    public Administrador buscarAdministradorPorCpf(String cpf) {
        String sql = "SELECT * FROM administradores WHERE cpf = ?";
        try (Connection conn = Conexaodata.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Administrador(rs.getString("nome"), rs.getString("cpf"), rs.getString("senha"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar administrador: " + e.getMessage());
        }
        return null;
    }
}
