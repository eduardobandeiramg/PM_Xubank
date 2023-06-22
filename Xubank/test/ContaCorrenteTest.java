import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.util.Random;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ContaCorrenteTest {

    Conta conta;
    ContaCorrente contaCorrente;

    FactoryConta factoryConta = new FactoryConta();

    /**
     * Metodo que inicia o a fabrica de conta e cria uma conta corrente.
     * */
    @BeforeEach
    public void init() {

        conta = factoryConta.criarObjeto("Corrente");
        contaCorrente = (ContaCorrente)conta;

    }

    /**
     * Metodo que verifica a criacao da conta.
     * */
    @Test
    public void verificarACriacaoDaConta() {

        assertEquals("Corrente", contaCorrente.getDescricao());

    }

    /**
     * Metodo que testa o deposito de dinheiro na conta.
     * */
    @Test
    public void depositarDinheiroNaConta() {

        contaCorrente.depositarDinheiro(200);
        assertEquals(200, contaCorrente.getDinheiro());

    }

    /**
     * Metodo de saque do dinheiro da conta.
     * */
    @Test
    public void sacarDinheiroDaConta() throws InvalidAttributesException {

        contaCorrente.depositarDinheiro(200);
        contaCorrente.sacarDinheiro(100);

        assertEquals(100, contaCorrente.getDinheiro());

    }

    /**
     * Metodo de saque de dinheiro da conta com credito, o valor fica negativo.
     * */
    @Test
    public void sacarDinheiroComCredito() throws InvalidAttributesException {

        contaCorrente.depositarDinheiro(300);
        contaCorrente.atualizarLimiteDeCredito(100);

        contaCorrente.sacarDinheiro(400);

        assertEquals(-100, contaCorrente.getDinheiro());

    }

    /**
     * Metodo que saca dinheiro alem do valor possivel, retorna sempre um erro.
     * */
    @Test
    public void sacarDinheiroAlemDoCredito() throws InvalidAttributesException {

        contaCorrente.depositarDinheiro(300);
        contaCorrente.atualizarLimiteDeCredito(100);

        assertThrows(InvalidAttributesException.class, () -> contaCorrente.sacarDinheiro(600));

    }

    /**
     * Metodo que testa a regra de deposito caso o valor seja negativo, descontando a taxa.
     * */
    @Test
    public void testeDeRegraDeDepositoComValorNegativo() throws InvalidAttributesException {

        contaCorrente.depositarDinheiro(200);
        contaCorrente.atualizarLimiteDeCredito(100);
        contaCorrente.sacarDinheiro(300);

        contaCorrente.depositarDinheiro(200);

        assertEquals(87, contaCorrente.getDinheiro());

    }

    /**
     * Metodo que testa o extrato da conta.
     * */
    @Test
    public void testePuxarExtrato() throws InvalidAttributesException {

        contaCorrente.depositarDinheiro(500);
        contaCorrente.sacarDinheiro(300);

        contaCorrente.puxarExtrato();
    }

    /**
     * Metodo que testa a situacao da conta.
     * */
    @Test
    public void testeDeSituacaoDaConta() throws InvalidAttributesException {

        contaCorrente.depositarDinheiro(500);
        contaCorrente.sacarDinheiro(300);

        contaCorrente.puxarSituacao();

    }



}
