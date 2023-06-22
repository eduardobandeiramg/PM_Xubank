import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.util.Random;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ContaInvestimentoTest {

    Conta conta;
    ContaInvestimentos contaInvestimento;

    FactoryConta factoryConta = new FactoryConta();

    /**
     * Metodo que inicia o a fabrica de conta e cria uma conta corrente.
     * */
    @BeforeEach
    public void init() {

        conta = factoryConta.criarObjeto("Investimento");
        contaInvestimento = (ContaInvestimentos) conta;

    }

    /**
     * Metodo que verifica a criacao da conta.
     * */
    @Test
    public void verificarACriacaoDaConta() {

        assertEquals("Investimento", contaInvestimento.getDescricao());

    }

    /**
     * Metodo que testa o deposito de dinheiro na conta.
     * */
    @Test
    public void depositarDinheiroNaConta() throws InvalidAttributesException {

        contaInvestimento.depositarDinheiro(200);
        assertEquals(200, contaInvestimento.getDinheiro());

    }

    /**
     * Metodo de saque do dinheiro da conta.
     * */
    @Test
    public void sacarDinheiroDaConta() throws InvalidAttributesException {

        contaInvestimento.depositarDinheiro(200);
        contaInvestimento.sacarDinheiro(100);

        assertEquals(100, contaInvestimento.getDinheiro());

    }

    /**
     * Metodo que saca o dinheiro com calculando o imposto sobre o rendimento mensal.
     * */
    @Test
    public void sacarDinheiroComImposto() throws InvalidAttributesException {

        contaInvestimento.depositarDinheiro(100000);
        contaInvestimento.depositarJurosCliente(40000);
        contaInvestimento.sacarDinheiro(80000);

        assertEquals(20306, contaInvestimento.getDinheiro());

    }

}
