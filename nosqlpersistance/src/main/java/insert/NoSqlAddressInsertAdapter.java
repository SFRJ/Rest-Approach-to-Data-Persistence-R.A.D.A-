package insert;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import domain.Address;
import domain.Person;
import services.AddressInsertService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class NoSqlAddressInsertAdapter implements AddressInsertService {

    private final MongoClient mongoClient;

    @Inject
    public NoSqlAddressInsertAdapter(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void insert(Address address) {
        List<MongoPerson> mongodbpersons = new ArrayList<>();

        for(Person person : address.getPersons()) {
            MongoPerson mongoPerson = new MongoPerson();
            mongoPerson.append("firstname", person.getFirstName());
            mongoPerson.append("secondname", person.getSecondName());
            mongodbpersons.add(mongoPerson);
        }

        DBCollection collection = mongoClient.getDB("radadata").getCollection("address");
        BasicDBObject databaseObject = new BasicDBObject();
        databaseObject.put("firstline", address.getFirstLine());
        databaseObject.put("secondline", address.getSecondLine());
        databaseObject.put("postcode", address.getPostcode());

        BasicDBList dbList = new BasicDBList();
        mongodbpersons.stream().forEach(dbList::add);
        databaseObject.append("persons", dbList);

        collection.insert(databaseObject);
    }

}
