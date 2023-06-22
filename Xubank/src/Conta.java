import javax.naming.directory.InvalidAttributesException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public abstract class Conta {

    protected String descricao;
    protected double dinheiro;
    protected Map<LocalDate, List<Double>> movimentacoes;
    protected Map<LocalDate, Double> saldoNoMes = new HashMap<>();
    protected int id;
    protected static int id_proximo = 1;

    /**
     * Construtor da classe conta
     * */
    public Conta() {
        descricao = null;
        dinheiro = 0;
        movimentacoes = new HashMap<>();
        id = id_proximo;
        id_proximo++;
    }

    // Metodos Set
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Metodos get
    public String getDescricao() {
        return descricao;
    }
    public double getDinheiro() {
        return dinheiro;
    }

    /**
     * Método que é chamado em toda movimentação da conta para salvar essa movimentação,
     * que é vinculada a uma data para adicionar ao extrato da conta.
     */
    public void addMovimentacao(Double valor) {

        if (movimentacoes.containsKey(LocalDate.now())) {
            List<Double> valores = movimentacoes.get(LocalDate.now());
            valores.add(valor);
        } else {
            List<Double> valores = new ArrayList<>();
            valores.add(valor);
            movimentacoes.put(LocalDate.now(), valores);
        }

    }

    /**
     * Método que apresenta o saldo atual da conta
     * */
    public void puxarSituacao() {
        // Mostra a situação atual para o dia de hoje
        LocalDate hoje = LocalDate.now();
        System.out.println("Situação atual para o dia " + hoje + ": ");
        System.out.println("Saldo em conta: " + dinheiro);
    }

    /**
     * Método que mostra o extrato da conta (histório de movimentações
     * dos útllimos 30 dias. depósitos são mostrados como valores positivos e saques
     * são mostrados como os valores negativos)
     */
    public void puxarExtrato() {
        // Mostra o histórico de movimentações nos últimos 30 dias
        LocalDate hoje = LocalDate.now();
        LocalDate inicio = hoje.minusMonths(1);

        while (inicio != hoje.plusDays(1)) {
            if (movimentacoes.containsKey(inicio)) {
                System.out.println("Movimentações no dia " + inicio + ": " + movimentacoes.get(inicio));
                break;
            }
            inicio = inicio.plusDays(1);
        }
    }

    /**
     * Metodo de deposito de dinheiro na conta.
     * @param valor é o valor que será despositado na conta.
     * */
    public void depositarDinheiro(double valor) throws InvalidAttributesException {
        if (valor > 0) {
            dinheiro += valor;
            addMovimentacao(valor);
            atualizarSaldoNoMes(valor);
        } else {
            throw new InvalidAttributesException("Não é possível depositar valores menores ou iguais a zero");
        }
    }

    /**
     * Metodo de sacar dinheiro da conta, esse metodo faz as validações necessárias
     * para não sacar algum valor indevido.
     *
     * @param valor é o valor que será sacado da conta.
     * @throws RuntimeException joga uma exceção caso o dinheiro que será sacado
     * é maior que o dinheiro na conta.
     * */
    public void sacarDinheiro(double valor) throws InvalidAttributesException {
        double dinheiroSacado = getDinheiro() - valor;
        if (dinheiroSacado < 0) {
            throw new InvalidAttributesException("Saldo Insuficiente!");
        } else {
            dinheiro = dinheiroSacado;
            addMovimentacao(-valor);
            atualizarSaldoNoMes(-valor);
        }
    }

    /**
     * Metodo que atualizao saldo para a chave do mês em questão.
     * @param valor é o valor da movimentação.
     * */
    public void atualizarSaldoNoMes(Double valor) {
        if (saldoNoMes.containsKey(LocalDate.now())) {
            double saldoAnterior = saldoNoMes.get(LocalDate.now());
            Double novoValor = saldoAnterior - valor;
            saldoNoMes.put(LocalDate.now(), novoValor);
        } else {
            saldoNoMes.put(LocalDate.now(), valor);
        }

    }
}