import java.util.Scanner;

public class Atividade6 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[][] array = new int[5][4];
        int notaTotal = 0;
        int[] mediaDisciplinas = new int[5];

        for (int disciplina = 0; disciplina < 5; disciplina++) {


            for (int notas = 0; notas < 4; notas++) {

                System.out.println((disciplina + 1) + "° Disciplina" + " | notas: " + (notas + 1));
                array[disciplina][notas] = scan.nextInt();

                notaTotal += array[disciplina][notas];
                mediaDisciplinas[disciplina] += array[disciplina][notas];

            }

        }

        notaTotal /= 20;
        int i = 0;

        for(int mediaDisciplina: mediaDisciplinas) {

            mediaDisciplina /= 4;

            i++;

            System.out.println("Média da " + (i) +  "° disciplina: " + mediaDisciplina);

        }

        System.out.println("\nMédia geral obtida pelo aluno: " + notaTotal);
    }

}
