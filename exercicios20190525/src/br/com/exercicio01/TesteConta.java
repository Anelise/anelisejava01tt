package br.com.exercicio01;

public class TesteConta {
    public static void  main(String[] args){
        Conta c = new Conta("Anelise", 1,1,5000);

        System.out.println(c);

        c.depositaValorDoSaldo(1000);
        System.out.println("Depositei 1000:");
        System.out.println(c);

        c.retiraValorDoSaldo(50);
        System.out.println("Retirei 50:");
        System.out.println(c);


        System.out.println("Rendimento mês:"+c.calculaRendimentoMes());

    }

}
