import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;

public class ContaInvestimentos extends Conta implements IIncideJuros, ICalcularImposto , ITaxaDeCustodia {
    private Map<LocalDate, Double> saldoNoMes = new HashMap<>();
    private double juromin = -0.60, juromax = 1.5;
    private double imposto = 0.225;
    double taxaDeCustodia = 0.01;

    public ContaInvestimentos() {
        descricao = "Investimento";

    }

    /*
     * Método de sacar dinheiro que realiza uma retirada da conta levando em consideração as regras de incidência de imposto sobre os rrendimentos
     */
    public void sacarDinheiro(double valor) {
        double valorEmConta = getDinheiro();
        double rendimento = calculaJuros();
        double valorMaximoParaSaque;
        double valorASacar;
        if(rendimento <= 0){
            valorMaximoParaSaque = valorEmConta;
            valorASacar = valor;
        }
        else{
            valorMaximoParaSaque = valorEmConta - calcularImpostos();
            valorASacar = valor + calcularImpostos();
        }
        if (valor <= valorMaximoParaSaque) {
            dinheiro -= valorASacar;
            addMovimentacao(-valorASacar);
            atualizarSaldoNoMes(-valorASacar);
        } else {
            System.out.println("Não é possível sacar o valor solicitado (excede o valor total permitido para saque)");
        }
    }

    @Override
    public double calculaJuros() {
        Random random = new Random();
        double juros;
        double adicionar = 0;
        LocalDate primeira, proxima, atual, ultima;
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
                }
                if (juros > 0) {
                    taxaMensal += adicionar * 0.01;
                } else {
                    taxaMensal += 0;
                }
                proxima = proxima.plusMonths(1);
                atual = proxima.plusMonths(1);
            }
            return adicionar - taxaMensal;
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

    @Override
    public double calcularTaxaDeCustodia(){

    }

    public double getDinheiro() {
        return dinheiro + calculaJuros() - calcularTaxaDeCustodia();
    }
}
