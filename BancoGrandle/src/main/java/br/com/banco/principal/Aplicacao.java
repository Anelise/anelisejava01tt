package br.com.banco.principal;

import br.com.banco.modelo.BancoDeDados;
import br.com.banco.modelo.Correntista;

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
                while(true){
                    imprimeMenuConta(corrAtual);

                    if(abreMenuConta(terminal,corrAtual) == 99){
                        return;
                    }
                }
            }
        }
    }
    public static void menuOpExtrato(Correntista corr){
        System.out.print("######## 3# Extrato"+corr.getConta().geraExtrato());
        System.out.print("\n\t\t\t"+corr.getConta().getSaldo()+"\n");
    }

    public static void menuOpVeSaldo(Correntista corr){
        System.out.print("######## 4# Saldo"+corr.getConta().geraExtrato());
        System.out.print("\n\t\t\t"+corr.getConta().getSaldo()+"\n");
    }


    public static int abreMenuConta(Scanner terminal,Correntista corr){
        int op = terminal.nextInt();
            switch (op) {
                case 1:
                    menuOpExtrato(corr);
                    break;
                case 2:
                    menuOpVeSaldo(corr);
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
        System.out.print("\n######## 2# Tela inicial ** [Target Bank] ************\nNome:"+correntista.getNome());
        System.out.print(" | Ag: "+correntista.getConta().getCodigoAgencia());
        System.out.print(" | CC: "+correntista.getConta().getNumeroConta());
        System.out.print("\nOpcoes\n1 - Extrato\n");
        System.out.print("2 - Saldo\n3 - Deposito\n4 - Saque\n5 - Pagamentos\n99-Sair\n");

    }

    public static Correntista solicitaLogin(Scanner terminal){

        System.out.print("######## 1# login ** [Target Bank] ************\nAgencia: "  );
        int nAgencia = terminal.nextInt();
        System.out.print("Conta:");
        long nConta= terminal.nextLong();
        System.out.print("Senha:");
        String senha= terminal.next().trim();

        if(!senha.equals("123456")){
            System.out.println("Senha não confere");
            return null;
        }

        return BancoDeDados.getCorrentistaPorCCAG(nConta,nAgencia);
    }
}
