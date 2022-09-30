import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\nOlá, bem vindo ao programa que lhe entregará uma tabela com os " +
                "dados informados de um jogador. " +
                "\nCaso queira sair, digite: \"sair\".");

        int quantidade = 0;
        String nome = "";
        double alturaMaior = 0.0;
        double pesoMaior = 0.0;
        double idadeMaior = 0.0;
        double media = 0.0;



        while(true) {

            System.out.println("\nInforme os dados do " +  (quantidade + 1) +  "°" + " jogador:");

            System.out.println("Nome:");
            nome = scan.nextLine();

            if(nome.equals("sair")) {
                break;
            }

            System.out.println("\nAltura:");
            double altura = scan.nextDouble();


            if(altura > alturaMaior) {

               alturaMaior = altura;

            }

            System.out.println("\nIdade:");
            int idade = scan.nextInt();

            if(idade > idadeMaior) {

                idadeMaior = idade;

            }

            System.out.println("\nPeso:");
            double peso = scan.nextDouble(); scan.nextLine();

            if(peso > pesoMaior) {

                pesoMaior = peso;

            }

            quantidade++;
            media += altura;
        }

        System.out.println("Quantidade de jogadores cadastrados: " + quantidade + "." +
                "\nAltura do maior jogador: " + alturaMaior +
                "\nJogador mais velho: " + idadeMaior +
                "\nJogador mais pesado: " + pesoMaior +
                "\nMédia das alturas jogadores: " + (media / quantidade));


    }

}
