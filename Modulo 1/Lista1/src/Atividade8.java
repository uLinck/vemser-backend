import java.util.Scanner;

public class Atividade8 {

    public static void main(String[] args) {

        // novos salarios: Gerente 10% | Engenheiro 20% | Técnico 30%

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o Salário do funcionário: ");
        double salario = scan.nextDouble(); scan.nextLine();

        System.out.println("Informe o cargo desse funcionário:");
        String cargo = scan.nextLine().toLowerCase();

        double salNovo = 0;

        switch(cargo) {

            case "gerente":
                salNovo = salario + (salario * 0.10);
                break;

            case "engenheiro":
                salNovo = salario + (salario * 0.20);
                break;

            case "técnico":
                salNovo = salario + (salario * 0.30);
                break;

            default:
                salNovo = salario + (salario * 0.40);
        }

        System.out.println("Salário antigo: R$" + salario +
                "\nSalário novo: R$" + salNovo +
                "\nDiferença: R$" + (salNovo - salario));


    }

}
