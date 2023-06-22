import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributesException;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DirecaoTest {

    Direcao direcao;
    Cliente cliente1;
    Cliente cliente2;
    Cliente cliente3;
    Cliente cliente4;
    Cliente cliente5;

    @BeforeEach
    public void init() throws InvalidAttributesException {

        direcao = new Direcao();
        cliente1 = new Cliente("Pedro", "20/07/2001", "123.456.789-10", "Investimento", "12345");
        cliente2 = new Cliente("Eduardo", "19/06/2000", "123.456.789-11", "Investimento", "54321");
        cliente3 = new Cliente("Caram", "01/10/1973", "123.456.789-12", "Corrente", "3214532"); //Perdao fessor, n sei seu niver kkk
        cliente4 = new Cliente("Lucas", "19/02/2004", "123.456.789-13", "Corrente", "5464535432321");
        cliente5 = new Cliente("Mateus", "27/06/1999", "123.456.789-14", "Poupanca", "543121111121");
        cliente5.adicionarNovaConta("Corrente");

        cliente1.getContasDoCliente().stream().filter(conta -> Objects.equals(conta.getDescricao(), "Investimento")).findFirst().ifPresent(conta -> {
            try {
                conta.depositarDinheiro(5000);
            } catch (InvalidAttributesException e) {
                throw new RuntimeException(e);
            }
        });

        cliente2.getContasDoCliente().stream().filter(conta -> Objects.equals(conta.getDescricao(), "Investimento")).findFirst().ifPresent(conta -> {
            try {
                conta.depositarDinheiro(15000);
            } catch (InvalidAttributesException e) {
                throw new RuntimeException(e);
            }
        });
        cliente3.getContasDoCliente().stream().filter(conta -> Objects.equals(conta.getDescricao(), "Corrente")).findFirst().ifPresent(conta -> {
            try {
                conta.depositarDinheiro(1000000);
            } catch (InvalidAttributesException e) {
                throw new RuntimeException(e);
            }
        });

        cliente4.getContasDoCliente().stream().filter(conta -> Objects.equals(conta.getDescricao(), "Corrente")).findFirst().ifPresent(conta -> {
            try {
                conta.depositarDinheiro(430);
            } catch (InvalidAttributesException e) {
                throw new RuntimeException(e);
            }
        });
        cliente5.getContasDoCliente().stream().filter(conta -> Objects.equals(conta.getDescricao(), "Poupança")).findFirst().ifPresent(conta -> {
            try {
                conta.depositarDinheiro(100);
            } catch (InvalidAttributesException e) {
                throw new RuntimeException(e);
            }
        });
        cliente5.getContasDoCliente().stream().filter(conta -> Objects.equals(conta.getDescricao(), "Corrente")).findFirst().ifPresent(conta -> {
            try {
                conta.depositarDinheiro(2000);
            } catch (InvalidAttributesException e) {
                throw new RuntimeException(e);
            }
        });



        direcao.adicionarCliente(cliente1);
        direcao.adicionarCliente(cliente2);
        direcao.adicionarCliente(cliente3);
        direcao.adicionarCliente(cliente4);
        direcao.adicionarCliente(cliente5);

    }

    /**
     * Teste de custodia por tipo de conta.
     * */
    @Test
    public void testarCustodiaDeConta() throws InvalidAttributesException {

        assertEquals(1002430, direcao.calcularValorAtualEmCustodia("Corrente"));

    }

    /**
     * Teste de custodia por tipo de conta.
     * */
    @Test
    public void testarValorMedioDasContas() throws InvalidAttributesException {

        assertEquals(10000, direcao.calcularValorMedioDeCadaTipoDeConta("Investimento"));

    }

    /**
     * Teste de cliente com menor valor dentre todas as contas.
     * */
    @Test
    public void testeClienteComMenorValorEmCustodia(){

        Cliente cliente = direcao.obterClienteComMenorValor();

        assertEquals("Lucas", cliente.getNome());

    }

    /**
     * Teste de cliente com maior valor dentre todas as contas.
     * */
    @Test
    public void testeClienteComMaiorValorEmCustodia(){

        Cliente cliente = direcao.obterClienteComMaiorValor();

        assertEquals("Caram", cliente.getNome());

    }


}
