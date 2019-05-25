package br.com.exercicio01;

public class Indices {
    public static double SELIC = 6.5;
    public static double TXJUROSGERAL = 0.3;

    public static double calculaJurosMensalPoupanca(){
        return (TXJUROSGERAL + (0.7*SELIC))/12;
    }


}
