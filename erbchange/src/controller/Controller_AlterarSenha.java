package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Alterar_window;

public class Controller_AlterarSenha {
    private Alterar_window view;
    private Investidor investidor;

    public Controller_AlterarSenha(Alterar_window view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }

//    função para alterar a senha do usuário
    public void atualizarSenha() {
        String cpf = view.getInsertAlterar_cpf().getText();
        String novaSenha = view.getInsertAlterar_senhaNova().getText();
        if (!isValidSenha(novaSenha)) {
            JOptionPane.showMessageDialog(view, "A senha deve ter exatamente 6 dígitos numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection conn = new Conexao().getConnection()) {
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.atualizarSenha(cpf, novaSenha);
            this.investidor.setSenha(novaSenha);
            JOptionPane.showMessageDialog(view, "Senha do investidor atualizada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Falha de conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean isValidSenha(String senha) {
        return senha.matches("\\d{6}");
    }

}

