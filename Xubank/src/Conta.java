import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public abstract class Conta{

    protected String descricao;
    protected double dinheiro;
    Map<LocalDate, List<Double>> movimentacoes = new HashMap<>();

    Conta(){
        this.dinheiro = 0;
    }

    //Metodos get
    public String getDescricao() {
        return descricao;
    }
    public double getDinheiro() {
        return dinheiro;
    }

    /**
     * Metodo para depositar dinheiro na conta.
     * @param valor valor a ser depsitado na conta.
     * */
    public void depositarDinheiro(double valor){

        dinheiro += valor;

    }

    /**
     * Metodo para sacar dinheiro da conta.
     * @param valor valor a ser depsitado na conta.
     * */
    public void sacarDinheiro(double valor){

        double dinheiroSacado = dinheiro - valor;

        if(dinheiroSacado<0){
            throw new RuntimeException("Saldo Insuficinete!");
        }
        else{
            dinheiro = dinheiroSacado;
        }

    }

    public void addMovimentacao(Double valor){
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
        LocalDate hoje = LocalDate.now();
        System.out.println("Situação atual para o dia " + hoje + ": ");
        System.out.println("Saldo em conta: " + dinheiro);
    }

        public void puxarExtrato(){
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