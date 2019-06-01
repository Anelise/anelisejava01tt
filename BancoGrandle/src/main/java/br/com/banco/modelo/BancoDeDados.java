package br.com.banco.modelo;

import java.util.ArrayList;

public class BancoDeDados {
    private static ArrayList<Correntista> corr;

    public static ArrayList<Correntista> getCorrentistasBD(){
        if(corr == null){
            limpaBD();
        }

        return corr;
    }

    private static void inicializaBD(){
        Correntista cor1 = new Correntista("Ana Maria", new Conta(1,1));
        Correntista cor2 = new Correntista("Marcos Mane", new Conta(2,1));
        Correntista cor3 = new Correntista("Marcia Nunes", new Conta(3,1));

        corr.add(cor1);
        corr.add(cor2);
        corr.add(cor3);

        cor1.getConta().depositaValorDoSaldo(10000);
        cor1.getConta().retiraValorDoSaldo(15);

        cor2.getConta().depositaValorDoSaldo(100);
        cor1.getConta().retiraValorDoSaldo(5);

        cor3.getConta().depositaValorDoSaldo(4000);
        cor1.getConta().retiraValorDoSaldo(3);
    }

    public static Correntista getCorrentistaPorCCAG(long conta, int agencia){

        for(Correntista corAtual: corr){
            if(corAtual.getConta().getNumeroConta()==conta&&corAtual.getConta().getCodigoAgencia()==agencia)
                return corAtual;

        }
        return null;

    }

    public static void limpaBD(){
        corr = new ArrayList();
        inicializaBD();
    }


}
