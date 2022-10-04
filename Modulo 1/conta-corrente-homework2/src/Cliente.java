public class Cliente {

    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf) {

        this.nome = nome;
        this.cpf = cpf;

    }
    public void imprimirContatos() {

        System.out.println("\nContatos de " + this.getNome() + ": ");

        if(contatos != null) {

            for (int i = 0; i < this.getContatos().length; i++) {

                if (this.getContatos()[i] != null) {
                    System.out.println("\nInformações do " + (i + 1) + "° contato:");
                    this.getContatos()[i].imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {

        System.out.println("\nEndereços de " + this.getNome() + ": ");

        if(enderecos != null) {

            for (int i = 0; i < this.getEnderecos().length; i++) {

                if (this.getEnderecos()[i] != null) {
                    System.out.println("\nInformações do " + (i + 1) + "° endereço:");
                    this.getEnderecos()[i].imprimirEndereco();
                }
            }
        }
    }

    public void imprimirCliente() {

        System.out.println("Informações do Cliente:"
        + "\nNome: " + getNome()
        + "\nCPF: " + getCpf());

    }


    // Getters & Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }
}
