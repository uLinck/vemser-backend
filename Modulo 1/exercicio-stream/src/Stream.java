import java.util.*;
import java.util.stream.Collectors;


public class Stream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro Paulo", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Enzo", 2350, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

                //1- listar todas as pessoas

        System.out.println("[1] Listar pessoas da lista:\n");
        lista.stream()
                .forEach(pessoa -> System.out.println(pessoa.getNome()));

                //2- filtrar todas as pessoas com salario maior do que 5 mil (filter)

        System.out.println("\n[2] Listar pessoas com salario maior do que 5mil:\n");
        lista.stream()
                .filter(pessoa -> pessoa.salario > 5000)
                .forEach(pessoa -> System.out.println(pessoa.getNome()));


                //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)

        System.out.println("\n[3] Listar pessoas que são desenvolvedoras e organizar por salário crescente:\n");
        lista.stream()
                .filter(pessoa -> pessoa.cargo == "Desenvolvedor")
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .forEach(pessoa -> System.out.println(pessoa.getNome() + " -> R$" + pessoa.getSalario()));


                //4- fazer a média salarial de todos

        System.out.println("\n[4] Fazer a média salarial de todos\n");
        double media = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();
        System.out.println(media);


                //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil

        System.out.println("\n[5] Verificar se tem alguém que ganha mais do que 20mil\n");
        boolean rich = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() >= 20000);
        System.out.println(rich);
                //6- retornar uma lista de todos os ids das pessoas

        System.out.println("\n[6] retornar uma lista de todos os Ids das pessoas\n");
        List<Integer> filtrarId = lista.stream()
                .map(Pessoa::getId).collect(Collectors.toList());
                    System.out.println(filtrarId);

        //7- criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto

        System.out.println("\n[7] retornar uma lista de Salario\n");
        List<Salario> salarios = lista.stream()
                .map(pessoa -> new Salario(pessoa.getSalario(), pessoa.getId()))
                .toList();

        salarios.forEach(salario -> System.out.println("ID: " + salario.id + " -> R$" + salario.salario));



        //8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores

        System.out.println("\n[8] retornar uma HashMap de IDs e Nomes\n");

        Map<Integer, String> idsENomes = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(idsENomes);
//                .forEach(pessoa -> idsENomes.put(pessoa.getId(), pessoa.getNome()));
//        System.out.println(idsENomes);


        //9- com o mapa da 8, retornar o nome com o id=2

        System.out.println("\n[9] retornar o nome armazenado no id=2\n");
        System.out.println(idsENomes.get(2));
//               .filter(value -> value.getKey() == 2)
//               .forEach(value -> System.out.println(value.getValue()));

        //10- verificar se tem alguém que contenha o nome "Paulo" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).
        //    Imprimir o nome e salário dessa pessoa

        System.out.println("\n[10] Imprimir o nome e salário dessa pessoa\n");

//       Optional<Pessoa> possivelPessoa  = lista.stream()
//               .filter(pessoa -> pessoa.getNome().toLowerCase().contains("Paulo".toLowerCase()))
//               .findFirst();
//        //      .orElse(new Pessoa(0, "nenhum", 0, "Nenhum"));
//        System.out.println("Nome: " + possivelPessoa.get().getNome() + "\nSalário: R$" + possivelPessoa.get().getSalario());

        Pessoa possivelPessoa  = lista.stream()
                .filter(pessoa -> pessoa.getNome().toLowerCase().contains("Paulo".toLowerCase()))
                .findFirst()
                .orElse(new Pessoa(0, "Nenhum", 0, "Nenhum"));
        System.out.println("Nome: " + possivelPessoa.getNome() + "\nSalário: R$" + possivelPessoa.getSalario());


    }

    static class Salario {

        double salario;
        int id;

        public Salario(double salario, int id) {
            this.salario = salario;
            this.id = id;
        }
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }
    }
}