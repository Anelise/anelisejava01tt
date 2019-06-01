package br.com.banco.principal;

import br.com.banco.modelo.BancoDeDados;
import br.com.banco.modelo.Correntista;

import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args) {
        ArrayList<Correntista> bd = BancoDeDados.getCorrentistasBD();

        Correntista corrAtual;
        int nagencia;
        long nconta;
        String senha;

        while (true) {
            Tela.imprimeSeparador(1, "Login");
            nagencia = Tela.solicitaAgencia();
            nconta = Tela.solicitaConta();
            senha = Tela.solicitaSenha();

            corrAtual = Controlador.fazLogin(nagencia,nconta, senha);

            if (corrAtual != null) {
                while (true) {
                    Tela.imprimeSeparador(2, "Tela inicial");
                    Tela.imprimeCorrentista(corrAtual);
                    int op = Tela.solicitaOpMenu();

                    switch (op) {
                        case 1:
                            menuOp1(corrAtual);
                            break;
                        case 2:
                            menuOp2(corrAtual);
                            break;
                        case 3:
                            menuOp3(corrAtual);
                            break;
                        case 4:
                            menuOp4(corrAtual);
                            break;
                        case 5:
                            menuOp5(corrAtual);
                            break;
                        case 99:
                            System.out.println("Encerrar ");
                            return;
                    }

                }
            }
        }

    }


    public static void menuOp1(Correntista corr) {
        Tela.imprimeSeparador(3, "Extrato");

        System.out.print(corr.getConta().geraExtrato());
        System.out.print("\n\t\t\t" + corr.getConta().getSaldo() + "\n");
    }

    public static void menuOp2(Correntista corr) {
        Tela.imprimeSeparador(4, "Saldo");
        System.out.print(corr.getConta().geraExtrato());
        System.out.print("\n\t\t\t" + corr.getConta().getSaldo() + "\n");
    }

    public static void menuOp3(Correntista corr) {
        Tela.imprimeSeparador(4, "Deposito");

    }

    public static void menuOp4(Correntista corr) {
        Tela.imprimeSeparador(5, "Saque");

    }

    public static void menuOp5(Correntista corr) {
        Tela.imprimeSeparador(6, "Pagamentos");

    }





}
