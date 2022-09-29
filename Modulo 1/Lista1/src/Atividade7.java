import java.util.Scanner;

public class Atividade7 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o código do produto que deseja comprar presente na tabela: " +
                "\n\"ABCD\" = R$5,30" +
                "\n\"XYPK\" = R$ 6,00" +
                "\n\"KLMP\" = R$ 3,20" +
                "\n\"QRST\" = R$ 2,50");

        String tabela = scan.nextLine();

        System.out.println("Qual a quantidade que deseja comprar?");
        int quantidade = scan.nextInt();

        double preco = 0;

        switch(tabela) {

            case "ABCD":
                preco = 5.30 * quantidade;

                break;

            case "XYPK":
                preco = 6.00 * quantidade;

                break;

            case "KLMP":
                preco = 3.20 * quantidade;

                break;

            case "QRST":
                preco = 2.50 * quantidade;

                break;

            default:
                System.out.println("Código inválido");
        }

        System.out.println("Preço total: R$" + preco);

    }
}
