import javax.naming.directory.InvalidAttributesException;

public class ContaCorrente extends Conta {

    private double limiteDeCredito;
    private double taxa = 0.03;
    private double tarifaFixa = 10.00;

    /**
     * Construtor da conta corrente.
     * */
    public ContaCorrente() {
        descricao = "Corrente";
        limiteDeCredito = 0;

    }

    /**
     * Metodo que atualiza o limite de credito da conta.
     * @param limite é o limite de crédito que será colocado.
     * */
    public void atualizarLimiteDeCredito(double limite) throws InvalidAttributesException {
        if (limite > 0) {
            limiteDeCredito = limite;
        } else {
            throw new InvalidAttributesException("Limite nao pode ser negativo!");
        }
    }


    @Override
    public void depositarDinheiro(double valor) {
        if (dinheiro >= 0) {
            dinheiro += valor;
            addMovimentacao(valor);
            atualizarSaldoNoMes(valor);
        } else {
            double valorADescontar = Math.abs(dinheiro) * (1 + taxa) + tarifaFixa;
            double valorADepositar = valor - valorADescontar;
            dinheiro = valorADepositar;
            addMovimentacao(valorADepositar);
            atualizarSaldoNoMes(valorADepositar);
        }
    }

    @Override
    public void sacarDinheiro(double valor) throws InvalidAttributesException {
        double valorPermitidoParaSaque = dinheiro + limiteDeCredito;

        if (valor > valorPermitidoParaSaque) {
            throw new InvalidAttributesException("Valor indisponível para saque. Excede o montade de saldo + limite de crédito");
        } else {
            dinheiro -= valor;
            addMovimentacao(-valor);
            atualizarSaldoNoMes(-valor);
        }
    }

}
