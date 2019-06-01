package br.com.banco.principal;

import br.com.banco.modelo.Correntista;

import java.util.Scanner;

public class Tela {
    public static Scanner terminal= new Scanner(System.in);

    public static void imprimeSeparador(int numeroTela, String tituloPagina){
        System.out.print("\n######## "+numeroTela+"# "+tituloPagina+" ** [Target Bank] ************");
    }
    public static int solicitaOpMenu(){
        System.out.print("\nOpcoes\n1 - Extrato\n");
        System.out.print("2 - Saldo\n3 - Deposito\n4 - Saque\n5 - Pagamentos\n6 - Rendimentos\n99-Sair\n");
        return terminal.nextInt();
    }

    public static void imprimeCorrentista(Correntista correntista) {
        System.out.print("\nNome:" + correntista.getNome());
        System.out.print(" | Ag: " + correntista.getConta().getCodigoAgencia());
        System.out.print(" | CC: " + correntista.getConta().getNumeroConta());
    }
    
    public static int solicitaAgencia(){
        System.out.print("\nAgencia: ");
        return terminal.nextInt();
    }

    public static long solicitaConta(){
        System.out.print("Conta:");
        return terminal.nextLong();
    }

    public static String solicitaSenha(){
        System.out.print("Senha:");
        return terminal.next().trim();
    }

    public static void imprimeExtrato(Correntista correntista){
        System.out.print(correntista.getConta().geraExtrato());
        imprimeSaldo(correntista);
    }

    public static void imprimeValor(double valor,String titulo){
        System.out.print("\n"+titulo+"\t\t\t" + valor+ "\n");
    }

    public static double solicitaDouble(){
        System.out.print("Digite o valor da operação:");
        return terminal.nextDouble();
    }

    public static void imprimeSaldo(Correntista correntista){
        imprimeValor(correntista.getConta().getSaldo(),"Saldo");
    }
}
