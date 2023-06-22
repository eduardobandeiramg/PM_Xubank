import javax.naming.directory.InvalidAttributesException;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class ContaInvestimentos extends Conta implements IIncideJuros, ICalcularImposto {
    private Map<LocalDate, Double> saldoNoMes = new HashMap<>();
    private double juromin = -0.0060, juromax = 0.015;
    private double juros = 0.01;
    private double imposto = 0.225;
    double taxaDeCustodia = 0.01;
    double rendimento;

    /**
     * Construtor da classe.
     * */
    public ContaInvestimentos() {
        descricao = "Investimento";
    }

    //Metodo set
    public void setJuros(double juros) throws InvalidAttributesException {

        if(juros>= juromin && juros<= juromax){
            this.juros = juros;
        }else {
            throw new InvalidAttributesException("Valor do juros invalido!");
        }
    }

    /**
     * Método de sacar dinheiro que realiza uma retirada da conta levando em consideração as regras de incidência de imposto sobre os rrendimentos
     */
    public void sacarDinheiro(double valor) throws InvalidAttributesException {
        double valorEmConta = getDinheiro();
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
            throw new InvalidAttributesException("Não é possível sacar o valor solicitado (excede o valor total permitido para saque)");
        }
    }

    @Override
    public double calcularImpostos() {
        return rendimento * imposto;
    }

    @Override
    public void depositarJurosCliente(double valorAIncidirJuros) {

        rendimento = valorAIncidirJuros * juros;
        double parteDoBanco = (rendimento * taxaDeCustodia);
        dinheiro += (rendimento - parteDoBanco);

    }
}
