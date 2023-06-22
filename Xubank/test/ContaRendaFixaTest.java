import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributesException;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ContaRendaFixaTest {

    Conta conta;
    ContaRendaFixa contaRendaFixa;

    FactoryConta factoryConta = new FactoryConta();

    /**
     * Metodo que inicia o a fabrica de conta e cria uma conta corrente.
     * */
    @BeforeEach
    public void init() {

        conta = factoryConta.criarObjeto("Renda Fixa");
        contaRendaFixa = (ContaRendaFixa) conta;

    }

    /**
     * Metodo que verifica a criacao da conta.
     * */
    @Test
    public void verificarACriacaoDaConta() {

        assertEquals("Renda fixa", contaRendaFixa.getDescricao());

    }

    /**
     * Metodo que testa o deposito de dinheiro na conta.
     * */
    @Test
    public void depositarDinheiroNaConta() throws InvalidAttributesException {

        contaRendaFixa.depositarDinheiro(200);
        assertEquals(200, contaRendaFixa.getDinheiro());

    }

    /**
     * Metodo de saque do dinheiro da conta.
     * */
    @Test
    public void sacarDinheiroDaConta() throws InvalidAttributesException {

        contaRendaFixa.depositarDinheiro(200);
        contaRendaFixa.sacarDinheiro(100);

        assertEquals(100, contaRendaFixa.getDinheiro());

    }

    /**
     * Esse teste é feito com o juros padrão, que é a média do intervalo.
     * */
    @Test
    public void testeDeCalcularOJurosPadrao() throws InvalidAttributesException {

        contaRendaFixa.depositarDinheiro(200);
        contaRendaFixa.depositarJurosCliente(100);

        assertEquals(200.675, contaRendaFixa.getDinheiro());

    }

    /**
     * Esse teste é feito com o juros que o banco define antes.
     * */
    @Test
    public void testeDeCalcularOJurosEspecifico() throws InvalidAttributesException {

        contaRendaFixa.depositarDinheiro(200);
        contaRendaFixa.setJuros(0.0055);
        contaRendaFixa.depositarJurosCliente(100);

        assertEquals(200.55, contaRendaFixa.getDinheiro());

    }

    /**
     * Metodo que testa o saque calculando o imposto sobre o rendimento.
     * */
    @Test
    public void testeSacarComImposto() throws InvalidAttributesException {

        contaRendaFixa.depositarDinheiro(100000);
        contaRendaFixa.depositarJurosCliente(40000);
        contaRendaFixa.sacarDinheiro(80000);

        assertEquals(20229.50, contaRendaFixa.getDinheiro());
    }

    /**
     * Metodo que testa a cobraanca da taxa de custodia.
     * */
    @Test
    public void testeCobrancaTaxaDeCustodia() throws InvalidAttributesException {

        contaRendaFixa.depositarDinheiro(200);
        contaRendaFixa.cobrarTaxaDoCliente();

        assertEquals(180, contaRendaFixa.getDinheiro());

    }

}
