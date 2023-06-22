import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributesException;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    Cliente cliente;

    /**
     * Metodo que inicia antes dos testes, para criar o cliente do zero
     * */
    @BeforeEach
    public void init() throws InvalidAttributesException {

        cliente = new Cliente("Pedro", "20/07/2001", "123.456.789-10", "Investimento", "12345");

    }

    /**
     * Metodo para testar adicionar contas novas ao cliente.
     */
    @Test
    public void testarAdicionarNovaConta() throws InvalidAttributesException {

        cliente.adicionarNovaConta("Poupança");
        assertEquals("Contas do Pedro: Investimento, Poupança.", cliente.nomeContasCliente());

    }

    /**
     * Metodo para testar adicionar contas iguais ao cliente, sempre vai cair no
     * erro.
     */
    @Test
    public void testarAdicionarContasIguais() {

        assertThrows(InvalidAttributesException.class, () -> cliente.adicionarNovaConta("Investimento"));
    }


}
