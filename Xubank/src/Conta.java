public abstract class Conta{

    protected String descricao;
    protected double dinheiro;

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

}