public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Reginaldo", "053.654.876-76");

        Contato contatoReginaldo1 = new Contato("Pessoa Feliz", "051995505706", 1);

        Contato contatoReginaldo2 = new Contato("Pessoa mais ou menos feliz","051994560675", 2);


        Endereco enderecoReginaldo1 = new Endereco(1,"São Jerônimo", 3520, "Bloco B", "94040-000", "Gravataí", "RS", "Brasil");
        Endereco enderecoReginaldo2 = new Endereco(2, "Beco Três", 666, "Bairro Passo Fino", "40028-922", "Porto Alegre", "RS", "Brasil");

        cliente1.setEnderecos(new Endereco[] {enderecoReginaldo1, enderecoReginaldo2});
        cliente1.setContatos(new Contato[] {contatoReginaldo1, contatoReginaldo2});

// ----------------------------------------------

        Cliente cliente2 = new Cliente("Bruno", "052.734.802-43");


        Contato contatoBruno1 = new Contato("Pessoa triste", "051875478654", 1);
        Contato contatoBruno2 = new Contato("Pessoa mais ou menos triste", "051998735098", 2);

        Endereco enderecoBruno1 = new Endereco(1,"Morungava", 876, "Bairro São Geraldo", "94324-040", "Gravataí", "RS", "Brasil");

        Endereco enderecoBruno2 = new Endereco(2, "Beco Dois", 231, "Bairro Mato Fino", "67430-932", "Porto Alegre", "RS", "Brasil");

        cliente2.setEnderecos(new Endereco[] {enderecoBruno1, enderecoBruno2});

        cliente2.setContatos(new Contato[] {contatoBruno1, contatoBruno2});

        ContaCorrente contaCliente1 = new ContaCorrente(cliente1, "537289-1", "1579", 500, 1000);
        ContaCorrente contaCliente2 = new ContaCorrente(cliente2, "842746-2", "3261", 200, 700);

        ContaPoupanca poupancaCliente1 = new ContaPoupanca(cliente1, "537009-1", "1111", 100);
        ContaPoupanca poupancaCliente2 = new ContaPoupanca(cliente2, "842006-2", "2222", 100);

// -----------------------------------------------
        System.out.println("\n------------------------------");

        System.out.println("\nImprimindo dados da conta Cliente1\n");
        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();
        contaCliente1.imprimir();

        System.out.println("\n------------------------------\n");

        System.out.println("\nImprimindo dados da conta Cliente2\n");
        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEnderecos();
        contaCliente2.imprimir();

        System.out.println("\n------------------------------\n");

        System.out.println("\nTeste de transferência:");

        System.out.println("\nSaldo de " + cliente1.getNome() + ": R$" + contaCliente1.getSaldo());
        System.out.println("Saldo de " + cliente2.getNome() + ": R$" + contaCliente2.getSaldo() + "\n");
        contaCliente1.transferir(contaCliente2, 50);
        System.out.println("\nSaldo novo de " + cliente1.getNome() + ": R$" + contaCliente1.getSaldo());
        System.out.println("Saldo novo: de " + cliente2.getNome() + ": R$" + contaCliente2.getSaldo());

        System.out.println("\n------------------------------\n");

        // teste feito apenas com um cliente pois seguem o mesmo modelo.

        poupancaCliente1.imprimir();
        poupancaCliente1.creditarTaxa();
        poupancaCliente1.imprimir();

        System.out.println("\n------------------------------\n");
    }
}