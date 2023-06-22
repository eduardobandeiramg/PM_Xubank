import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Direcao {

    private static ArrayList<Cliente> listaDeClientes = new ArrayList<>();

    public void calcularValorAtualEmCustodia(String tipoConta){

        if(Objects.equals(tipoConta, "Corrente") || Objects.equals(tipoConta, "Investimento") || Objects.equals(tipoConta, "Renda Fixa")){

        }


    }

    /**
     * Método que percorrerá o array de clientes e mostrará quem são os clientes extremos
     */
    public void  clientesExtremos() {
        double menorSaldoAtual , menorSaldoGlobal = 0, maiorSaldoAtual , maiorSaldoGlobal = 0;
        String cpfDoMenor = null, cpfDoMaior;
        Conta contaAtual;
        ArrayList<Double> saldoNasContas= new ArrayList<>();

        for(Cliente cliente : listaDeClientes){
            for(Conta conta : cliente.getContasDoCliente()){
                saldoNasContas.add(conta.getDinheiro());
                    menorSaldoAtual = Collections.min(saldoNasContas);
                    if(menorSaldoAtual < menorSaldoGlobal){
                        menorSaldoGlobal = menorSaldoAtual;
                        cpfDoMenor = cliente.getCPF();
                    }
            }

        }
        System.out.println("CPF do cliente com o menor saldo: " + cpfDoMenor);

            for(Cliente cliente : listaDeClientes){
            for(Conta conta : cliente.getContasDoCliente()){
                saldoNasContas.add(conta.getDinheiro());
                    maiorSaldoAtual = Collections.max(saldoNasContas);
                    if(maiorSaldoAtual > maiorSaldoGlobal){
                        maiorSaldoGlobal = maiorSaldoAtual;
                        cpfDoMaior = cliente.getCPF();
                    }
            }

        }
        System.out.println("CPF do cliente com o maior saldo: " + cpfDoMenor);

    }

    /**
     * Método chamado pelo construtor de cliente que armazenará o novo objeto cliente recèm criado no array de clientes desta classe
     */
    public void adicionarCliente(Cliente cliente){
        listaDeClientes.add(cliente);

    }


}
