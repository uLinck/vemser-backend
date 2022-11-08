import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Atividade4 {
    public static void main(String[] args) {

        LocalDateTime event = LocalDateTime.of(2024, 9, 14, 18, 30);
        ZoneId london = ZoneId.of("Europe/London");
        ZonedDateTime zoned = ZonedDateTime.of(event, london);

        LocalDateTime date = LocalDateTime.now();

        long years = date.until(zoned, ChronoUnit.YEARS);
        long months = date.until(zoned, ChronoUnit.MONTHS);
        long days = date.until(zoned, ChronoUnit.DAYS);
        long hours = date.until(zoned, ChronoUnit.HOURS);
        long minutes = date.until(zoned, ChronoUnit.MINUTES);
        long seconds = date.until(zoned, ChronoUnit.SECONDS);

        System.out.println("Faltam: " +  years + " anos, " + months + " meses, " + days + " dias, \n" + hours + " horas, " + minutes + " minutos e " +
                seconds + " segundos para o evento do show do Wesley Safadãoo com a ilustre presença de Black Sabbath!!!");

    }
}
