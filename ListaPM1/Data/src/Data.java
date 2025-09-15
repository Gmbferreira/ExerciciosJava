public class Data {
    private int dia;
    private int mes;
    private int ano;
    private static final int[] DIAS_POR_MES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Data(int dia, int mes, int ano) {
        if (!isDataValida(dia, mes, ano)) {
            throw new IllegalArgumentException("Data inválida: " + dia + "/" + mes + "/" + ano);
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    public static boolean isBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    private static int getDiasNoMes(int mes, int ano) {
        if (mes == 2 && isBissexto(ano)) {
            return 29;
        }
        return DIAS_POR_MES[mes];
    }
    
    private static boolean isDataValida(int dia, int mes, int ano) {
        if (ano < 1 || mes < 1 || mes > 12) {
            return false;
        }
        return dia >= 1 && dia <= getDiasNoMes(mes, ano);
    }
    
    public Data somarDias(int dias) {
        Data novaData = new Data(this.dia, this.mes, this.ano);
        novaData.dia += dias;
        while (novaData.dia > getDiasNoMes(novaData.mes, novaData.ano)) {
            novaData.dia -= getDiasNoMes(novaData.mes, novaData.ano);
            novaData.mes++;
            if (novaData.mes > 12) {
                novaData.mes = 1;
                novaData.ano++;
            }
        }
        return novaData;
    }
    public boolean estaAFrente(Data outraData) {
        if (this.ano != outraData.ano) {
            return this.ano > outraData.ano;
        }
        if (this.mes != outraData.mes) {
            return this.mes > outraData.mes;
        }
        return this.dia > outraData.dia;
    }

    public int diferencaEmDias(Data outraData) {
        long diasEstaData = this.totalDiasDesdeReferencia();
        long diasOutraData = outraData.totalDiasDesdeReferencia();
        return (int) Math.abs(diasEstaData - diasOutraData);
    }
    private long totalDiasDesdeReferencia() {
        long totalDias = 0;
        for (int anoAtual = 1; anoAtual < this.ano; anoAtual++) {
            totalDias += isBissexto(anoAtual) ? 366 : 365;
        }
        for (int mesAtual = 1; mesAtual < this.mes; mesAtual++) {
            totalDias += getDiasNoMes(mesAtual, this.ano);
        }
        totalDias += this.dia;
        return totalDias;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }
}