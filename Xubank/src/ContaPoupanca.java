import java.util.Set;
import java.time.LocalDate;
import java.time.Period;

public class ContaPoupanca extends Conta implements IIncideJuros {
    private double juros = 0.006;
    public static double jurosEmCustodia;

    public ContaPoupanca() {

    }

    /*
     * Método que será chamado quando for solicitado o valor do saldo total da conta
     * (para verificar situação e para fazer saques).
     * Este método verifica o histórico de saldos da conta, começando a partir da
     * primeira movimentação.
     * A partir desta primeira data, a conta terá "aniversários" a cada mês.
     * O juros da poupança serão aplicados sobre o valor disponível na conta na data
     * de aniversário a após 1 mês, desde que o saldo em conta não
     * caia abaixo desse valor inicial dentro desse intervalo de tempo.
     */
    @Override
    public double calculaJuros() {
        double multiplicador = 1 + juros;
        double diferenca = 0, adicionar = 0;
        LocalDate primeira, proxima, atual;
        if (!saldoNoMes.isEmpty()) {
            Set<LocalDate> chaves = saldoNoMes.keySet();
            primeira = chaves.iterator().next();
            atual = primeira;
            Period periodo = primeira.until(LocalDate.now());
            long meses = periodo.toTotalMonths();
            proxima = primeira.plusMonths(1);
            for (int i = 0; i < meses; i++) {
                diferenca = saldoNoMes.get(proxima) - saldoNoMes.get(atual);
                if (diferenca > 0) {
                    adicionar += diferenca * multiplicador;
                }
                proxima = proxima.plusMonths(1);
                atual = proxima.plusMonths(1);
            }
            return adicionar;
        } else {
            throw new NullPointerException("Saldo : R$0.00");
        }
    }

    public double getDinheiro() {
        return dinheiro + calculaJuros();
    }
}
