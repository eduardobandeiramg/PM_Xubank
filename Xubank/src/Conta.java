import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;


public abstract class Conta{

    protected  Cliente cliente;
    protected String descricao;
    protected double dinheiro;
    protected Map<LocalDate, List<Double>> movimentacoes = new HashMap<>();

    Conta(Cliente cliente){
        this.cliente = cliente;
        this.dinheiro = 0;
    }

    //Metodos get
    public String getDescricao() {
        return descricao;
    }
    public double getDinheiro() {
        return dinheiro;
    }

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

    public void puxarSituacao(){
        // Mostra a situação atual para o dia de hoje
        LocalDate hoje = LocalDate.now();
        System.out.println("Situação atual para o dia " + hoje + ": ");
        System.out.println("Saldo em conta: " + dinheiro);
    }

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
}