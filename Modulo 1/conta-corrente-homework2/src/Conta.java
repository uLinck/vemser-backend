 abstract class Conta {

    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

     public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {

         this.cliente = cliente;
         this.numeroConta = numeroConta;
         this.agencia = agencia;
         this.saldo = saldo;

     }


    // Getters & Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
