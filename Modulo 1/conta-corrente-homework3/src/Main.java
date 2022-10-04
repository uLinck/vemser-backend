import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Reginaldo", "053.654.876-76");
        ContaCorrente contaCliente1 = new ContaCorrente(cliente1, "537289-1", "1579", 2000, 1000);
        ContaPagamento pagamentoContaCliente1 = new ContaPagamento(cliente1, "0000002-1", "1111", 300);

        Contato contatoReginaldo1 = new Contato("Pessoa Feliz", "051995505706", 1);

        Contato contatoReginaldo2 = new Contato("Pessoa mais ou menos feliz","051994560675", 2);


        Endereco enderecoReginaldo1 = new Endereco(1,"São Jerônimo", 3520, "Bloco B", "94040-000", "Gravataí", "RS", "Brasil");
        Endereco enderecoReginaldo2 = new Endereco(2, "Beco Três", 666, "Bairro Passo Fino", "40028-922", "Porto Alegre", "RS", "Brasil");

        cliente1.setContatos(Arrays.asList(contatoReginaldo1, contatoReginaldo2));
        cliente1.setEnderecos(Arrays.asList(enderecoReginaldo1, enderecoReginaldo2));

// ----------------------------------------------

        Cliente cliente2 = new Cliente("Bruno", "052.734.802-43");
        ContaPoupanca poupancaCliente2 = new ContaPoupanca(cliente2, "537009-1", "2222", 100);

        Contato contatoBruno1 = new Contato("Pessoa triste", "051875478654", 1);
        Contato contatoBruno2 = new Contato("Pessoa mais ou menos triste", "051998735098", 2);

        Endereco enderecoBruno1 = new Endereco(1,"Morungava", 876, "Bairro São Geraldo", "94324-040", "Gravataí", "RS", "Brasil");
        Endereco enderecoBruno2 = new Endereco(2, "Beco Dois", 231, "Bairro Mato Fino", "67430-932", "Porto Alegre", "RS", "Brasil");


        cliente2.setContatos(Arrays.asList(contatoBruno1, contatoBruno2));
        cliente2.setEnderecos(Arrays.asList(enderecoBruno1, enderecoBruno2));

// -----------------------------------------------
        System.out.println("\n------------------------------");

        System.out.println("\nImprimindo dados da conta Cliente1\n");
        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();
        contaCliente1.imprimir();

        System.out.println("\n------------------------------\n");

//        testes dos dados do Cliente2 que comentei pois não é necessário.
//
//        System.out.println("\nImprimindo dados da conta Cliente2\n");
//        cliente2.imprimirCliente();
//        cliente2.imprimirContatos();
//        cliente2.imprimirEnderecos();
//        contaCliente2.imprimir();
//
//        System.out.println("\n------------------------------\n");

        System.out.println("\nTeste de saque da conta Cliente 1.");

        contaCliente1.imprimir();
        contaCliente1.sacar(1000);
        System.out.println("------------------------------");
        System.out.println("\nTeste de saque da conta pagamento do Cliente 1.");

        pagamentoContaCliente1.imprimir();
//        pagamentoContaCliente1.sacar(300); // saque não efetuado
        pagamentoContaCliente1.sacar(50);
        pagamentoContaCliente1.imprimir();
        System.out.println("------------------------------");
        System.out.println("\nTeste de saque da conta poupança do cliente 2.");

        poupancaCliente2.imprimir();
        poupancaCliente2.depositar(50);
        poupancaCliente2.imprimir();

        System.out.println("\n -------------------------------");
        System.out.println("\nValores antes do teste");
        System.out.println("\nConta corrente cliente1");
        contaCliente1.imprimir();
        System.out.println("\nConta pagamento cliente1");
        pagamentoContaCliente1.imprimir();
        System.out.println("Conta poupança cliente2");
        poupancaCliente2.imprimir();
        System.out.println("\n -------------------------------");
        contaCliente1.depositar(10);
        pagamentoContaCliente1.depositar(100);
        poupancaCliente2.depositar(100);
        poupancaCliente2.transferir(pagamentoContaCliente1, 100);

        System.out.println("\nValores depois do teste");
        System.out.println("\nConta corrente cliente1");
        contaCliente1.imprimir();
        System.out.println("\nConta pagamento cliente1");
        pagamentoContaCliente1.imprimir();
        System.out.println("Conta poupança cliente2");
        poupancaCliente2.imprimir();



        System.out.println("\n------------------------------\n");
    }
}