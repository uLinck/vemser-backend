import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");
        MongoCollection<Document> alunos = mongoDatabase.getCollection("alunos");
        MongoCollection<Document> orders = mongoDatabase.getCollection("orders");
        // Novo aluno
        Document aluno1 = new Document("nome", "Noah")
                //.append("_id", 4)
                .append("data_nascimento", new Date(2003, 12, 11))
                .append("curso", new Document("nome", "Historia"))
                .append("notas", Arrays.asList(10, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                                .append("nome", "Ingles ")
                                .append("nível", "Básico"),
                        new Document()
                                .append("nome", "Espanhol")
                                .append("nível", "Básico")));

        Document aluno2 = new Document("nome", "Gustavo Linck")
                //.append("_id", 4)
                .append("data_nascimento", new Date(2000, 07, 13))
                .append("curso", new Document("nome", "Computação"))
                .append("notas", Arrays.asList(10, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                                .append("nome", "Ingles ")
                                .append("nível", "Avancado"),
                        new Document()
                                .append("nome", "Espanhol")
                                .append("nível", "Intermediario")));

        Document aluno3 = new Document("nome", "Felipe")
                //.append("_id", 4)
                .append("data_nascimento", new Date(2002, 11, 13))
                .append("curso", new Document("nome", "Portugues"))
                .append("notas", Arrays.asList(10, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                                .append("nome", "Ingles ")
                                .append("nível", "Avancado"),
                        new Document()
                                .append("nome", "Espanhol")
                                .append("nível", "Básico")));

        // inserts
        alunos.insertOne(aluno1);
        alunos.insertOne(aluno2);
        alunos.insertOne(aluno3);

        // updates
        alunos.updateOne(Filters.eq("nome", "Pedro"),
                new Document("$set", new Document("data_nascimento" , new Date(2002-2000, 05, 13))));

        alunos.updateOne(Filters.eq("nome", "Noah"),
                new Document("$set", new Document("data_nascimento" , new Date(2000-2000, 10, 05))));

        alunos.updateOne(Filters.eq("nome", "Paulo"),
                new Document("$set", new Document("data_nascimento" , new Date(1970-2000, 04, 15))));

        // deletes
        alunos.deleteOne(Filters.eq("nome" , "Pedro Israel"));
        alunos.deleteOne(Filters.eq("_id" , 4));
        alunos.deleteOne(Filters.eq("idade" , 22));

        // find aluno
        System.out.println("-- Aluno 1");
        Document findAluno1 = alunos.find(new Document("nome" , "Gustavo Linck"))
                .first();
        System.out.println(findAluno1);

        System.out.println("-- Aluno 2");
        Document findAluno2 = alunos.find(new Document("_id" , 2))
                .first();
        System.out.println(findAluno2);

        System.out.println("-- Aluno 3");
        Document findAluno3 = alunos.find(new Document("notas" , 10))
                .first();
        System.out.println(findAluno3);

       // Agrega dados
        System.out.println("-- Cursos");
        alunos.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("$curso.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("-- Habilidade");
        alunos.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("habilidade.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("-- Status");
        alunos.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("$status", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        //Projections
        System.out.println("\n-- Projection 1");
        Bson filter = Filters.empty();
        Bson projection = Projections.fields(Projections.include("nome"), Projections.excludeId());
        alunos.find(filter).projection(projection).forEach(doc -> System.out.println(doc));


        System.out.println("\n-- Projection 2 ");
        Bson filter2 = Filters.eq("status", "A");
        Bson projection2 = Projections.fields(Projections.include("nome"), Projections.include("idade"), Projections.excludeId());
        alunos.find(filter2).projection(projection2).forEach(doc -> System.out.println(doc));

        System.out.println("\n-- Projection 3");
        Bson filter3 = Filters.eq("idade", 27);
        Bson projection3 = Projections.fields(Projections.include("nome"), Projections.include("idade"), Projections.excludeId());
        alunos.find(filter3).projection(projection3).forEach(doc -> System.out.println(doc));
    }
}
