import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe a primeira data:");
        LocalDate firstDate = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Informe a segunda data:");
        LocalDate secondDate = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Period period = Period.between(firstDate, secondDate);
        System.out.println("Diferença de " + period.getYears() + " anos, " + period.getMonths() + " meses e " + period.getDays() + " dias.");

    }
}
