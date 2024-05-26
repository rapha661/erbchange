package controller;

import DAO.Conexao;
import DAO.TransacoesDAO;
import model.Investidor;
import model.Transacao;
import view.Extrato_window;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.List;


public class Controller_Extrato {
    private Investidor investidor;
    private Extrato_window view;

    public Controller_Extrato(Investidor investidor, Extrato_window view) {
        this.investidor = investidor;
        this.view = view;
    }

    public void buscarExtrato() {
        try (Connection conn = new Conexao().getConnection()) {
            TransacoesDAO dao = new TransacoesDAO(conn);
            List<Transacao> transacoes = dao.consultarExtrato(investidor.getCpf());
            String extratoFormatado = formatarExtrato(transacoes);
            view.setAreaExtrato(extratoFormatado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar extrato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String formatarExtrato(List<Transacao> transacoes) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                                "Data/Hora", "Tipo", "Valor Total", "Moeda", "Cotação", "Taxa",
                                "Saldo Real        ", "BTC", "ETH", "XRP"));
        for (Transacao transacao : transacoes) {
            sb.append(String.format("%-20s %-15s %-10.2f %-10s %-10.8f %-10.2f %-10.2f %-10.8f %-10.8f %-10.8f\n",
                                    transacao.getDataHora().toString(),
                                    transacao.getTipo(),
                                    transacao.getValorTotal(),
                                    transacao.getMoeda(),
                                    transacao.getCotacao(),
                                    transacao.getTaxa(),
                                    transacao.getSaldoReal(),
                                    transacao.getSaldoBitcoin(),
                                    transacao.getSaldoEthereum(),
                                    transacao.getSaldoRipple()));
        }
        return sb.toString();
    }
}
