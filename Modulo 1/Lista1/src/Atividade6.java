import java.util.Scanner;

public class Atividade6 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o total de eleitores do monicípio:");
        int eleitores = scan.nextInt();

        System.out.println("Informe a quantidade de votos brancos:");
        int branco = scan.nextInt();

        System.out.println("Informe a quantidade de votos nulos:");
        int nulo = scan.nextInt();

        System.out.println("Informe a quantidade de votos válidos");
        int valido = scan.nextInt();

        double votosBrancoPorcentual = ((double) branco / eleitores) * 100;
        System.out.println("Percentual de votos em brancos: " + votosBrancoPorcentual + "%");

        double votosNuloPorcentual = ((double) nulo / eleitores) * 100;
        System.out.println("Porcentual de votos nulos: " + votosNuloPorcentual + "%");

        double votosValidosPorcentual = ((double) valido / eleitores) * 100;
        System.out.println("Porcentual de votos válidos: " + votosValidosPorcentual + "%");


    }

}
