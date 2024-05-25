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
        String sql = "INSERT INTO investidor (nome, cpf, senha) VALUES ('"+investidor.getNome()+"','"+investidor.getCpf()+"', '"+investidor.getSenha()+"')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
        }  

    public ResultSet consultar(Investidor investidor) throws SQLException {
        String sql = "SELECT * FROM investidor WHERE cpf = ? AND senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet(); 
        return resultado;
    }

    public void atualizarSenha(String cpf, String novaSenha) throws SQLException {
        String sql = "UPDATE investidor SET senha = ? WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novaSenha);
            stmt.setString(2, cpf);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Atualização da senha falhou, nenhum usuário encontrado com o CPF fornecido.");
            }
        }
    }
}
