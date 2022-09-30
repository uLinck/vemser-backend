import java.util.Scanner;

public class Atividade4 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int i = 0;


        int[] array = new int[3];

        for( i = 0; i < array.length; i++) {

            System.out.println("Digite o " + (i + 1) + "° numero:");
            array[i] = scan.nextInt();

        }
        System.out.println(array[i]);
        System.out.println("\nOrdem contrária:");

        for(int j = array.length - 1; j >= 0; j--) {

            System.out.println(array[j]);

        }

    }

}
