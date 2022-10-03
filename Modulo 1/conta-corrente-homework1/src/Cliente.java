public class Cliente {

    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];


    public void imprimirContatos() {

        System.out.println("\nContatos de " + this.nome + ": ");

        for(int i = 0; i < contatos.length; i++) {

            if(contatos[i] != null) {

                System.out.println("\nInformações do " + (i + 1)+ "° contato:");
                contatos[i].imprimirContato();


            }

        }


    }

    public void imprimirEnderecos() {

        System.out.println("\nEndereços de " + this.nome + ": ");

        for(int i = 0; i < enderecos.length; i++) {


            if(enderecos[i] != null) {

                System.out.println("\nInformações do " + (i + 1)+ "° endereço:");
                enderecos[i].imprimirEndereco();


            }

        }

    }

    public void imprimirCliente() {

        System.out.println("Informações do Cliente:"
        + "\nNome: " + this.nome
        + "\nCPF: " + this.cpf);

    }


}
