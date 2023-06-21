import java.util.Random;
import java.util.Set;
import java.time.LocalDate;
import java.time.Period;

public class ContaRendaFixa extends Conta implements IIncideJuros, ICalcularImposto , ITaxaDeCustodia {
    private double juromin = 0.5, juromax = 0.85;
    private double imposto = 0.15;
    private double taxaDeCustodia = 20;

    public ContaRendaFixa() {

    }

    /*
     * Método que será chamado quando for solicitado o valor do saldo total da conta
     * (para verificar situação e para fazer saques).
     * Este método verifica o histórico de saldos da conta, começando a partir da
     * primeira movimentação.
     * A partir desta primeira data, a conta terá "aniversários" a cada mês.
     * O juros da renda fixa serão aplicados sobre o valor disponível na conta na
     * data de aniversário a após 1 mês, desde que o saldo em conta não
     * caia abaixo desse valor inicial dentro desse intervalo de tempo.
     * 
     * A diferença de implementação deste método está no valor dos juros que serão
     * aplicados, sendo este variando a cada mês dentro
     * de um intervalo de juro mínimo e juro máximo.
     * O valor dos juros para cada mês são salvos dentro de uma classe enumeradora
     * do histórico de juros para cada tipo de conta onde
     * os juros variam
     */
    @Override
    public double calculaJuros() {
        Random random = new Random();
        double juros;
        double adicionar = 0;
        LocalDate primeira, proxima, atual;
        if (!saldoNoMes.isEmpty()) {
            Set<LocalDate> chaves = saldoNoMes.keySet();
            primeira = chaves.iterator().next();
            atual = primeira;
            Period periodo = primeira.until(LocalDate.now());
            long meses = periodo.toTotalMonths();
            proxima = primeira.plusMonths(1);
            for (int i = 0; i < meses; i++) {
                juros = juromin + (juromax - juromin) * random.nextDouble();
                double multiplicador = 1 + juros;
                double diferenca = saldoNoMes.get(proxima) - saldoNoMes.get(atual);
                if (diferenca > 0) {
                    adicionar += diferenca * multiplicador;
                } else {
                    adicionar += 0;
                }
                proxima = proxima.plusMonths(1);
                atual = proxima.plusMonths(1);
            }
            return adicionar;
        } else {
            throw new NullPointerException("Saldo : R$0.00");
        }
    }

    // Método que implementa a interface de calcular imposto, de acordo com o valor
    // do imposto da conta.
    @Override
    public double calcularImpostos() {
        return calculaJuros() * (1 + imposto);
    }

    /*
     * Método que calcula o valor da taxa de custódia total incidente sobre o
     * cliente
     * Este método buscará o registro da primeira data de movimentação da conta,
     * contará quantos meses se passaram até o momento atual e
     * retornará o valor total de custódia incidente sobre o cliente
     */
    public double calcularTaxaDeCustodia() {
        LocalDate primeira;
        if (!saldoNoMes.isEmpty()) {
            Set<LocalDate> chaves = saldoNoMes.keySet();
            primeira = chaves.iterator().next();
            Period periodo = primeira.until(LocalDate.now());
            long meses = periodo.toTotalMonths();

            return meses * taxaDeCustodia;
        } else {
            throw new NullPointerException("Saldo : R$0.00");
        }
    }

    /*
     * Método que realiza o saque da conta de renda fixa, levando em consideração o
     * desconto aplicado no momento do saque.
     */
    public void sacarDinheiro(double valor) {
        double valorEmConta = getDinheiro();
        double valorMaximoParaSaque = valorEmConta - calcularImpostos();
        double valorASacar = valor + calcularImpostos();
        if (valor <= valorMaximoParaSaque) {
            dinheiro -= valorASacar;
            addMovimentacao(-valorASacar);
            atualizarSaldoNoMes(-valorASacar);
        } else {
            System.out.println("Não é possível sacar o valor solicitado (excede o valor total permitido para saque)");
        }
    }

    /*
     * Método que retorna o saldo disponível do cliente, levando em conta a
     * aplicação de juros e a incidência da taxa de custódia
     */
    public double getDinheiro() {
        return dinheiro + calculaJuros() - calcularTaxaDeCustodia();
    }
}
