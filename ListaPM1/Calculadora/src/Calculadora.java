public class Calculadora {
    private double entrada1;
    private double entrada2;
    private char operacao;
    private double resultado;

    public Calculadora(double entrada1, double entrada2, char operacao) {
        this.entrada1 = entrada1;
        this.entrada2 = entrada2;
        this.operacao = operacao;
    }

    public double calcular() {
        switch (operacao) {
            case '+':
                resultado = entrada1 + entrada2;
                break;
            case '-':
                resultado = entrada1 - entrada2;
                break;
            case '*':
                resultado = entrada1 * entrada2;
                break;
            case '/':
                if (entrada2 != 0) {
                    resultado = entrada1 / entrada2;
                } else {
                    resultado = 0;
                }
                break;
            default:
                resultado = 0;
                break;
        }
        return resultado;
    }
    
    public String toString(){
        return "Resultado: " + resultado;
    }
}
