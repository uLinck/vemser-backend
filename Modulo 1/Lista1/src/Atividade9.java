import java.util.Scanner;

public class Atividade9 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int horaInicio, horaFim, minInicio, minFim;



        do {

            System.out.println("Informe a hora de início:");
            horaInicio = scan.nextInt();

            if(horaInicio > 24) {
                System.out.println("Você digitou uma hora inválida!\n");
            }

        } while (horaInicio > 24);

        do {

            System.out.println("Informe os minutos de início");
            minInicio = scan.nextInt();

            if(minInicio > 59) {
                System.out.println("Você digitou minutos inválidos!\n");
            }

        } while (minInicio > 59);
        System.out.println("Obrigado!");

        do {

            System.out.println("Agora, informe a hora final");
            horaFim = scan.nextInt();

            if(horaFim > 24) {
                System.out.println("Você digitou uma hora inválida!\n");
            }

        } while(horaFim > 24);

        do {

            System.out.println("Informe os minutos finais");
            minFim = scan.nextInt();

            if(minFim > 59) {
                System.out.println("Você digitou minutos inválidos\n");
            }

        } while(minFim > 59);

        int duracaoHora = horaFim - horaInicio;
        int duracaoMin = minFim - minInicio;


        if(horaFim <= horaInicio)
        {
            duracaoHora = horaFim - horaInicio + 24;
        }

        if (duracaoMin < 0)
        {

            duracaoHora = duracaoHora - 1;
            duracaoMin = 60 - (- duracaoMin);

        }

        System.out.println("Duração: " + duracaoHora + " horas e " + duracaoMin + " minutos.");



    }

}
