package controller;

import DAO.CarteiraDAO;
import DAO.Conexao;
import model.Investidor;
import model.Real;
import view.DepositarReais_window;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class Controller_MovimentoReais {
    private Investidor investidor;
    private DepositarReais_window view;

    public Controller_MovimentoReais(Investidor investidor, DepositarReais_window view) {
        this.investidor = investidor;
        this.view = view;
    }

    public void realizarDeposito(String valorTexto) {
        try (Connection conn = new Conexao().getConnection()) {
            double valor = Double.parseDouble(valorTexto);
            if (valor <= 0) {
                JOptionPane.showMessageDialog(view, "O valor deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Acesso ao objeto Real dentro da carteira do investidor e depósito do valor
            Real real = (Real) investidor.getCarteira().getMoedas().get("real");
            real.depositar(valor);

            // Atualiza o saldo na base de dados
            CarteiraDAO dao = new CarteiraDAO(conn);
            int idCarteira = dao.buscarIdCarteiraPorCPF(investidor.getCpf());
            dao.atualizarSaldoReal(idCarteira, real.consultarSaldo());

            // Atualizar a exibição do saldo após o depósito
            view.setAreaSaldoPosDeposito("Novo saldo em Reais: R$ " + String.format("%.2f", real.consultarSaldo()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Por favor, insira um valor numérico válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão ou operação SQL: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage(), "Erro Geral", JOptionPane.ERROR_MESSAGE);
        }
    }
}
