package main;

public abstract class Cliente {
    private String nome;
    private String cpf;
    private String senha;
    private String email;
    protected double comprasSequenciais;
    protected double mensalidade;
    protected static final double VALOR_MENSALIDADE = 40.0;
    protected double frete;
    
    

    public Cliente(String nome, String cpf, String senha, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.comprasSequenciais = 0.0;
        mensalidade = calcularMensalidade();

        
    }
    public abstract double calcularMensalidade();

    public abstract double calcularFrete(double valorCompra);

    public abstract double calcularValorCompra(double valorCompra);

    public abstract double calcularDesconto();
        
    

    
}