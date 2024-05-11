package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Investidor;
import java.sql.ResultSet;



public class InvestidorDAO {
    private Connection conn;
    
    public InvestidorDAO(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Investidor investidor) throws SQLException{
        String sql = "inset into investidor (nome, cpf, senha) values" + "('"+ investidor.getNome()+"','"+investidor.getCpf()+"','"+investidor.getSenha()+"')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public ResultSet consultar(Investidor investidor) throws SQLException{
        String sql = "select * from investidor where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getNome());
        statement.setString(2, investidor.getCpf());
        statement.setString(3, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void atualizar(Investidor investidor) throws SQLException{
        String sql = "update investidor set senha = / ? where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(3,investidor.getSenha());
    }
    
    public void remover(Investidor investidor) throws SQLException{
        String sql = "delete from investidor where usuario =?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,investidor.getSenha());
        statement.execute();
        conn.close();
    }
}