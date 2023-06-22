public class ContaPoupanca extends Conta implements IIncideJuros {
    private static final double JUROS = 0.006;

    /**
     * Construtor da classe.
     * */
    public ContaPoupanca() {

        descricao = "Poupança";

    }

    @Override
    public void depositarJurosCliente(double valorAIncidirJuros) {

        double rendimento = valorAIncidirJuros * JUROS;
        dinheiro += rendimento;
    }

}
