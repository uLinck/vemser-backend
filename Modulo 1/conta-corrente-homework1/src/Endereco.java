public class Endereco {

    public int tipo; // 1 - residencial, 2 - comercial
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public void imprimirEndereco() {

        System.out.println("País: " + pais
                + "\nEstado: " + estado
                + "\nCidade: " + cidade
                + "\nTipo de endereço: " + tipo
                + "\nNúmero do endereço: " + numero
                + "\nComplemento: " + complemento
                + "\nCEP: " + cep);

    }


}
