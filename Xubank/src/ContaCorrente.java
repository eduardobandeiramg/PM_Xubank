import javax.naming.directory.InvalidAttributesException;

public class ContaCorrente extends Conta{

    private double limiteCreditoTotal;
    private double limiteCreditoReal;

    ContaCorrente() {
        super();
        this.descricao = "Corrente";
        this.limiteCreditoTotal = 0;
    }

    //Metodos get
    private double getLimiteCreditoReal(){
        return limiteCreditoReal;
    }

    public void setLimiteCreditoReal(double limiteCreditoReal) {
        this.limiteCreditoReal = limiteCreditoReal;
    }

    public void aumentarLimiteDeCredito(double limite) throws InvalidAttributesException {
        if(limite > 0) {
            limiteCreditoTotal = limite;
        }
        else{
            throw new InvalidAttributesException("Limite nao pode ser negativo!");
        }
    }

    @Override
    public void sacarDinheiro(double valor) {

        double dinheiroParaSacar = dinheiro + limiteCreditoReal;

        double dinheiroSacado = (dinheiro) - valor;

        if(dinheiroSacado<0){
            throw new RuntimeException("Saldo Insuficinete!");
        }
        else{
            dinheiro = dinheiroSacado;
        }
    }
}
