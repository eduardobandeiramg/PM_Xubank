public class FactoryConta implements Factory{
    @Override
    public Conta criarObjeto(String tipo) {

        switch (tipo.toUpperCase()){
            case "CORRENTE" -> {return new ContaCorrente();}
            case "INVESTIMENTO" -> {return new ContaInvestimentos();}
            case "RENDA FIXA" -> {return new ContaRendaFixa();}
            case "POUPANCA" -> {return new ContaPoupanca();}
        }

        return null;
    }

}
