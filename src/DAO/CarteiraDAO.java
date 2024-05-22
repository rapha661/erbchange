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
}