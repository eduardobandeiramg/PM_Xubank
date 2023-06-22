import javax.naming.directory.InvalidAttributesException;

public class ContaRendaFixa extends Conta implements IIncideJuros, ICalcularImposto {
    private double juromin = 0.005, juromax = 0.0085;
    private double juros = 0.00675; //Juros padrao é a media, caso o novo juros nao seja setado pelo banco.
    private double imposto = 0.15;
    private static final double TAXA_DE_CUSTODIA = 20;
    double rendimento;

    /**
     * Construtor da classe.
     * */
    public ContaRendaFixa() {
        descricao = "Renda fixa";
    }

    //Metodo set
    public void setJuros(double juros) throws InvalidAttributesException {

        if(juros>= juromin && juros<= juromax){
            this.juros = juros;
        }else {
            throw new InvalidAttributesException("Valor do juros invalido!");
        }

    }

    @Override
    public void depositarJurosCliente(double valorAIncidirJuros) {

        rendimento = valorAIncidirJuros * juros;
        dinheiro += rendimento;

    }

    /**
     * Método que implementa a interface de calcular imposto, de acordo com o valor
     * do imposto da conta.
     **/
    @Override
    public double calcularImpostos() {
        return rendimento * imposto;
    }

    /**
     * Metodo que cobra a taxa mensal.
     * */
    public void cobrarTaxaDoCliente() {

        dinheiro-=TAXA_DE_CUSTODIA;

    }

    /**
     * Método que realiza o saque da conta de renda fixa, levando em consideração o
     * desconto aplicado no momento do saque.
     */
    public void sacarDinheiro(double valor) throws InvalidAttributesException {
        double valorEmConta = getDinheiro();
        double valorMaximoParaSaque = valorEmConta - calcularImpostos();
        double valorASacar = valor + calcularImpostos();
        if (valorASacar <= valorMaximoParaSaque) {
            dinheiro -= valorASacar;
            addMovimentacao(-valorASacar);
            atualizarSaldoNoMes(-valorASacar);
        } else {
            throw new InvalidAttributesException("Não é possível sacar o valor solicitado (excede o valor total permitido para saque)");
        }
    }

    /**
     * Método que retorna o saldo disponível do cliente, levando em conta a
     * aplicação de juros e a incidência da taxa de custódia
     */
    public double getDinheiro() {
        return dinheiro;
    }
}
