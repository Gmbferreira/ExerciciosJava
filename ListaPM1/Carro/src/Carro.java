

public class Carro {
    private String placa;
    private double velocidade;
    private static final double velocidadeMax = 120.0;
    public Carro(String placa, double velocidadeMax) {
        this.placa = placa;
        this.velocidade = 0;
    }

    public void acelerar(double valor){
        if(valor>0){
            if(this.velocidade + valor > velocidadeMax){
                this.velocidade = velocidadeMax;
            } else {
                this.velocidade += valor;
            }
        }
    }
    public void frear(double valor){
        if(valor>0){
            if(this.velocidade - valor < 0){
                this.velocidade = 0;
            } else {
                this.velocidade -= valor;
            }
        }
    }
    public double getVelocidade() {
        return velocidade;
    }
}