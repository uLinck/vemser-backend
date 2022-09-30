import java.util.Scanner;

public class Atividade5 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[][] array = new int[5][4];

        // 5 linhas, 4 colunas

        for (int aluno = 0; aluno < 5; aluno++) {

            for (int coluna = 0; coluna < 4; coluna++) {

                System.out.println("Aluno: " + (aluno + 1) + " | coluna: " + (coluna + 1));
                array[aluno][coluna] = scan.nextInt();

            }

        }

        double notaMaior = 0;
        double melhorMatric = 0;
        double media = 0;

        for (int i = 0; i < 5; i++) {

            do {
                int mediaProvas = array[i][1];
                int mediaTrabalhos = array[i][2];

                double notaFinal = (double) mediaProvas * 0.6 + (double) mediaTrabalhos * 0.4;

                media += notaFinal;

                if (notaFinal > notaMaior) {

                    notaMaior = notaFinal;
                    melhorMatric = array[i][0];

                }

                i++;

            } while (i < 5);


            System.out.println("Numero da matricula que obteve a maior nota: " + ((int) melhorMatric));

            media /= 5;

            System.out.println("A média das notas finais foi: " + media );

            scan.close();

        }

    }
}
