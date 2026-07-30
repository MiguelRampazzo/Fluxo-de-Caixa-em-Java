import model.Lancamento;
import model.TipoLancamento;
import service.LancamentoService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LancamentoService service = new LancamentoService();
        int opcao = 0;

        System.out.println("=== SISTEMA DE FLUXO DE CAIXA ===");

        do {
            System.out.println("\n1. Registrar Receita");
            System.out.println("2. Registrar Despesa");
            System.out.println("3. Ver Extrato e Saldo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                case 2:
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    System.out.print("Valor: ");
                    Double valor = scanner.nextDouble();

                    TipoLancamento tipo = (opcao == 1) ? TipoLancamento.RECEITA : TipoLancamento.DESPESA;

                    Lancamento novo = new Lancamento(desc, valor, LocalDate.now(), tipo);
                    service.registrarLancamento(novo);
                    break;

                case 3:
                    System.out.println("\n--- EXTRATO DETALHADO ---");
                    service.exibirExtrato();
                    break;

                case 4:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}