package main;

import java.util.LinkedList;
import java.util.List;

public class Compra {
    private static final int QTD_DESCONTO = 10;
    private List<Vinho> vinhos;
    private int qtd_itens;
    private Cliente cliente;
    
    public Compra(Cliente cliente) {
        this.vinhos = new LinkedList<>();
        this.qtd_itens = 0;
        this.cliente = cliente;
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
        double valorCompra = valorVinhos();
        return valorVinhos() + cliente.calcularValorCompra(valorCompra);  
    }
}
