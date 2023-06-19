import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    protected String nome;
    protected int idade;
    protected String cpf;

    /**
     * Construtor da classe pessoa.
     *
     * @param nome nome da pessoa.
     * @param data data de nascimento da pessoa.
     * @param cpf cpf da pessoa.
     * */
    public Pessoa(String nome, String data, String cpf) {
        setNome(nome);
        this.idade = calcularIdade(data);
        setCPF(cpf);
    }

    //Metodos get
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }

    //Metodos set
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCPF(String cpf) throws IllegalArgumentException {
        if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido: deve estar no formato xxx.xxx.xxx-xx");
        }
    }

    /**
     * Metodo que calcula a idade da pessoa de acordo com a data de nascimento.
     *
     * @param data data de nascimento da pessoa.
     * */
    protected static int calcularIdade(String data) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(data, formatter);

        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataNascimento, dataAtual).getYears();
    }

    /**
     * Metodo que faz a validação do CPF no padrão XXX.XXX.XXX-XX
     *
     * @param cpf é o cpf da pessoa.
     * */
    protected boolean validarCPF(String cpf) {

        cpf = cpf.replace(".", "").replace("-", ""); // Remove os pontos e o traço, se presentes

        if (cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }
        else{
            return true;
        }

    }

}