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

    public double retornarSaldoComChequeEspecial() {

        double saldoTotal = this.getSaldo() + this.chequeEspecial;

        return saldoTotal;

    }


    public boolean sacar(double sacarValor) {

        if(retornarSaldoComChequeEspecial() >= sacarValor && sacarValor > 0  ) {

            System.out.println("\nSaque realizado com sucesso!"
                             + "\nSaldo antigo: R$" + getSaldo());

            this.setSaldo(this.getSaldo() - sacarValor);



            System.out.println("Valor sacado: R$" + sacarValor
                             + "Saldo atual: R$" + this.getSaldo());
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
    public boolean depositar(double valor) {

        if(valor >= 0) {

            this.setSaldo(this.getSaldo() + valor);

            System.out.println("Depósito realizado com sucesso!"
                             + "\nValor depositado: R$" + valor
                             + "\nSaldo atual: R$" + this.getSaldo());

            return true;
        } else {
            System.out.println("Valor inserido inválido!");
            return false;
        }

    }

    @Override
    public boolean transferir(ContaCorrente conta, double valor) {

        if(conta.getSaldo() >= valor && valor > 0) {

            this.setSaldo(this.getSaldo() - valor);

            conta.depositar(valor);

            return true;

        } else {
            System.out.println("Erro na transferência!");
            return false;
        }
    }

    @Override
    public void imprimir() {

        System.out.println("\nInformações da Conta Corrente:"
                + "\nCliente: " + this.getCliente()
                + "\nNúmero: " + this.getNumeroConta()
                + "\nAgência: " + this.getAgencia()
                + "\nSaldo: R$" + this.getSaldo()
                + "\nCheque especial: R$" + this.chequeEspecial);

    }
}
