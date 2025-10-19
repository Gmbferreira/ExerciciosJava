package main;

import java.util.LinkedList;
import java.util.List;

public class Compra {
    private static final double FRETE_FIXO = 15.0d;
    private static final int QTD_DESCONTO = 10;
    private List<Vinho> vinhos;
    private int qtd_itens;
    
    public Compra() {
        this.vinhos = new LinkedList<>();
        this.qtd_itens = 0;
    }

    private double valorVinhos(){
        double total = 0.0d;
        double desconto = 0.0d;
        if(this.qtd_itens >= QTD_DESCONTO){
            for (int i = 0; i < qtd_itens; i++) {
                if(vinhos.get(i).getPreço() > desconto){
                    desconto = vinhos.get(i).getPreço();
                }
                total += vinhos.get(i).getPreço();
            }
        }
        else{
            for(Vinho vinho : this.vinhos){
            total += vinho.getPreço();
            }
        }
        return total - desconto;
    }

    public int addVinho(Vinho vinho){
        this.vinhos.add(vinho);
        this.qtd_itens++;
        return this.qtd_itens;
    }

    public double valorTotal(){
        return valorVinhos() + FRETE_FIXO;  
    }
}
