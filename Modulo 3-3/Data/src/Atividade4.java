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

        LocalDateTime now = LocalDateTime.now();

        long years = ChronoUnit.YEARS.between(now, zoned);
        now = now.plusYears(years);
        long months = ChronoUnit.MONTHS.between(now, zoned);
        now = now.plusMonths(months);
        long days = ChronoUnit.DAYS.between(now, zoned);
        now = now.plusDays(days);
        long hours = ChronoUnit.HOURS.between(now, zoned);
        now = now.plusHours(hours);
        long minutes = ChronoUnit.MINUTES.between(now, zoned);
        now = now.plusMinutes(minutes);
        long seconds = ChronoUnit.SECONDS.between(now, zoned);
        now = now.plusSeconds(seconds);

        System.out.println("Faltam: \n" +  years + " anos, " + months + " meses, " + days + " dias, " + hours + " horas, " + minutes + " minutos e " +
                seconds + " segundos para o evento do show do Wesley Safadãoo com a ilustre presença de Black Sabbath!!!");

    }
}
