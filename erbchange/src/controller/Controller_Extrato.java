package controller;

import DAO.Conexao;
import DAO.TransacoesDAO;
import model.Investidor;
import model.Transacao;
import view.Extrato_window;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Controller_Extrato {
    private Investidor investidor;
    private Extrato_window view;

    public Controller_Extrato(Investidor investidor, Extrato_window view) {
        this.investidor = investidor;
        this.view = view;
    }

    public void verExtrato() {
        try (Connection conn = new Conexao().getConnection()) {
            TransacoesDAO dao = new TransacoesDAO(conn);
            List<Transacao> transacoes = dao.buscarTransacoesPorCPF(investidor.getCpf());
            StringBuilder extratoTexto = new StringBuilder();
            for (Transacao transacao : transacoes) {
                extratoTexto.append("ID: ").append(transacao.getIdTransacao())
                    .append(" | Data/Hora: ").append(transacao.getDataHora())
                    .append(" | Tipo: ").append(transacao.getTipo())
                    .append(" | Valor Total: R$ ").append(String.format("%.2f", transacao.getValorTotal()))
                    .append(" | Moeda: ").append(transacao.getMoeda())
                    .append(" | Cotação: ").append(transacao.getCotacao())
                    .append(" | Taxa: ").append(transacao.getTaxa())
                    .append(" | Saldo Real: R$ ").append(String.format("%.2f", transacao.getSaldoReal()))
                    .append(" | Saldo Bitcoin: ").append(transacao.getSaldoBitcoin())
                    .append(" | Saldo Ethereum: ").append(transacao.getSaldoEthereum())
                    .append(" | Saldo Ripple: ").append(transacao.getSaldoRipple())
                    .append("\n\n");
            }
            view.setAreaExtrato(extratoTexto.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar transações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
