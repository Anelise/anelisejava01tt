import br.com.banco.modelo.BancoDeDados;
import br.com.banco.modelo.Conta;
import br.com.banco.modelo.Correntista;
import br.com.banco.principal.Aplicacao;
import br.com.banco.principal.Controlador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTeste {
    Correntista c1;

    @Before
    public void antesDeCada(){
        c1 = null;
        BancoDeDados.limpaBD();
    }

    @Test
    public void salva_conta_bd(){
        c1= new Correntista("Professor Riguel", new Conta(4,4));

        int tamanhoAntes = BancoDeDados.getCorrentistasBD().size();
        BancoDeDados.getCorrentistasBD().add(c1);
        Assert.assertEquals(BancoDeDados.getCorrentistasBD().size(),tamanhoAntes+1);
    }

    @Test
    public void login_AchaComDadosCertos(){
        c1 = Controlador.fazLogin(1,1,"123456");
        Assert.assertNotEquals(c1,null); //Conta Existe  Loga
    }

    @Test
    public void login_NullSenhaErrada(){
        c1 = Controlador.fazLogin(1,1,"12345");
        Assert.assertEquals(c1,null); //Senha Errada não loga
    }

    @Test
    public void login_NullNaoExiste(){
        c1 = Controlador.fazLogin(4,4,"123456");
        Assert.assertEquals(c1,null); //Não está no Bd não loga
    }
}
