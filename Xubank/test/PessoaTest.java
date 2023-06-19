import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.directory.InvalidAttributeValueException;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    Pessoa pessoa;

    @BeforeEach
    public void init(){

        pessoa = new Pessoa("Pedro", "20/07/2001", "102.435.879-09");

    }

    @Test
    public void testarIdade(){

        /**
         * Metodo apenas para testar se a data passada calcula a idade correta
         * */

        assertEquals(21, pessoa.getIdade());

    }

}
