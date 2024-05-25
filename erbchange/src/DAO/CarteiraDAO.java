package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Carteira;

public class CarteiraDAO {
    private Connection conn;

    public CarteiraDAO(Connection conn) {
        this.conn = conn;
    }

    public Carteira buscarCarteira(int id) throws SQLException {
        String sql = "SELECT * FROM carteira WHERE id_carteira = ?";
        Carteira carteira_investidor = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    carteira_investidor = new Carteira();
                    String nomes_moedas[] = {"real", "bitcoin", "ethereum", "ripple"};
                    for(String nome:nomes_moedas){
                        double saldo = rs.getDouble(nome);
                        carteira_investidor.setQuantidadeCarteira(nome, saldo);
                    } 
                }
            }
        }
        return carteira_investidor;
    }
    
    public int buscarIdCarteiraPorCPF(String cpf) throws SQLException {
        String sql = "SELECT carteira FROM investidor WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("carteira");
                } else {
                    throw new SQLException("Carteira não encontrada para o CPF fornecido.");
                }
            }
        }
    }

    public void atualizarSaldoReal(int idCarteira, double novoSaldo) throws SQLException {
        String sql = "UPDATE carteira SET real = ? WHERE id_carteira = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldo);
            stmt.setInt(2, idCarteira);
            stmt.executeUpdate();
        }
    }
}