import javax.naming.directory.InvalidAttributesException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;


public class ContaCorrente extends Conta{

    private double limiteDeCredito;
    private double taxa = 0.03;
    private double tarifaFixa = 10.00;
    public static double valorEmCustodiaCorrente;
    private  Map <LocalDate , Double> saldoNoMes = new HashMap<>();



            static{
            valorEmCustodiaCorrente = 0;
        }

    ContaCorrente(Cliente cliente) {
        super(cliente);
        this.descricao = "Corrente";
        this.limiteDeCredito = 0;
    }

    //Metodos get
    private double getLimiteDeCredito(){
        return limiteDeCredito;
    }

    public void atualizarLimiteDeCredito(double limite) throws InvalidAttributesException {
        if(limite > 0) {
            limiteDeCredito = limite;
        }
        else{
            throw new InvalidAttributesException("Limite nao pode ser negativo!");
        }
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

    @Override
    public void sacarDinheiro(double valor) {
        LocalDate hoje = LocalDate.now();

        double dinheiroParaSacar = dinheiro + limiteDeCredito;

        double dinheiroSacado = (dinheiro) - valor;

        if(dinheiroSacado<0){
            throw new RuntimeException("Saldo Insuficinete!");
        }
        else{
            dinheiro -= dinheiroSacado;
            addMovimentacao(- valor);
            valorEmCustodiaCorrente -= valor;
            atualizarSaldoNoMes(- valor);
        }
    }

    @Override
    public void depositarDinheiro(double valor){
        double multiplicador = 1 + taxa;
        double valorADescontar = (dinheiro * -1) * multiplicador + tarifaFixa;
        if(dinheiro >= 0){
            dinheiro += valor;
        }
        else if (dinheiro < 0 && valor >= valorADescontar){
            dinheiro += (valor - valorADescontar);
        }
        else{
            dinheiro += valor;
        }
        addMovimentacao(valor);
        valorEmCustodiaCorrente += valor;
        atualizarSaldoNoMes(valor);

    }

    public static double getValorEmCustodia() {
        return valorEmCustodiaCorrente;
    }

}
