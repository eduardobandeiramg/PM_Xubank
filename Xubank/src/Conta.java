import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;


public abstract class Conta{

    protected String descricao;
    protected double dinheiro;
    protected Map<LocalDate, List<Double>> movimentacoes = new HashMap<>();
    protected  Map <LocalDate , Double> saldoNoMes = new HashMap<>();

    public Conta(){
        descricao = null;
        dinheiro = 0;
        movimentacoes = null;
    }

    //Metodos Set
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    //Metodos get
    public String getDescricao() {
        return descricao;
    }
    public double getDinheiro() {
        return dinheiro;
    }

    /*Método que é chamado em toda movimentação da conta para salvar essa movimentação
    vinculada a uma data e permitir que seja retirdado um extrato da conta 
    */
    public void addMovimentacao(Double valor){
        // Atualiza o histório de movimentações da conta
        // Se ja existem movimentações registradas para hoje, adicionar o valor à chave data de hoje
            if (movimentacoes.containsKey(LocalDate.now())) {
            List<Double> valores = movimentacoes.get(LocalDate.now());
            valores.add(valor);
        } else {
            // Se a chave ainda não existe, criar uma nova chave e adicionar nela
            List<Double> valores = new ArrayList<>();
            valores.add(valor);
            movimentacoes.put(LocalDate.now(), valores);
        }


    }
    /*Método que apresenta o saldo atual da conta */
    public void puxarSituacao(){
        // Mostra a situação atual para o dia de hoje
        LocalDate hoje = LocalDate.now();
        System.out.println("Situação atual para o dia " + hoje + ": ");
        System.out.println("Saldo em conta: " + dinheiro);
    }
        /*Método que mostra o extrato da conta (histório de movimentações 
        dos útllimos 30 dias. depósitos são mostrados como valores positivos e saques
        são mostrados como os valores negativos) */
        public void puxarExtrato(){
            // Mostra o histórico de movimentações nos últimos 30 dias
            LocalDate hoje = LocalDate.now();
            LocalDate inicio = hoje.minusMonths(1);
            
            while(inicio != hoje.plusDays(1)) {
			if (movimentacoes.containsKey(inicio)){
				System.out.println("Movimentações no dia " + inicio + ": " + movimentacoes.get(inicio));
			}
			inicio = inicio.plusDays(1);
		}		

        }

        public void depositarDinheiro(double valor){
        if(valor > 0){
                    dinheiro += valor;
                    addMovimentacao(valor);
                    atualizarSaldoNoMes(valor);
        }
        else{
            System.out.println("Não é possível depositar valores menores ou iguais a zero");
        }
    }

        public void sacarDinheiro(double valor){
        double dinheiroSacado = dinheiro - valor;
        if(dinheiroSacado<0){
            throw new RuntimeException("Saldo Insuficinete!");
        }
        else{
            dinheiro = dinheiroSacado;
            addMovimentacao(- valor);
            atualizarSaldoNoMes(- valor);
        }
    }

        public void atualizarSaldoNoMes(Double valor){
        //atuaiza o saldo para a chave do mês em questão
        if(saldoNoMes.containsKey(LocalDate.now())){
            double saldoAnterior = saldoNoMes.get(LocalDate.now());
            Double novoValor = saldoAnterior - valor;
            saldoNoMes.put(LocalDate.now() , novoValor);
        }
        else{
            saldoNoMes.put(LocalDate.now() , valor);
        }

    }
}