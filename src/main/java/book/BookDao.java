package book;

import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonObjectId;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class BookDao {

    private MongoClient client = new MongoClient("localhost", 27017);
    private MongoDatabase database = client.getDatabase("test").withReadPreference(ReadPreference.secondary());
    private MongoCollection<BsonDocument> collection = database.getCollection("test", BsonDocument.class);

    public void save(BsonDocument book) {
        collection.insertOne(book);
    }

    public void save(List<BsonDocument> books) {
        collection.insertMany(books);
    }

    public BsonDocument getByTitle(String title) {
        return collection.find(eq("name", title)).first();
    }

    public BsonDocument getById(String id) {
        BsonObjectId objectId = new BsonObjectId(new ObjectId(id));
        return collection.find(eq("_id", objectId)).first();
    }

    public List<BsonDocument> getAll() {
        return collection.find().into(new ArrayList<>());
    }

    public List<BsonDocument> getByYear(int year) {
        return collection.find(eq("year", year)).into(new ArrayList<>());
    }

    public void update(BsonDocument book) {
        collection.updateOne(getByTitle(book.get("name").toString()), book);
    }

    public void delete(String id) {
        collection.deleteOne(getById(id));
    }

}
