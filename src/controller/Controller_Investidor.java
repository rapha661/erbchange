package controller;
import DAO.Conexao;
import model.Investidor;
import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.investidor_window;

public class Controller_Investidor {
    private investidor_window view;
    private Investidor investidor;

    public Controller_Investidor(investidor_window view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    
//    public void atualizar(){
//        String cpf = view.getTxtLogin().getText();
//        String novaSenha = view.getTxtNovaSenha().getText();
//        Investidor investidor = new Investidor("", usuario, novaSenha);
//        Conexao conexao = new Conexao();
//        
//        try{
//                Connection conn = conexao.getConnection();
//                InvestidorDAO dao = new InvestidorDAO(conn);
//                dao.atualizar(investidor);
//                JOptionPane.showMessageDialog(view, "Senha de usuario atualizada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//        } catch(SQLException ex){
//            JOptionPane.showMessageDialog(view, "Falha de Conexão", "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
}
