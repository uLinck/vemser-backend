import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a palavra gostaria de traduzir:\n"
                + "(Cachorro) "
                + "(Tempo) - "
                + "(Amor) - "
                + "(Cidade) - "
                + "(Feliz) - "
                + "(Triste) - "
                + "(Deveria) - "
                + "(Poderia)\n"
                + "(Dog) - "
                + "(Time) - "
                + "(Love) - "
                + "(city) - "
                + "(Happy) - "
                + "(Sad) - "
                + "(Shoud) - "
                + "(Could) ");
        String word = scan.nextLine().toLowerCase();

        switch (word) {
            case "dog": word = "Cachorro";
                System.out.println(word);
                break;
            case "cachorro": word = "Dog";
                System.out.println(word);
                break;
            case "tempo": word = "Time";
                System.out.println(word);
                break;
            case "time": word = "Tempo";
                System.out.println(word);
                break;
            case "amor": word = "Love";
                System.out.println(word);
                break;
            case "love": word = "Amor";
                System.out.println(word);
                break;
            case "cidade": word = "City";
                System.out.println(word);
                break;
            case "city": word = "Cidade";
                System.out.println(word);
                break;
            case "feliz": word = "Happy";
                System.out.println(word);
                break;
            case "happy": word = "Feliz";
                System.out.println(word);
                break;
            case "triste": word = "Sad";
                System.out.println(word);
                break;
            case "sad": word = "Triste";
                System.out.println(word);
                break;
            case "deveria": word = "Shoud";
                System.out.println(word);
                break;
            case "shoud": word = "Deveria";
                System.out.println(word);
                break;
            case "poderia": word = "Could";
                System.out.println(word);
                break;
            case "could": word = "Poderia";
                System.out.println(word);
                break;
            default:
                System.out.println("Essa palavra não é valida");
        }

        scan.close();
    }
}