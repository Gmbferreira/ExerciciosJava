package main;

public class ClienteExplorador extends Cliente {
    private static final double TAXA_FRETE = 10;
    private static final double DESCONTO_FIXO = 0.1;
    public ClienteExplorador(String nome, String cpf, String senha, String email) {
        super(nome, cpf, senha, email);
    }
    @Override
    public double calcularMensalidade() {
        mensalidade = VALOR_MENSALIDADE;
        return mensalidade;
    }
    @Override
    public double calcularFrete(double valorCompra) {
        if(valorCompra<=100.0){
            frete = TAXA_FRETE;
        }
        else{
            frete = 0.0;
        }
        return frete;
    }
     @Override
    public double calcularDesconto() {
        double desconto =  DESCONTO_FIXO;
        if (comprasSequenciais >= 10.0) {
            desconto = DESCONTO_FIXO + 0.05;
        }
        return desconto;
    }
     @Override
    public double calcularValorCompra(double valorCompra) {
        double desconto = calcularDesconto();
        double valorFinal;
        if(desconto > DESCONTO_FIXO){
            this.comprasSequenciais = 0;
            valorFinal = valorCompra - (valorCompra * desconto);
        }
        else{
            this.comprasSequenciais += 1.0;
            valorFinal = valorCompra * (1 - DESCONTO_FIXO);
        }
        return valorFinal;
    }
}