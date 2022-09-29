import java.net.IDN;
import java.util.Scanner;

public class Atividade10 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o número de identificação do aluno:");
        final int ID = scan.nextInt();

        System.out.println("\nDigite a primeira nota: ");
        double nota1 = scan.nextDouble();

        System.out.println("\nDigite a segunda nota: ");
        double nota2 = scan.nextDouble();

        System.out.println("\nDigite a terceira nota: ");
        double nota3 = scan.nextDouble();

        System.out.println("\nDigite a média de exercícios: ");
        double me = scan.nextDouble();

        float media = (float) (nota1 + nota2 * 2 + nota3 * 3 + me) / 7;


        if(media >= 9.0) {

            System.out.println("A");

        } else if(media >= 7.5) {

            System.out.println("B");

        } else if(media >= 6.0) {

            System.out.println("C");

        } else if(media >= 4.0) {

            System.out.println("D");

        } else {

            System.out.println("E");

        }

        String conceito = "";

        if(media >= 6.0) {

            conceito = "aprovado";

        } else {

            conceito = "reprovado";

        }


        System.out.println("Idenficação do aluno: " + ID +
                "\nNota 1: " + nota1 +
                "\nNota 2: " + nota2 +
                "\nNota 3: " + nota3 +
                "\nMédia dos exercícios: " + me +
                "\nMédia de Aproveitamento: " + media +
                "\nVeredito: " + conceito);


        scan.close();
    }
}