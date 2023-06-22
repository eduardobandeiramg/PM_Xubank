import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    Pessoa pessoa;

    @BeforeEach
    public void init() {

        pessoa = new Pessoa("Pedro", "20/07/2001", "102.435.879-09");

    }

    /**
     * Metodo apenas para testar se a data passada calcula a idade correta
     */
    @Test
    public void testarIdade() {


        assertEquals(21, pessoa.getIdade());

    }

}
