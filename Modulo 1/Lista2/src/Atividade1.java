import java.util.Scanner;

public class Atividade1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o nome do produto desejado: ");
        String produto = scan.nextLine();

        System.out.println("Informe o valor do produto desejado: ");
        double valor = scan.nextDouble();

        double[] array = new double[10];

        double desconto = 0.05;

        System.out.println("\nProduto: " + produto +
                "\nPreço R$" + String.format("%.2f", valor) +
                "\nPromoção: " + produto +
                "\n-------------------");


        for(int i = 0; i < array.length; i++) {

            double calcDesconto = 0.05;

            array[i] = valor - (valor * desconto);

            desconto += calcDesconto;


            System.out.println((i + 1) + " x R$" + String.format("%.2f", array[i])
                    + " = R$" + String.format("%.2f", (array[i] * (i + 1))));

        }


    }

}
