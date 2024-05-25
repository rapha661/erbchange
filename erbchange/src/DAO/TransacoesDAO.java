package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Transacao;

public class TransacoesDAO {
    private Connection conn;

    public TransacoesDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Transacao> buscarTransacoesPorCPF(String cpf) throws SQLException {
        String sql = "SELECT * FROM transacoes WHERE cpf = ? ORDER BY data_hora DESC";
        List<Transacao> transacoes = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transacao transacao = new Transacao();
                    transacao.setIdTransacao(rs.getInt("id_transacao"));
                    transacao.setCpf(rs.getString("cpf"));
                    transacao.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
                    transacao.setTipo(rs.getString("tipo"));
                    transacao.setValorTotal(rs.getDouble("valor_total"));
                    transacao.setMoeda(rs.getString("moeda"));
                    transacao.setCotacao(rs.getDouble("cotacao"));
                    transacao.setTaxa(rs.getDouble("taxa"));
                    transacao.setSaldoReal(rs.getDouble("saldo_real"));
                    transacao.setSaldoBitcoin(rs.getDouble("saldo_bitcoin"));
                    transacao.setSaldoEthereum(rs.getDouble("saldo_ethereum"));
                    transacao.setSaldoRipple(rs.getDouble("saldo_ripple"));
                    transacoes.add(transacao);
                }
            }
        }
        return transacoes;
    }
    
    public void registrarTransacao(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO transacoes (cpf, data_hora, tipo, valor_total, moeda, cotacao, taxa, saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, transacao.getCpf());
            stmt.setObject(2, transacao.getDataHora());
            stmt.setString(3, transacao.getTipo());
            stmt.setDouble(4, transacao.getValorTotal());
            stmt.setString(5, transacao.getMoeda());
            stmt.setDouble(6, transacao.getCotacao());
            stmt.setDouble(7, transacao.getTaxa());
            stmt.setDouble(8, transacao.getSaldoReal());
            stmt.setDouble(9, transacao.getSaldoBitcoin());
            stmt.setDouble(10, transacao.getSaldoEthereum());
            stmt.setDouble(11, transacao.getSaldoRipple());
            stmt.executeUpdate();
        }
    }
}
