import java.time.LocalDateTime;

public class Atividade3 {
    public static void main(String[] args) {
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataPos = dataAtual.plusDays(15).plusHours(10);

        System.out.println("Dia da semana daqui 15 dias: " + dataPos.getDayOfWeek());
        System.out.println("Dia do ano corrido: " + dataPos.getDayOfYear());
    }
}
