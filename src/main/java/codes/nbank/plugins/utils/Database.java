package codes.nbank.plugins.utils;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class Database {
    public static MongoClient mongoClient;
    public static MongoDatabase mongoDatabase;

    public static void connect() {
        mongoClient = MongoClients.create("mongodb+srv://root:" + Utils.dbPassword + "@cluster0-lk7np.mongodb.net");
        mongoDatabase = mongoClient.getDatabase("minecraft");
    }

    public static void disconnect() {
        mongoClient.close();
    }
}
