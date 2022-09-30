import java.util.Scanner;

public class Atividade2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha um número: ");
        int num1 = scan.nextInt();

        System.out.println("Adivinhe o número: ");
        int adivinha = scan.nextInt();

        while(adivinha != num1) {

            if(adivinha < num1) {

                System.out.println("\nO número adivinhado é menor que o número informado!");
                System.out.println("Adivinhe novamente o número: ");
                adivinha = scan.nextInt();

            }
            else if(adivinha > num1) {

                System.out.println("\nO número adivinhado é maior que o número informado!");
                System.out.println("Adivinhe novamente o número: ");
                adivinha = scan.nextInt();

            }

            System.out.println("\nParabéns, você acertou!");


        }




    }

}
