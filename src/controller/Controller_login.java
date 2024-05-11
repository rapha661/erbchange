package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.login_window;
import view.investidor_window;

public class Controller_login {
    private login_window view;

    public Controller_login() {
    }

    public Controller_login (login_window view) {
        this.view = view;
    }

    public login_window getView() {
        return view;
    }

    public void setView(login_window view) {
        this.view = view;
    }
    
    public void Login_investidor(){
        Investidor investidor = new Investidor(null, view.getInsert_cpf_login().getText(),view.getInsert_senha_login().getText(), null);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login Feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                Integer carteira = res.getInt("carteira");
                investidor_window viewUsuario = new investidor_window(new Investidor(nome, cpf, senha, carteira));
                viewUsuario.setVisible(true);
                view.setVisible(false); 
            } else{
                JOptionPane.showMessageDialog(view, "Erro no login", "Erro", JOptionPane.ERROR_MESSAGE);
            } 
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}   

