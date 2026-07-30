package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Lancamento;

import model.TipoLancamento;

import db.ConnectionFactory;

public class LancamentoDAO {
    private Connection connection;

    public LancamentoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Lancamento lancamento) {
        String sql = "INSERT INTO lancamentos (descricao, valor, data_lancamento, tipo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, lancamento.getDescricao());
            stmt.setDouble(2, lancamento.getValor());
            stmt.setDate(3, Date.valueOf(lancamento.getData()));
            stmt.setString(4, lancamento.getTipo().name());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar lançamento: " + e.getMessage());
        }
    }

    public List<Lancamento> listarTodos() {
        List<Lancamento> lancamentos = new ArrayList<>();
        String sql = "SELECT * FROM lancamentos";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Lancamento l = new Lancamento();
                l.setId(rs.getInt("id"));
                l.setDescricao(rs.getString("descricao"));
                l.setValor(rs.getDouble("valor"));
                l.setData(rs.getDate("data_lancamento").toLocalDate());
                l.setTipo(TipoLancamento.valueOf(rs.getString("tipo")));
                lancamentos.add(l);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar: " + e.getMessage());
        }
        return lancamentos;
    }
}