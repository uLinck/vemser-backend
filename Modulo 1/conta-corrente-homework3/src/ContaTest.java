import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {


    // SETUP



    // ACT



    // ASSERT


    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {


        // SETUP

        ContaCorrente conta = new ContaCorrente();
        conta.setSaldo(1000);


        // ACT

        boolean retorno = conta.sacar(1500);

        // ASSERT

        Assertions.assertFalse(retorno);


    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        // SETUP

        ContaPoupanca poupanca = new ContaPoupanca();
        poupanca.setSaldo(1000);

        // ACT

        boolean retorno = poupanca.sacar(800);

        // ASSERT

        Assertions.assertTrue(retorno);
        Assertions.assertEquals(200, poupanca.getSaldo());



    }

}
