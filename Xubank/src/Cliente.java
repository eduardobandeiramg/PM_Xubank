import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Pessoa{

    private String senha;
    private final ArrayList<Conta> contasDoCliente = new ArrayList<>();


    /**
     * Contrutor da classe Cliente.
     *
     * @param nome nome do cliente.
     * @param data data de nascimento do cliente.
     * @param conta tipo da conta que o cliente vai criar.
     * @param cpf cpf do cliente.
     * @param senha senha do conta do cliente.
     * */
    public Cliente(String nome, String data, String cpf, String conta, String senha) throws InvalidAttributesException {
        super(nome, data, cpf);
        try{
            adicionarNovaConta(conta);
        }
        catch (InvalidAttributesException e){
            throw new InvalidAttributesException(e.getMessage());
        }

    }

    /**
     * Metodo que adiciona uma nova conta ao cliente, caso a conta ja existe para o clinete, n é possivel adicionar.
     *
     * @param conta_nome tipo da conta que o cliente quer criar.
     * */
    public void adicionarNovaConta(String conta_nome) throws InvalidAttributesException {

        for (Conta conta : contasDoCliente) {

            if(Objects.equals(conta.getDescricao(), conta_nome)){
                throw new InvalidAttributesException("O cliente ja possui essa conta");
            }
        }

        conta_nome = conta_nome.toUpperCase();
        conta_nome = conta_nome.replace(" ", "");
        switch (conta_nome) {
            case "CORRENTE" -> contasDoCliente.add(new FactoryConta().criarObjeto(conta_nome));
            case "POUPANÇA" -> contasDoCliente.add(new FactoryConta().criarObjeto("Poupanca"));
            case "RENDAFIXA" -> contasDoCliente.add(new FactoryConta().criarObjeto(conta_nome));
            case "INVESTIMENTO" -> contasDoCliente.add(new FactoryConta().criarObjeto(conta_nome));
        }

    }

    /**
     * Metodo que retorna os nomes das contas que o cliente possui.
     * */
    public String nomeContasCliente(){

        StringBuilder builder = new StringBuilder();

        builder.append("Contas do ").append(nome).append(": ");

        for(Conta conta : contasDoCliente){
            builder.append(conta.getDescricao());
            builder.append(", ");
        }
        builder = new StringBuilder(builder.substring(0, builder.length() - 2));
        builder.append(".");

        return builder.toString();

    }

    /**
     * Metodo que retorna a descricao do cliente com todas as suas informacoes.
     * (Nome, CPF e idade)
     * */
    public String descricaoCliente(){

        return "Cliente: " + nome + "\n" +
                "Idade: " + getIdade(dataDeNascimento) + "\n" +
                nomeContasCliente();

    }

    /**
     * @param conta
     */

     //Método que recebe uma conta do cliente e retorna o extrato do último mês dessa conta
    public void puxarExtrato(Conta conta){
        conta.puxarExtrato();
    }
    //Método que recebe uma conta cdo cliente como parâmetro e retorna a situação da conta (saldo)
    public void puxarSituacao(Conta conta){
        conta.puxarSituacao();
    }

}
