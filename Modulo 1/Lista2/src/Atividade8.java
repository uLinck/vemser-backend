import java.util.Scanner;

public class Atividade8 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int valor = 0;
        int valorIgual = 0;
        int valorMenor = 0;
        int valorMaior = 0;


        int [] array = { 3, 3, 3, 2, 5, 6, 8, 8, 9, 10 };

        System.out.println("Digite o valor: ");
        valor = scan.nextInt();


        for(int i = 0; i < array.length; i++) {
            if(array[i] == valor) {
                valorIgual++;
            }

            if(array[i] < valor) {
                valorMenor++;
            }

            if(array[i] > valor) {
                valorMaior++;
            }
        }

        System.out.println("\nQuantidade de numeros iguais ao valor informado: " + valorIgual
                + "\nQuantidade numeros menores ao valor informado: " + valorMenor
                + "\nQuantidade de numeros maiores ao valor informado: " + valorMaior);

    }

            Long asd = 100505l;



}
