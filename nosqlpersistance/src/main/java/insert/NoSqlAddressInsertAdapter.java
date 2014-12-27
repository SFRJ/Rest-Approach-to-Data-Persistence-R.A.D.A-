package insert;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import domain.Address;
import domain.Person;
import services.AddressInsertService;

import javax.inject.Inject;

public class NoSqlAddressInsertAdapter implements AddressInsertService {

    private final MongoClient mongoClient;

    @Inject
    public NoSqlAddressInsertAdapter(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void insert(Address address) {
        DBCollection addresses = mongoClient.getDB("radadata").getCollection("address");
        BasicDBObject databaseObject = new BasicDBObject();
        databaseObject.put("address", address);
        addresses.insert(databaseObject);
    }
}
