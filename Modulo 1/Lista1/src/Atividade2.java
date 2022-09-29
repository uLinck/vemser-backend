import java.util.Scanner;

public class Atividade2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Olá, digite o número correspondente ao estado desejado:"
                + "\n 1 - RS"
                + "\n 2 - SC"
                + "\n 3 - PR");
        String estado = scan.nextLine();

        switch(estado) { // switch para estados

            case "1":
                System.out.println("Informe a cidade desejada:" +
                        "\n1 - Porto Alegre" +
                        "\n2 - Gravatai");
                String cidadeRs = scan.nextLine();

                switch(cidadeRs) { // switch para cidades de RS
                    case "1":
                        System.out.println("Cidade selecionada: Porto Alegre" +
                                "\nPopulação: 1.409.351 habitantes." +
                                "\nÍndice de Desenvolvimento Humano: 0,805.");
                        break;

                    case "2":
                        System.out.println("Cidade selecionada: Gravatai" +
                                "\nPopulação: 285.564 habitantes " +
                                "\nÍndice de Desenvolvimento Humano: 0,862.");
                        break;

                }

                break;

            case "2":
                System.out.println("Informe a cidade desejada:" +
                        "\n1 - Florianópolis" +
                        "\n2 - Balneário Camboriú");
                String cidadeSC = scan.nextLine();

                    switch(cidadeSC) { // Switch para cidades de SC

                        case "1":
                            System.out.println("Cidade selecionada: Florianópolis " +
                                    "\nPopulação: 508.826 habitantes. " +
                                    "\nÍndice de Desenvolvimento Humano: 0,847.");
                            break;

                        case "2":
                            System.out.println("Cidade selecionada: Balneário Camboriú " +
                                    "\nPopulação: 145.796 habitantes. " +
                                    "\nÍndice de Desenvolvimento Humano: 0,845.");
                            break;

                    }

                break;

            case "3":
                System.out.println("Informe a cidade desejada:" +
                        "\n1 - Curitiba" +
                        "\n2 - Londrina");
                String cidadePR = scan.nextLine();

                switch(cidadePR) { // Switch para cidades de PR

                    case "1":
                        System.out.println("Cidade selecionada: Curitiba " +
                                "\nPopulação: 1.776.761 habitantes." +
                                "\nÍndice de Desenvolvimento Humano: 0,733.");
                        break;

                    case "2":
                        System.out.println("Cidade selecionada: Londrina " +
                                "\nPopulação: 575.377 habitantes. " +
                                "\nÍndice de Desenvolvimento Humano: 0,824.");
                        break;

                }

                break;
        }








    }
}
