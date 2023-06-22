import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributesException;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ContaPoupandaTest {

    Conta conta;
    ContaPoupanca contaPoupanca;

    FactoryConta factoryConta = new FactoryConta();

    /**
     * Metodo que inicia o a fabrica de conta e cria uma conta corrente.
     * */
    @BeforeEach
    public void init() {

        conta = factoryConta.criarObjeto("Poupanca");
        contaPoupanca = (ContaPoupanca)conta;

    }

    /**
     * Metodo que verifica a criacao da conta.
     * */
    @Test
    public void verificarACriacaoDaConta() {

        assertEquals("Poupança", contaPoupanca.getDescricao());

    }

    /**
     * Metodo que testa o deposito de dinheiro na conta.
     * */
    @Test
    public void depositarDinheiroNaConta() throws InvalidAttributesException {

        contaPoupanca.depositarDinheiro(200);
        assertEquals(200, contaPoupanca.getDinheiro());

    }

    /**
     * Metodo de saque do dinheiro da conta.
     * */
    @Test
    public void sacarDinheiroDaConta() throws InvalidAttributesException {

        contaPoupanca.depositarDinheiro(200);
        contaPoupanca.sacarDinheiro(100);

        assertEquals(100, contaPoupanca.getDinheiro());

    }

    /**
     * Metodo para testar o juros no valor do mes (esse valor é passado pelo banco)
     * */
    @Test
    public void testeDeInserirJuros() throws InvalidAttributesException {

        contaPoupanca.depositarDinheiro(200);
        contaPoupanca.depositarJurosCliente(100);

        assertEquals(200.6, contaPoupanca.getDinheiro());

    }

}
