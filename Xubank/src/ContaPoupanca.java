import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;

public class ContaPoupanca extends Conta implements IIncideJuros{
        private double juros = 0.006;
        public static double jurosEmCustodia;
        
    public ContaPoupanca(){

    }
    @Override
    public double calculaJuros() {
        double multiplicador = 1 + juros;
        double diferenca = 0 , adicionar = 0;
        LocalDate primeira , proxima , atual , ultima;
        if(!saldoNoMes.isEmpty()){
            Set<LocalDate> chaves = saldoNoMes.keySet();
            primeira = chaves.iterator().next();
            atual = primeira;
            Period periodo = primeira.until(LocalDate.now());
            long meses = periodo.toTotalMonths();
            proxima = primeira.plusMonths(1);
            for (int i = 0 ; i < meses ; i ++){
                diferenca = saldoNoMes.get(proxima) - saldoNoMes.get(atual);
                if(diferenca > 0){
                    adicionar += diferenca * multiplicador;
                }
                proxima = proxima.plusMonths(1);
                atual = proxima.plusMonths(1);
            }
            return adicionar;
        }
        else{
            throw new NullPointerException("Saldo : R$0.00");
        }
    }

    public double getDinheiro(){
        return dinheiro + calculaJuros();
    }
}
