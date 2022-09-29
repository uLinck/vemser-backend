import java.util.Scanner;

public class Atividade1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe seu nome:");
        String nome = scan.nextLine();

        System.out.println("Informe sua idade:");
        int idade = scan.nextInt(); scan.nextLine();

        System.out.println("Informe seu estado:");
        String estado = scan.nextLine();

        System.out.println("Informe sua cidade");
        String cidade = scan.nextLine();

        System.out.printf("Olá instrutor! \nSeu nome é %s, você tem %d anos e é da cidade %s situada no estado de %s.",
                nome, idade, cidade, estado);


    }
}
