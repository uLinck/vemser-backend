public class ContaPagamento extends Conta implements Impressao {


    final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo((getSaldo() - valor));

            if (getSaldo() >= TAXA_SAQUE) {
                setSaldo((getSaldo() - TAXA_SAQUE));
            } else {
                System.out.println("Saque não efetuado pois o valor atual da conta é menor que a taxa de saque.");
                return false;
            }


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
