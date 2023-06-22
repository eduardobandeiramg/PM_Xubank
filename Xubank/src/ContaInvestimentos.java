import javax.naming.directory.InvalidAttributesException;

public class ContaInvestimentos extends Conta implements IIncideJuros, ICalcularImposto {
    private static final double JUROMIN = -0.0060, JUROMAX = 0.015;
    private double juros = 0.01;
    private static final double IMPOSTO = 0.225;
    private static final double TAXA_DE_CUSTODIA = 0.01;
    private double rendimento;

    /**
     * Construtor da classe.
     * */
    public ContaInvestimentos() {
        descricao = "Investimento";
    }

    //Metodo set
    public void setJuros(double juros) throws InvalidAttributesException {

        if(juros>= JUROMIN && juros<= JUROMAX){
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
        } else {
            throw new InvalidAttributesException("Não é possível sacar o valor solicitado (excede o valor total permitido para saque)");
        }
    }

    @Override
    public double calcularImpostos() {
        return rendimento * IMPOSTO;
    }

    @Override
    public void depositarJurosCliente(double valorAIncidirJuros) {

        rendimento = valorAIncidirJuros * juros;
        double parteDoBanco = (rendimento * TAXA_DE_CUSTODIA);
        dinheiro += (rendimento - parteDoBanco);

    }
}
