import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;

public class ContaInvestimentos extends Conta implements IIncideJuros{
        public static double valorEmCustodiaInvestimentos;
        private  Map <LocalDate , Double> saldoNoMes = new HashMap<>();
        private double juromin = -0.60 , juromax = 1.5;
        private double imposto = 0.225;
        double taxaMensal = 0;


                static{
            valorEmCustodiaInvestimentos = 0;
        }

    public ContaInvestimentos(Cliente cliente) {
        super(cliente);
        this.descricao = "Investimento";
    }

    public ContaInvestimentos(){
        
    }

        public void atualizarSaldoNoMes(Double valor){
        //atuaiza o saldo para a chave do mês em questão
        if(saldoNoMes.containsKey(LocalDate.now())){
            double saldoAnterior = saldoNoMes.get(LocalDate.now());
            Double novoValor = saldoAnterior - valor;
            saldoNoMes.put(LocalDate.now() , novoValor);
        }
        else{
            saldoNoMes.put(LocalDate.now() , valor);
        }

    }

        public void depositarDinheiro(double valor){
        if(valor > 0){
                    dinheiro += valor;
                    addMovimentacao(valor);
                    valorEmCustodiaInvestimentos += valorEmCustodiaInvestimentos;
                    atualizarSaldoNoMes(valor);
        }
        else{
            System.out.println("Não é possível depositar valores menores ou iguais a zero");
        }
    }

        public void sacarDinheiro(double valor){
        double multiplicador = 1 + imposto;
        double dinheiroSacado = dinheiro - multiplicador*(calculaJuros() + taxaMensal) - valor;

        if(dinheiroSacado<0){
            throw new RuntimeException("Saldo Insuficinete!");
        }
        else{
            dinheiro = dinheiroSacado;
            addMovimentacao(- valor);
            valorEmCustodiaInvestimentos -= valorEmCustodiaInvestimentos;
            atualizarSaldoNoMes( - valor);
        }

    }

           @Override
    public double calculaJuros() {
        Random random = new Random();
        double juros;
        double adicionar = 0;
        LocalDate primeira , proxima , atual , ultima;
        if(!saldoNoMes.isEmpty()){
            Set<LocalDate> chaves = saldoNoMes.keySet();
            primeira = chaves.iterator().next();
            atual = primeira;
            Period periodo = primeira.until(LocalDate.now());
            long meses = periodo.toTotalMonths();
            proxima = primeira.plusMonths(1);
            for (int i = 0 ; i < meses ; i ++){
                juros = juromin + (juromax - juromin) * random.nextDouble();
                double multiplicador = 1 + juros;
                double diferenca = saldoNoMes.get(proxima) - saldoNoMes.get(atual);
                if(diferenca > 0){
                    adicionar += diferenca * multiplicador;
                }
                if(juros > 0){
                    taxaMensal += adicionar * 0.01;
                }
                else{
                    taxaMensal += 0;
                }
                proxima = proxima.plusMonths(1);
                atual = proxima.plusMonths(1);
            }
            return adicionar - taxaMensal;
        }
        else{
            throw new NullPointerException("Saldo : R$0.00");
        }
    }

    public double getDinheiro(){
        return dinheiro + calculaJuros();
    }

    
        public static double getValorEmCustodia() {
        return valorEmCustodiaInvestimentos;
    }

}
