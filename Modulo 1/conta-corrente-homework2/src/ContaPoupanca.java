public class ContaPoupanca extends Conta implements impressao {

     static final double JUROS_MENSAL = 1.01;


     double saldoTotal;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }


    public void creditarTaxa() {

         saldoTotal = this.getSaldo() * JUROS_MENSAL;

     }

    @Override
    public void imprimir() {

        System.out.println("O novo saldo da poupança é: R$" + this.saldoTotal);

    }
}
