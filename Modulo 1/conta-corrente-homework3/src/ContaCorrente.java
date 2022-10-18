public class ContaCorrente extends Conta implements Movimentacao, Impressao {


    private double chequeEspecial;

    // Valor do cheque especial único, ou seja, não será necessário o getter.

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }


    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;

    }

    public ContaCorrente() {}

    public double retornarSaldoComChequeEspecial() {

        double saldoTotal = this.getSaldo() + this.chequeEspecial;

        return saldoTotal;

    }


    public boolean sacar(double sacarValor) {

        if(retornarSaldoComChequeEspecial() >= sacarValor && sacarValor > 0  ) {

            System.out.println("\nSaldo antigo: R$" + getSaldo());

            this.setSaldo(this.getSaldo() - sacarValor);



            System.out.println("Valor inserido: R$" + sacarValor
                             + "\nSaldo atual: R$" + this.getSaldo());
            return true;
        }
        else {

            System.out.println("Não foi possível sacar pois não há saldo suficiente na conta."
                              +"\nSaldo da conta: R$" + this.getSaldo()
                              +"\nSaque solicitado: R$" + sacarValor);
            return false;
        }

    }

    @Override
    public void imprimir() {

        System.out.println("\nNúmero: " + this.getNumeroConta()
                + "\nAgência: " + this.getAgencia()
                + "\nSaldo: R$" + this.getSaldo()
                + "\nCheque especial: R$" + this.chequeEspecial);

    }
}
