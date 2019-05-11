import sun.font.BidiUtils;

import java.math.BigDecimal;

public class aula2 {

    public static void main(String[] args){
        long contador1 =150;
        System.out.println("Exercício1 de 11/05/2019 Imprima todos os números de 150 a 300.");
        while(contador1<301){
            System.out.printf("%d%s", contador1, "|");
            contador1++;
        }
        System.out.println("\nExercício2 de 11/05/2019 Imprima a soma de 1 até 1000.");
        contador1=0;
        for(int i=1; i<=1000; i++){
            contador1 +=i;
        }
        System.out.println("\nNúmero: "+contador1);
        System.out.println("Exercício 3 de 11/05/2019 Imprima todos os múltiplos de 3, entre 1 e 100.");
        for(int i=1; (3*i)<=100; i++){
            System.out.printf("%d%s", (3*i), "|");
        }
        System.out.println("\nExercício 4 de 11/05/2019 Imprima os fatoriais de 1 a 10.");
        contador1=1;
        for(int i=1; i<10; i++){
            contador1=contador1*i;
            System.out.printf("%d%s",contador1 , "|");
        }

        System.out.println("\nExercício 5 fatorial sem acumular o anterior");
        for(int linha=1; linha<10; linha++){
            contador1 = linha;
            for(int i=1; i<linha; i++){
                contador1 = contador1 * i;
            }
            System.out.printf("%d%s",contador1 , "|");

        }

        System.out.println("\nExercício6 fatorial sem acumular o anterior");
        for(int linha=1; linha<50; linha++){
            long contador = linha;
            for(long i=1; i<linha; i++) {
                contador = contador * i;

            }
            System.out.printf("%d= %d%s", linha,contador, "|");
        }
        System.out.println("\nExercício7 Imprima  os  primeiros  números  da  série  de  Fibonacci  até  passar  de  100");
        int num1 = 0;
        int num2 = 1;
        int soma =1;

        for(int i=0; num2<100; i++){

            System.out.printf("(%d)%s",soma, "|");
            soma = (num1+num2);
            num1 = num2;
            num2 = soma;

        }

        System.out.println("\nfim");

    }
}
