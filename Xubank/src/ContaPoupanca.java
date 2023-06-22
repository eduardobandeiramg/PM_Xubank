public class ContaPoupanca extends Conta implements IIncideJuros {
    private double juros = 0.006;

    /**
     * Construtor da classe.
     * */
    public ContaPoupanca() {

        descricao = "Poupança";

    }

    @Override
    public void depositarJurosCliente(double valorAIncidirJuros) {

        double rendimento = valorAIncidirJuros * juros;
        dinheiro += rendimento;
    }

}
