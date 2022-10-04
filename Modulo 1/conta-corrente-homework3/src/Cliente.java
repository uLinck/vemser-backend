import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente(String nome, String cpf) {

        this.nome = nome;
        this.cpf = cpf;

    }
    public void imprimirContatos() {

        System.out.println("\nContatos de " + this.getNome() + ": ");

        if(contatos != null) {

            for (int i = 0; i < this.contatos.size(); i++) {

                if (this.contatos.get(i) != null) {
                    System.out.println("\nInformações do " + (i + 1) + "° contato:");
                    this.contatos.get(i).imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {

        System.out.println("\nEndereços de " + this.getNome() + ": ");

        if(enderecos != null) {

            for (int i = 0; i < this.enderecos.size(); i++) {

                if (this.enderecos.get(i) != null) {
                    System.out.println("\nInformações do " + (i + 1) + "° endereço:");
                    this.enderecos.get(i).imprimirEndereco();
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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
