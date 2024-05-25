package controller;

import DAO.CarteiraDAO;
import DAO.Conexao;
import model.Investidor;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import model.Real;
import model.Bitcoin;
import model.Ethereum;
import model.Moedas;
import model.Ripple;
import view.VenderCrypto_window;

public class Controller_VendaCrypto {
    private Investidor investidor;
    private VenderCrypto_window view;

    public Controller_VendaCrypto(Investidor investidor, VenderCrypto_window view) {
        this.investidor = investidor;
        this.view = view;
    }

    public void Cotacoes() {
        try {

            Moedas bitcoin = (Moedas) investidor.getCarteira().getMoedas().get("bitcoin");
            Moedas ethereum = (Moedas) investidor.getCarteira().getMoedas().get("ethereum");
            Moedas ripple = (Moedas) investidor.getCarteira().getMoedas().get("ripple");

            StringBuilder cotacoesTexto = new StringBuilder();
            cotacoesTexto.append("Bitcoin: R$ ").append(String.format("%.2f", bitcoin.getCotacao())).append("\n");
            cotacoesTexto.append("Ethereum: R$ ").append(String.format("%.2f", ethereum.getCotacao())).append("\n");
            cotacoesTexto.append("Ripple: R$ ").append(String.format("%.2f", ripple.getCotacao())).append("\n");

            view.getAreaConsultarCotacaoVenda().setText(cotacoesTexto.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar cotações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void venderCrypto(String moeda, double valorReais) {
        try (Connection conn = new Conexao().getConnection()) {
            Real real = (Real) investidor.getCarteira().getMoedas().get("real");
            double valorCrypto = valorReais / (investidor.getCarteira().getMoedas().get(moeda).getCotacao() * (1 - investidor.getCarteira().getMoedas().get(moeda).getTaxa_venda()));

            if (valorCrypto <= 0 || valorCrypto > investidor.getCarteira().getMoedas().get(moeda).getQuantidade_carteira()) {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente para venda.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            investidor.getCarteira().getMoedas().get(moeda).setQuantidade_carteira(investidor.getCarteira().getMoedas().get(moeda).getQuantidade_carteira() - valorCrypto);
            real.depositar(valorReais);

            // Atualiza o saldo na base de dados
            CarteiraDAO dao = new CarteiraDAO(conn);
            int idCarteira = dao.buscarIdCarteiraPorCPF(investidor.getCpf());
            dao.atualizarSaldoReal(idCarteira, real.consultarSaldo());
            dao.atualizarSaldoMoeda(idCarteira, moeda, investidor.getCarteira().getMoedas().get(moeda).getQuantidade_carteira());

            JOptionPane.showMessageDialog(view, "Venda realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão ou operação SQL: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage(), "Erro Geral", JOptionPane.ERROR_MESSAGE);
        }
    }
}
