import java.util.ArrayList;
import java.util.Collections;


public static class Direcao {
    private  static ArrayList<Cliente> listaDeClientes = new ArrayList<>();
    private  static ArrayList<Conta> listaDeContas = new ArrayList<>();
    

    /*
     * Método que percorrerá o array de contas e retornará a soma dos saldos de cada tipo de conta solicitada
     */
    public double valorEmCustodia(String descricao) {
        double valorTotal = 0;
            for (Conta conta : listaDeContas) {
            if (conta.getDescricao().equals(descricao)) {
                valorTotal += conta.getDinheiro();
            }
        }
        return valorTotal;
    }

    /*
     * Método que percorrerá o array de contas e retornará a média das somas dos saldos de cada conta
     */
    public double saldoMedio(String descricao) {
        double valorTotal = 0;
        listaDeContas.size();
        for(Conta conta : listaDeContas){
            valorTotal += conta.getDinheiro();
        
        }
        return valorTotal / listaDeContas.size();
    }

    /*
     * Método que percorrerá o array de clientes e mostrará quem são os clientes extremos
     */
    public void  clientesExtremos() {
        double menorSaldoAtual , menorSaldoGlobal , maiorSaldoAtual , maiorSaldoGlobal;
        String cpfDoMenor , cpfDoMaior;
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

    /*
     * Método chamado pelo construtor das classes conta que armazenará o objeto conta recèm criado no array de contas desta classe
     */
    public static void adicionarConta(Conta conta){
        listaDeContas.add(conta);
    }

    /*
     * Método chamado pelo construtor de cliente que armazenará o novo objeto cliente recèm criado no array de clientes desta classe
     */
    public void adicionarCliente(Cliente cliente){
        listaDeClientes.add(cliente);

    }


}
