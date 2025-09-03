public class ContaBancaria {
    private double saldo;
    private double limite;
    private String cpf;
    private String id;

    public ContaBancaria(String cpf, String id, double limite) {
        this.saldo = 0.0;
        this.limite = limite;
        this.cpf = cpf;
        this.id = setId(id);
    }

    public double getSaldo() {
        return this.saldo;
    }
     

    public void depositar(double valor) {
        if (valor > 0 && id.equals("00000") == false) {
            if(saldo<0){
                double taxa =0;
                taxa = Math.abs((saldo + valor))*0.03;
                saldo += valor - taxa;
                
            }
            else{
                saldo += valor;
            }
             
        } 
    }

    public void sacar(double valor){
        if (valor > 0 && valor <= saldo+limite && id.equals("00000") == false) {
            saldo -= valor;
        } 
    }

    public String toString() {
        if (id.equals("00000")) {
            return "Id da conta Invalido";
        }
        return "Conta ID: " + id + ", CPF: " + cpf + ", Saldo: " + saldo + ", Limite: " + limite;

    }

    private String setId(String id) {
        if (id.length() == 5 && id.contains("00000") == false) {
          return  this.id = id;
        }
        else {
            return "00000";
        }
    }
    

}
