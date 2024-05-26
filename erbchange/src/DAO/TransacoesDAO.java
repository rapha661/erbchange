package DAO;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Transacao;

public class TransacoesDAO {
    private Connection connection;

    public TransacoesDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Transacao> consultarExtrato(String cpf) throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT cpf, data_hora, tipo, valor_total, moeda, cotacao, taxa, saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple FROM transacoes WHERE cpf = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Transacao transacao = new Transacao(
                    rs.getString("cpf"),
                    rs.getTimestamp("data_hora").toLocalDateTime(),
                    rs.getString("tipo"),
                    rs.getDouble("valor_total"),
                    rs.getString("moeda"),
                    rs.getDouble("cotacao"),
                    rs.getDouble("taxa"),
                    rs.getDouble("saldo_real"),
                    rs.getDouble("saldo_bitcoin"),
                    rs.getDouble("saldo_ethereum"),
                    rs.getDouble("saldo_ripple")
                );
                transacoes.add(transacao);
            }
        }
        return transacoes;
    }
    
    public void inserirTransacao(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO transacoes (cpf, data_hora, tipo, valor_total, moeda, cotacao, taxa, saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            String dataHora = transacao.getDataHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            stmt.setString(1, transacao.getCpf());
            stmt.setString(2, dataHora);
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
