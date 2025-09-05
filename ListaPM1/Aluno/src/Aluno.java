public class Aluno {
    private String nome;
    private final int matricula;
    private static final int qntProvas = 4;
    private double[]listaAvaliacoes;
    private double reavaliacao;
    

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.listaAvaliacoes = new double[qntProvas];
        reavaliacao = -1;
    }

    public double notaFinal(){
        double soma = 0;
        
           
        for (int i = 0; i < qntProvas; i++) {
            soma += listaAvaliacoes[i];
        }
         soma = soma / qntProvas;
         if(reavaliacao != -1 ){
            return (soma + reavaliacao) / 2;
         }
         else{
            return soma;
         }
        
    }

    public String situacao(){
        double notaFinal = notaFinal();
        if(notaFinal >= 6){
            return "Aprovado";
        } 
        if (notaFinal < 6 && notaFinal >= 4 && reavaliacao == -1) {
            return "Reavaliação";
        }
        else {
            return "Reprovado";
        }
    }
    public void setNota(int indice, double nota){
        if(indice >= 0 && indice < qntProvas && nota >= 0 && nota <= 10){
            listaAvaliacoes[indice] = nota;
        }
    }
    public void setReavaliacao(double nota){
        if(nota >= 0 && nota <= 10){
            reavaliacao = nota;
        }
    }
}
