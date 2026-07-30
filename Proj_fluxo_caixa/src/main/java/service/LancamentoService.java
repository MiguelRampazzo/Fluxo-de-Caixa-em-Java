package service;
import model.Lancamento;
import dao.LancamentoDAO;
import model.TipoLancamento;

public class LancamentoService {
    private LancamentoDAO dao = new LancamentoDAO();

    public void registrarLancamento(Lancamento l) {
        if (l.getValor() > 0) {
            dao.salvar(l);
            System.out.println("Salvo no banco com sucesso!");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void exibirExtrato() {
        double saldo = 0;
        for (Lancamento l : dao.listarTodos()) {
            System.out.println(l.getDescricao() + " | R$ " + l.getValor() + " | " + l.getTipo());
            if (l.getTipo() == TipoLancamento.RECEITA) saldo += l.getValor();
            else saldo -= l.getValor();
        }
        System.out.println("-------------------------");
        System.out.println("Saldo Total: R$ " + saldo);
    }
}