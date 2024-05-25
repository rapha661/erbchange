package controller;

import DAO.CarteiraDAO;
import DAO.Conexao;
import model.Carteira;
import model.Investidor;
import view.ConsultarSaldo_window;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Controller_ConsultarSaldo {
    private ConsultarSaldo_window view;
    private Investidor investidor;

    public Controller_ConsultarSaldo(ConsultarSaldo_window view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }

    public void consultarSaldo(String senha) {
        if (!senha.equals(investidor.getSenha())) {
            JOptionPane.showMessageDialog(view, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Carteira carteira = investidor.getCarteira();  // Assumindo que o Investidor já possui uma Carteira instanciada
        if (carteira != null) {
            String saldo = "Nome: " + investidor.getNome() + "\n" +
                           "CPF: " + investidor.getCpf() + "\n\n" +
                           "Saldo em Reais: " + String.format("%.2f", carteira.getMoedas().get("real").getQuantidade_carteira()) + "\n" +
                           "Saldo em Bitcoin: " + String.format("%.5f", carteira.getMoedas().get("bitcoin").getQuantidade_carteira()) + "\n" +
                           "Saldo em Ethereum: " + String.format("%.5f", carteira.getMoedas().get("ethereum").getQuantidade_carteira()) + "\n" +
                           "Saldo em Ripple: " + String.format("%.5f", carteira.getMoedas().get("ripple").getQuantidade_carteira());
            view.getAreaConsulta().setText(saldo);
        } else {
            JOptionPane.showMessageDialog(view, "Carteira não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }   
}
