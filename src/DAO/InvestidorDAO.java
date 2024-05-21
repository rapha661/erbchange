package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Investidor;
import java.sql.ResultSet;

public class InvestidorDAO {
    private Connection conn;

    public InvestidorDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Investidor investidor) throws SQLException {
        String sql = "INSERT INTO investidor (nome, cpf, senha) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, investidor.getNome());
            statement.setString(2, investidor.getCpf());
            statement.setString(3, investidor.getSenha());  
            statement.executeUpdate();
        }  
    }

    public ResultSet consultar(Investidor investidor) throws SQLException {
        String sql = "SELECT * FROM investidor WHERE cpf = ? AND senha = ?";
        ResultSet resultado = null;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, investidor.getCpf());
            statement.setString(2, investidor.getSenha());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                resultado = rs;
            }
        } 
        return resultado;
    }

    public void atualizar(Investidor investidor) throws SQLException {
        String sql = "UPDATE investidor SET senha = ? WHERE cpf = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, investidor.getSenha());
            statement.setString(2, investidor.getCpf());
            statement.executeUpdate();
        }
    }
}
