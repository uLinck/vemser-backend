import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Atividade1 {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        System.out.println("Digite a data do seu aniversário no formato dd/mm/yyyy");
        String dataAniver = scan.nextLine();

        LocalDate dataFormatada = LocalDate.parse(dataAniver, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(LocalDate.now().getYear());
        LocalDate data = LocalDate.now();

        Period periodo = Period.between(data, dataFormatada.plusYears(1));

        System.out.println("Faltam " + periodo.getMonths() + " meses e " + periodo.getDays() + " dias para seu aniversário!");

    }
}