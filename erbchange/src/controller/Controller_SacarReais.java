package controller;

import DAO.CarteiraDAO;
import DAO.Conexao;
import model.Investidor;
import model.Real;
import view.SacarReais_window;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class Controller_SacarReais {
    private Investidor investidor;
    private SacarReais_window view;

    public Controller_SacarReais(Investidor investidor, SacarReais_window view) {
        this.investidor = investidor;
        this.view = view;
    }

    public void realizarSaque(String valorTexto) {
    try (Connection conn = new Conexao().getConnection()) {
        double valor = Double.parseDouble(valorTexto);
        if (valor <= 0) {
            JOptionPane.showMessageDialog(view, "O valor deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Acesso ao objeto Real dentro da carteira do investidor e tentativa de saque do valor
        Real real = (Real) investidor.getCarteira().getMoedas().get("real");
        if (real.consultarSaldo() < valor) {
            JOptionPane.showMessageDialog(view, "Saldo insuficiente para realizar o saque.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        real.sacar(valor);

        // Atualiza o saldo na base de dados
        CarteiraDAO dao = new CarteiraDAO(conn);
        int idCarteira = dao.buscarIdCarteiraPorCPF(investidor.getCpf());
        dao.atualizarSaldoReal(idCarteira, real.consultarSaldo());

        // Atualizar a exibição do saldo após o saque
        view.setAreaSaldoPosSaque("Saldo após saque em Reais: R$ " + String.format("%.2f", real.consultarSaldo()));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(view, "Por favor, insira um valor numérico válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro de conexão ou operação SQL: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage(), "Erro Geral", JOptionPane.ERROR_MESSAGE);
    }
    }

}
