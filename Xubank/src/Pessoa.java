import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    protected String nome;
    protected static String dataDeNascimento;
    protected String cpf;

    /**
     * Construtor da classe pessoa.
     *
     * @param nome nome da pessoa.
     * @param data data de nascimento da pessoa.
     * @param cpf  cpf da pessoa.
     */
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String nome, String data, String cpf) {
        this.nome = nome;
        this.dataDeNascimento = data;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    /**
     * Metodo que calcula a idade da pessoa de acordo com a data de nascimento.
     *
     * @param data data de nascimento da pessoa.
     */
    protected static int getIdade() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataDeNascimento, formatter);

        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataNascimento, dataAtual).getYears();
    }
}