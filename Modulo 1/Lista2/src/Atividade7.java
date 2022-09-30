import java.util.Scanner;

public class Atividade7 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[][] array = new int[10][3];

        double[] mercadoMaisBaratoPorProduto = new double[10];
        double valorMenor = 0;


        for(int produto = 0; produto < 10; produto++) {

            for(int mercado = 0; mercado < 3; mercado++) {

                System.out.println("Qual o valor do "
                        + (produto + 1) + "° produto no "
                        + (mercado + 1) + "° mercado?");

                double valor = scan.nextDouble();

                if(valorMenor == 0) { valorMenor = valor; }

               if(valor < valorMenor) {

                   valorMenor = valor;

                   mercadoMaisBaratoPorProduto[produto] = mercado;

               }

            }

            System.out.println("\nO mercado mais barato do "
                    + (produto + 1) + "° produto é o "
                    + ((int) mercadoMaisBaratoPorProduto[produto] + 1 ) + "° mercado.\n");

        }

    }

}
