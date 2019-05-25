package br.com.exercicio01;

public class TesteContaCompara {
    public static void main(String[] args){
        Conta c = new Conta("Anelise", 1,1,5000);
        Conta c2 = new Conta("Maria", 2,1,50);

        if(c==c2) System.out.println("c igual c2"); else System.out.println("diferente");
        if(c==c) System.out.println("c igual c"); else System.out.println("diferente");


    }

}
