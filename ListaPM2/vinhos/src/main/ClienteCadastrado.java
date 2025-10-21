package main;

public class ClienteCadastrado extends Cliente {
    private static final double TAXA_FRETE = 0.1;
    private static final double MAX_FRETE = 12;
    public ClienteCadastrado(String nome, String cpf, String senha, String email) {
        super(nome, cpf, senha, email);
        
    }
    @Override
    public double calcularMensalidade() {
        mensalidade = 0.00d;
        return mensalidade;
    }
    @Override
    public double calcularFrete(double valorCompra) {
        frete = valorCompra*TAXA_FRETE;
        if (frete>MAX_FRETE){
            frete = MAX_FRETE;
        }
        return frete;
    }
    @Override
    public double calcularDesconto() {
        double desconto = 0.0;
        if (comprasSequenciais >= 10.0) {
            desconto = 0.1;
        }
        return desconto;
    }
    @Override
    public double calcularValorCompra(double valorCompra) {
        double desconto = calcularDesconto();
        double valorFinal;
        if(desconto > 0.0){
            this.comprasSequenciais = 0;
            valorFinal = valorCompra - (valorCompra * desconto);
        }
        else{
            this.comprasSequenciais += 1.0;
            valorFinal = valorCompra;
        }
        return valorFinal;
    }
}