package io.pivotal.bds.gemfire.mongodb.util;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBClientHelper {

    private static MongoClient client;
    private static MongoDatabase database;
    private static Map<String, MongoCollection<Document>> collections = new HashMap<>();
    private static final String defaultCollectionName = System.getProperty("mongodb.default-collection-name","gemfire");

    private static final Logger LOG = LoggerFactory.getLogger(MongoDBClientHelper.class);
    
    public static MongoCollection<Document> getDefaultCollection() {
        return getCollection(defaultCollectionName);
    }

    public static synchronized MongoCollection<Document> getCollection(String name) {
        MongoCollection<Document> c = collections.get(name);

        if (c == null) {
            MongoDatabase db = getDatabase();

            LOG.info("getCollection: name={}", name);
            c = db.getCollection(name);

            if (c == null) {
                throw new IllegalArgumentException("MongoDB collection " + name + " does not exist");
            }

            collections.put(name, c);
        }

        return c;
    }

    private static synchronized MongoDatabase getDatabase() {
        if (database == null) {
            MongoClient cli = getClient();

            String name = System.getProperty("mongodb.database.name", "gemfire");
            LOG.info("getDatabase: name={}", name);

            database = cli.getDatabase(name);
        }

        return database;
    }

    private static synchronized MongoClient getClient() {
        if (client == null) {
            String host = System.getProperty("mongodb.host", "localhost");
            int port = Integer.parseInt(System.getProperty("mongodb.port", "27017"));
            LOG.info("getClient: host={}, port={}", host, port);

            client = new MongoClient(host, port);
        }

        return client;
    }
}
