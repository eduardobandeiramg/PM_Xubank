import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaTest {

    Conta contaCorrente;
    Conta contaInvestimento;
    Conta contaPoupanca;
    Conta contaRendaFixa;

    FactoryConta factoryConta = new FactoryConta();

    @BeforeEach
    public void init() {

        contaCorrente = factoryConta.criarObjeto("Corrente");
        contaInvestimento = factoryConta.criarObjeto("Investimento");
        contaPoupanca = factoryConta.criarObjeto("Poupanca");
        contaRendaFixa = factoryConta.criarObjeto("Renda Fixa");

    }

    @Test
    public void criarContas() {

        assertEquals("Corrente", contaCorrente.getDescricao());
        assertEquals("Investimento", contaInvestimento.getDescricao());
        assertEquals("Poupança", contaPoupanca.getDescricao());
        assertEquals("Renda Fixa", contaRendaFixa.getDescricao());

    }

    @Test
    public void adicionarDinheiroNaConta() {
        try {

            contaCorrente.depositarDinheiro(200);

            assertEquals(200, contaCorrente.getDinheiro());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void sacarDinheiroDaConta() {

        try {
            contaPoupanca.depositarDinheiro(200);
            contaPoupanca.sacarDinheiro(100);

            assertEquals(100, contaPoupanca.getDinheiro());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void sacarDinheiroIndisponivel() {
        try {
            contaInvestimento.depositarDinheiro(200);
            contaInvestimento.sacarDinheiro(300);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
