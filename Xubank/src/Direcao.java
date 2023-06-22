import javax.naming.directory.InvalidAttributesException;
import java.util.*;


public class Direcao {

    private static final ArrayList<Cliente> listaDeClientes = new ArrayList<>();

    /**
     * Metodo para calcular o valor total em custodia de uma conta especifica.
     * @param tipoConta recebe o tipo da conta para filtrar.
     * @throws InvalidAttributesException caso o tipo de conta passado näo exista.
     * */
    public double calcularValorAtualEmCustodia(String tipoConta) throws InvalidAttributesException {

        if(Objects.equals(tipoConta, "Corrente") || Objects.equals(tipoConta, "Investimento") || Objects.equals(tipoConta, "Renda Fixa") || Objects.equals(tipoConta, "Poupança")){

            return listaDeClientes.stream()
                    .flatMap(cliente -> cliente.getContasDoCliente().stream())
                    .filter(conta -> conta.getDescricao().equals(tipoConta))
                    .mapToDouble(Conta::getDinheiro)
                    .sum();

        }
        else{
            throw new InvalidAttributesException("Tipo de conta nao existe no banco.");
        }

    }

    /**
     * Metodo para calcular o valor medio por tipo de conta.
     * @param tipoConta recebe o tipo da conta para realizar o filtro
     * @throws InvalidAttributesException caso o tipo de conta não exista.
     * */
    public double calcularValorMedioDeCadaTipoDeConta(String tipoConta) throws InvalidAttributesException {
        if(Objects.equals(tipoConta, "Corrente") || Objects.equals(tipoConta, "Investimento") || Objects.equals(tipoConta, "Renda Fixa") || Objects.equals(tipoConta, "Poupança")){

            return listaDeClientes.stream()
                    .flatMap(cliente -> cliente.getContasDoCliente().stream())
                    .filter(conta -> conta.getDescricao().equals(tipoConta))
                    .mapToDouble(Conta::getDinheiro)
                    .average()
                    .orElse(0.0);

        }
        else{
            throw new InvalidAttributesException("Tipo de conta nao existe no banco.");
        }
    }

    /**
     * Metodo para obter o cliente com menor valor em custodia diante todas suas contas.
     * */
    public Cliente obterClienteComMenorValor() {
        return listaDeClientes.stream()
                .min(Comparator.comparingDouble(cliente -> cliente.getContasDoCliente().stream()
                        .mapToDouble(Conta::getDinheiro)
                        .sum()))
                .orElse(null);
    }

    /**
     * Metodo para obter o cliente com maior valor em custodia diante todas suas contas.
     * */
    public Cliente obterClienteComMaiorValor() {
        return listaDeClientes.stream()
                .max(Comparator.comparingDouble(cliente -> cliente.getContasDoCliente().stream()
                        .mapToDouble(Conta::getDinheiro)
                        .sum()))
                .orElse(null);
    }

    /**
     * Método chamado pelo construtor de cliente que armazenará o novo objeto cliente recèm criado no array de clientes desta classe
     */
    public void adicionarCliente(Cliente cliente){
        listaDeClientes.add(cliente);

    }

}
