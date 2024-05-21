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
                    double saldoBRL = rs.getDouble("BRL");
                    double saldoBTC = rs.getDouble("BTC");
                    double saldoETH = rs.getDouble("ETH");
                    double saldoXRP = rs.getDouble("XRP");
                    carteira_investidor.setMoedas("BRL", saldoBRL);
                    
                    
                }
            }
        }
        return carteira;
    }
}