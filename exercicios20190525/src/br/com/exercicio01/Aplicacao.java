package br.com.exercicio01;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args){
        ArrayList<Correntista> bd = BancoDeDados.getCorrentistasBD();
        Correntista corrAtual;

        Scanner terminal = new Scanner(System.in);

        while(true){
            corrAtual = solicitaLogin(terminal);

            if( corrAtual != null){
                System.out.println("Sucesso!");
                while(true){
                    imprimeMenuConta(corrAtual);

                    if(abreMenuConta(terminal) == 99){
                        return;
                    }
                }
            }
        }
    }
    public static int abreMenuConta(Scanner terminal){
        int op = terminal.nextInt();
            switch (op) {
                case 1:
                    System.out.println("op 1 ");
                    break;
                case 2:
                    System.out.println("op 2 ");
                    break;
                case 3:
                    System.out.println("op 3 ");
                    break;
                case 4:
                    System.out.println("op 4 ");
                    break;
                case 5:
                    System.out.println("op 5 ");
                    break;
                case 99:
                    System.out.println("Encerrar ");
                    break;
            }
            return op;

    }
    public static void imprimeMenuConta(Correntista correntista){
        System.out.print("\n######## 2# Tela inicial\n************ Target Bank ************\nNome:"+correntista.getNome());
        System.out.print("\nAg: "+correntista.getConta().getCodigoAgencia());
        System.out.print("\nCC: "+correntista.getConta().getNumeroConta());
        System.out.print("\n*************************************\nOpcoes\n\n1 - Extrato\n");
        System.out.print("2 - Saldo\n3 - Deposito\n4 - Saque\n5 - Pagamentos\n99-Sair\n*************************************");

    }

    public static Correntista solicitaLogin(Scanner terminal){

        System.out.print("######## 1# login\n************ Target Bank ************\n\nAgencia: "  );
        int nAgencia = terminal.nextInt();
        System.out.println("Conta:");
        long nConta= terminal.nextLong();
        System.out.println("Senha:");
        String senha= terminal.next().trim();

        if(!senha.equals("123456")){
            System.out.println("Senha não confere");
            return null;
        }

        return BancoDeDados.getCorrentistaPorCCAG(nConta,nAgencia);
    }
}
