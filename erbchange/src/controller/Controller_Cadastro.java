package controller;
/**
 *
 * @author rgara
 */

import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Cadastro_window;

public class Controller_Cadastro {
    private Cadastro_window view;
    public Controller_Cadastro(Cadastro_window view){
        this.view = view;
    }
    
    public void salvarInvestidor(){
        String nome = view.getInsert_nome_novo_usuario().getText();
        String cpf = view.getInsert_cpf_novo_usuario().getText();
        String senha = view.getInsert_senha_novo_usuario().getText();
        if (!senha.matches("\\d{6}")) {
            JOptionPane.showMessageDialog(view, "A senha deve conter exatamente 6 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Investidor investidor = new Investidor(nome, cpf, senha, null);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.inserir(investidor);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Falha na conexão!","Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}

