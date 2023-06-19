import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClienteTest {

    Cliente cliente;

    @BeforeEach
    public void init(){
        try {
            cliente = new Cliente("Pedro", "20/07/2001", "123.456.789-10", "Investimento", "12345");
        }
        catch (InvalidAttributesException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para testar adicionar contas novas ao cliente.
     * */
    @Test
    public void testarAdicionarNovaConta(){
        try{
            cliente.adicionarNovaConta("Poupança");
            assertEquals("Contas do Pedro: Investimento, Poupança.", cliente.nomeContasCliente());
        }
        catch (InvalidAttributesException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para testar adicionar contas iguais ao cliente, sempre vai cair no erro.
     * */
    @Test
    public void testarAdicionarContasIguais(){

        try{

            cliente.adicionarNovaConta("Investimento");
            assertEquals("Contas do Pedro: Investimento, Investimento.", cliente.nomeContasCliente());

        }
        catch (InvalidAttributesException e){
            System.out.println(e.getMessage());
        }
    }

}
