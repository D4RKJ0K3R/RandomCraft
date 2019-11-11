package org.coderandom.random_craft.utils;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.coderandom.random_craft.RandomCraft;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CollectionUtil {
    private final MongoCollection<Document> collection;
    private final boolean isPlayerData;

    public CollectionUtil(String collectionName, boolean isPlayerData) {
        this.collection = RandomCraft.getDatabase().getCollection(collectionName);
        this.isPlayerData = isPlayerData;
    }

    public Document find(String key, Object value) {
        return collection.find(new Document(key, value)).first();
    }

    public boolean isSet(Object documentID, String key) {
        return (get(documentID, key) != null);
    }

    public void remove(Object documentID, String key) {
        Document data = getRaw(documentID);
        data.remove(key);
        setData(documentID, data);
    }

    protected Object getOrDefault(Object documentID, String key, Object value) {
        Object object = getRaw(documentID).get(key);

        if (object == null) {
            return value;
        } else {
            return object;
        }
    }

    public Object get(Object documentID, String key) {
        return getData(documentID).get(key);
    }

    public void set(Object documentID, String key, Object value) {
        setData(documentID, getRaw(documentID).append(key, value));
    }

    public void removeData(Object documentID) {
        if (documentID instanceof String) {
            documentID = ((String) documentID).toLowerCase();
        }
        collection.deleteOne(new Document("DOCUMENT_ID", documentID));
    }

    public void setData(Object documentID, Document document) {
        if (documentID instanceof String) {
            documentID = ((String) documentID).toLowerCase();
        }
        Document filter = new Document("DOCUMENT_ID", documentID);
        Document found = collection.find(filter).first();

        if (found == null) {
            collection.insertOne(document);
        } else {
            collection.replaceOne(filter, document);
        }
    }

    public List<String> listKeys(Object documentID) {
        return new ArrayList<>(getData(documentID).keySet());
    }

    public Document getData(Object documentID) {
        Document data = getRaw(documentID);
        data.remove("_id");
        data.remove("DOCUMENT_ID");
        data.remove("PlayerName");
        return data;
    }

    public Document getRaw(Object documentID) {
        if (documentID instanceof String) {
            documentID = ((String) documentID).toLowerCase();
        }
        Document filter = new Document("DOCUMENT_ID", documentID);
        Document found = collection.find(filter).first();

        if (found == null && documentID instanceof String) {
            if (isPlayerData) {
                UUID uuid = UUID.fromString((String) documentID);
                Player player = Bukkit.getPlayer(uuid);

                if (player != null) {
                    filter.append("PlayerName", player.getName());
                }
            }
            return filter;
        }

        return found;
    }
}
