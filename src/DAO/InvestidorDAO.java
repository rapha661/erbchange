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

    public void atualizar(Investidor investidor) throws SQLException {
        String sql = "UPDATE investidor SET senha = ? WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getSenha());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        conn.close();
        
    }
}
