public class Contato {

    public String descricao;
    public String telefone;
    public int tipo; // 1- residencial, 2- comercial

    public void imprimirContato() {

        System.out.println("Descrição: " +  this.descricao
                + "\nNúmero de telefone: " + this.telefone
                + "\nTipo de telefone: " + tipo );

    }

}
