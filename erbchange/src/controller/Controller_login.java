package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;
import DAO.CarteiraDAO;
import view.login_window;
import view.investidor_window;

public class Controller_login {
    private login_window view;

    public Controller_login(login_window view) {
        this.view = view;
    }

    public login_window getView() {
        return view;
    }

    public void setView(login_window view) {
        this.view = view;
    }
    
    public void Login_investidor() {
    String cpf = view.getInsert_cpf_login().getText();
    String senha = view.getInsert_senha_login().getText();
    
    if (cpf.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(view, "CPF e senha são necessários.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Investidor investidor = new Investidor(null, cpf, senha, null); 
    try (Connection conn = new Conexao().getConnection()) {
        InvestidorDAO dao = new InvestidorDAO(conn);
        CarteiraDAO daocar = new CarteiraDAO(conn);
        try (ResultSet res = dao.consultar(investidor)) {
            if (res != null && res.next()) {
                String nome = res.getString("nome");
                Carteira carteira = daocar.buscarCarteira(res.getInt("carteira"));
                Investidor investidorCompleto = new Investidor(nome, cpf, senha, carteira);
                JOptionPane.showMessageDialog(view, "Login Feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                investidor_window viewUsuario = new investidor_window(investidorCompleto);
                viewUsuario.setVisible(true);
                view.dispose(); 
            } else {
                JOptionPane.showMessageDialog(view, "Erro no login", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

}   
