public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        cliente1.nome = "Reginaldo";
        cliente1.cpf = "053.960.789-75";

        Contato contatoReginaldo1 = new Contato();
        contatoReginaldo1.tipo = 1;
        contatoReginaldo1.telefone = "051995505706";
        contatoReginaldo1.descricao = "Pessoa feliz";

        Contato contatoReginaldo2 = new Contato();
        contatoReginaldo2.tipo = 2;
        contatoReginaldo2.telefone = "051994560675";
        contatoReginaldo2.descricao = "Pessoa mais ou menos feliz";

        Endereco enderecoReginaldo1 = new Endereco();
        enderecoReginaldo1.tipo = 1;
        enderecoReginaldo1.cep = "94040-000";
        enderecoReginaldo1.pais = "Brasil";
        enderecoReginaldo1.estado = "RS";
        enderecoReginaldo1.cidade = "Gravataí";
        enderecoReginaldo1.logradouro = "São Jerônimo";
        enderecoReginaldo1.numero = 3520;
        enderecoReginaldo1.complemento = "Bloco B";

        Endereco enderecoReginaldo2 = new Endereco();
        enderecoReginaldo2.tipo = 2;
        enderecoReginaldo2.cep = "40028-922";
        enderecoReginaldo2.pais = "Brasil";
        enderecoReginaldo2.estado = "RS";
        enderecoReginaldo2.cidade = "Porto Alegre";
        enderecoReginaldo2.logradouro = "Beco Três";
        enderecoReginaldo2.numero = 666;
        enderecoReginaldo2.complemento = "Bairro Passo Fino";

        cliente1.enderecos[0] = enderecoReginaldo1;
        cliente1.enderecos[1] = enderecoReginaldo2;

        cliente1.contatos[0] = contatoReginaldo1;
        cliente1.contatos[1] = contatoReginaldo2;

//        Testes do metodos da classe Cliente1
//        cliente1.imprimirCliente();
//        cliente1.imprimirContatos();
//        cliente1.imprimirEnderecos();
//
// ----------------------------------------------

        Cliente cliente2 = new Cliente();
        cliente2.nome = "Bruno";
        cliente2.cpf = "052.734.802-43";

        Contato contatoBruno1 = new Contato();
        contatoBruno1.tipo = 1;
        contatoBruno1.telefone = "051875478654";
        contatoBruno1.descricao = "Pessoa triste";

        Contato contatoBruno2 = new Contato();
        contatoBruno2.tipo = 2;
        contatoBruno2.telefone = "051998735098";
        contatoBruno2.descricao = "Pessoa mais ou menos triste";

        Endereco enderecoBruno1 = new Endereco();
        enderecoBruno1.tipo = 1;
        enderecoBruno1.cep = "94324-040";
        enderecoBruno1.pais = "Brasil";
        enderecoBruno1.estado = "RS";
        enderecoBruno1.cidade = "Gravataí";
        enderecoBruno1.logradouro = "Morungava";
        enderecoBruno1.numero = 876;
        enderecoBruno1.complemento = "Bairro São Geraldo";

        Endereco enderecoBruno2 = new Endereco();
        enderecoBruno2.tipo = 2;
        enderecoBruno2.cep = "67430-932";
        enderecoBruno2.pais = "Brasil";
        enderecoBruno2.estado = "RS";
        enderecoBruno2.cidade = "Porto Alegre";
        enderecoBruno2.logradouro = "Beco Dois";
        enderecoBruno2.numero = 231;
        enderecoBruno2.complemento = "Bairro Mato Fino";

        cliente2.enderecos[0] = enderecoBruno1;
        cliente2.enderecos[1] = enderecoBruno2;

        cliente2.contatos[0] = contatoBruno1;
        cliente2.contatos[1] = contatoBruno2;

 //       Testes do metodos da classe Cliente2:
 //       cliente2.imprimirCliente();
//        cliente2.imprimirContatos();
//        cliente2.imprimirEnderecos();
//
// ----------------------------------------------

        ContaCorrente contaCliente1 = new ContaCorrente();

        contaCliente1.cliente = cliente1;
        contaCliente1.numeroConta = "537289-1";
        contaCliente1.agencia = 1579;
        contaCliente1.saldo = 500.00;
        contaCliente1.chequeEspecial = 1000.00;

        ContaCorrente contaCliente2 = new ContaCorrente();

        contaCliente2.cliente = cliente2;
        contaCliente2.numeroConta = "842746-2";
        contaCliente2.agencia = 3261;
        contaCliente2.saldo = 200.00;
        contaCliente2.chequeEspecial = 700.00;
// ----------------------------------------------
        System.out.println("\n------------------------------");

        System.out.println("\nImprimindo dados da conta Cliente1\n");
        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();
        contaCliente1.imprimirContaCorrente();

        System.out.println("\n------------------------------\n");

        System.out.println("\nImprimindo dados da conta Cliente2\n");
        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEnderecos();
        contaCliente2.imprimirContaCorrente();

        System.out.println("\n------------------------------\n");

        System.out.println("\nTeste de transferência:");

        System.out.println("\nSaldo de " + cliente1.nome + ": R$" + contaCliente1.saldo);
        System.out.println("Saldo de " + cliente2.nome + ": R$" + contaCliente2.saldo + "\n");
        contaCliente1.transferir(contaCliente2, 50);
        System.out.println("\nSaldo novo de " + cliente1.nome + ": R$" + contaCliente1.saldo);
        System.out.println("Saldo novo: de " + cliente2.nome + ": R$" + contaCliente2.saldo);

        System.out.println("\n------------------------------\n");

    }
}