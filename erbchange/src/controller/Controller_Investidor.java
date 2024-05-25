package controller;
import model.Investidor;
import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import view.investidor_window;
import view.Alterar_window;

public class Controller_Investidor {
    private investidor_window view;
    private Investidor investidor;
    private Alterar_window view_alterar;

    public Controller_Investidor(investidor_window view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }

    
    public void atualizarCotacoes() {
        investidor.getCarteira().atualizarCotacoes();
        Map<String, Double> cotacoes = investidor.getCarteira().getCotacoes();
        StringBuilder cotacoesTexto = new StringBuilder();
        if (cotacoes.containsKey("real")) {
            cotacoesTexto.append("Real: ").append(String.format("%.2f", cotacoes.get("real"))).append("\n");
        }
        if (cotacoes.containsKey("bitcoin")) {
            cotacoesTexto.append("Bitcoin: ").append(String.format("%.2f", cotacoes.get("bitcoin"))).append("\n");
        }
        if (cotacoes.containsKey("ethereum")) {
            cotacoesTexto.append("Ethereum: ").append(String.format("%.2f", cotacoes.get("ethereum"))).append("\n");
        }
        if (cotacoes.containsKey("ripple")) {
            cotacoesTexto.append("Ripple: ").append(String.format("%.2f", cotacoes.get("ripple"))).append("\n");
        }
        view.getConsultaCotacao().setText(cotacoesTexto.toString());
    }

    
}
