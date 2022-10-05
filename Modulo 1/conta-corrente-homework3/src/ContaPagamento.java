public class ContaPagamento extends Conta implements Impressao {


    final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public boolean sacar(double valor) {
        if (valor > 0 && (valor + TAXA_SAQUE) <= getSaldo()) {
            setSaldo((getSaldo() - (valor + TAXA_SAQUE)));
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean transferir(Conta conta, double valor) {
        if ((valor) <= getSaldo()){
            setSaldo(getSaldo() - valor);
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimir() {

        System.out.println("Saldo da conta pagamento: R$" + this.getSaldo());
    }
}
