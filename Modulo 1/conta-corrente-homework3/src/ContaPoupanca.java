public class ContaPoupanca extends Conta implements Impressao {

    static final double JUROS_MENSAL = 1.01;



    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }


    public void creditarTaxa() {

        super.setSaldo(this.getSaldo() * JUROS_MENSAL);

    }

    @Override
    public void imprimir() {

        System.out.println("O saldo atual da conta poupança é: R$" + this.getSaldo());

    }
}
