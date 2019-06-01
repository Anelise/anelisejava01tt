package br.com.banco.principal;

import br.com.banco.modelo.BancoDeDados;
import br.com.banco.modelo.Correntista;

public class Controlador {

    public static Correntista fazLogin(int nagencia, long nconta, String senha){
        if (!senha.equals("123456")) {
            System.out.println("Senha não confere");
            return null;
        }

        return BancoDeDados.getCorrentistaPorCCAG(nconta, nagencia);
    }
}
