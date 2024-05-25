package controller;

import DAO.CarteiraDAO;
import DAO.Conexao;
import model.Investidor;
import model.Moedas;
import model.Real;
import view.ComprarCrypto_window;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class Controller_ComprarCrypto {
    private Investidor investidor;
    private ComprarCrypto_window view;

    public Controller_ComprarCrypto(Investidor investidor, ComprarCrypto_window view) {
        this.investidor = investidor;
        this.view = view;
    }

    public void comprarCrypto(String tipoMoeda, double valorEmReais) {
        try (Connection conn = new Conexao().getConnection()) {
            CarteiraDAO dao = new CarteiraDAO(conn);
            int idCarteira = dao.buscarIdCarteiraPorCPF(investidor.getCpf());

            Moedas moeda = investidor.getCarteira().getMoedas().get(tipoMoeda);
            double taxaCompra = moeda.getTaxa_compra();
            double cotacaoAtual = moeda.getCotacao();
            double quantidadeComprada = (valorEmReais / (cotacaoAtual * (1 + taxaCompra)));

            Real real = (Real) investidor.getCarteira().getMoedas().get("real");
            double saldoAtual = real.getQuantidade_carteira();
            
            if (saldoAtual < valorEmReais) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente para realizar a compra.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Deduz o valor em reais do saldo atual
            real.setQuantidade_carteira(saldoAtual - valorEmReais);

            // Adiciona a quantidade comprada à carteira da moeda escolhida
            moeda.setQuantidade_carteira(moeda.getQuantidade_carteira() + quantidadeComprada);

            // Atualiza o saldo na base de dados
            dao.atualizarSaldoReal(idCarteira, real.getQuantidade_carteira());
            dao.atualizarSaldoMoeda(idCarteira, tipoMoeda, moeda.getQuantidade_carteira());

            JOptionPane.showMessageDialog(view, "Compra realizada com sucesso! Novo saldo: " + real.getQuantidade_carteira(), "Compra Concluída", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Por favor, insira um valor numérico válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão ou operação SQL: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage(), "Erro Geral", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualizarCotacoes() {
    try {
        
        Moedas bitcoin = (Moedas) investidor.getCarteira().getMoedas().get("bitcoin");
        Moedas ethereum = (Moedas) investidor.getCarteira().getMoedas().get("ethereum");
        Moedas ripple = (Moedas) investidor.getCarteira().getMoedas().get("ripple");
        
        StringBuilder cotacoesTexto = new StringBuilder();
        cotacoesTexto.append("Bitcoin: R$ ").append(String.format("%.2f", bitcoin.getCotacao())).append("\n");
        cotacoesTexto.append("Ethereum: R$ ").append(String.format("%.2f", ethereum.getCotacao())).append("\n");
        cotacoesTexto.append("Ripple: R$ ").append(String.format("%.2f", ripple.getCotacao())).append("\n");
        
        view.getAreaConsultarCotacaoCompra().setText(cotacoesTexto.toString());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(view, "Erro ao atualizar cotações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


}
