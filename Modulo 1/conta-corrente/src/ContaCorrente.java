public class ContaCorrente {

    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public boolean sacarVerify;
    public boolean transferirVerify;

    public boolean depositarVerify;

    public void imprimirContaCorrente() {

        System.out.println("\nInformações da Conta Corrente:"
        + "\nCliente: " + cliente.nome
        + "\nNúmero: " + numeroConta
        + "\nAgência: " + agencia
        + "\nSaldo: R$" + saldo
        + "\nCheque especial: R$" + chequeEspecial);

    }

    public boolean sacar(double sacarValor) {

        if(this.retornarSaldoComChequeEspecial() >= sacarValor && sacarValor > 0  ) {

            System.out.println("\nSaque realizado com sucesso!"
                             + "\nSaldo antigo: R$" + this.saldo);

            this.saldo -= sacarValor;

            sacarVerify = true;

            System.out.println("Valor sacado: R$" + sacarValor
                    + "\nSaldo atual: R$" + this.saldo);
        } else {
            sacarVerify = false;

            System.out.println("Não foi possível sacar pois não há saldo suficiente na conta."
                              +"\nSaldo da conta: R$" + this.saldo
                              +"\nSaque solicitado: R$" + sacarValor);
        }

        return sacarVerify;
    }

    public boolean depositar(double depositarValor) {

        if(depositarValor > 0) {

            this.saldo += depositarValor;
            sacarVerify = true;

            System.out.println("Depósito realizado com sucesso!"
                    + "\nValor depositado: R$" + depositarValor
                    + "\nSaldo atual: R$" + this.saldo);


        } else {

            sacarVerify = false;
            System.out.println("Valor de depósito inválido.");

        }

        return sacarVerify;
    }

    public double retornarSaldoComChequeEspecial() {

        return this.saldo + this.chequeEspecial;

    }

    public boolean transferir(ContaCorrente conta, double valor) {

        if(this.retornarSaldoComChequeEspecial() >= valor && valor > 0) {

            this.saldo -= valor;
            conta.depositar(valor);
            transferirVerify = true;

        } else {

            System.out.println("Erro na transferência");
            transferirVerify = false;

        }
        return transferirVerify;
    }


}
