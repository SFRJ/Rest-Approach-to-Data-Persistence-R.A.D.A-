package insert;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import domain.Address;
import domain.Person;
import nosqldomain.AddressNoSql;
import nosqldomain.PersonNoSql;
import services.nosqlcrud.CreateService;

import javax.inject.Inject;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class NoSqlAddressInsertAdapter implements CreateService {

    private final MongoClient mongoClient;

    @Inject
    public NoSqlAddressInsertAdapter(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    @Override
    public void create(Address address) {
        DBCollection collection = mongoClient.getDB("radadata").getCollection("address");
        collection.insert(toNoSqlAddress(address));
    }

    private AddressNoSql toNoSqlAddress(Address address) {
        AddressNoSql addressNoSql = new AddressNoSql();
        addressNoSql.append("firstline", address.getFirstLine());
        addressNoSql.append("secondline", address.getSecondLine());
        addressNoSql.append("postcode", address.getPostcode());
        addressNoSql.append("persons", address.getPersons().stream().map(toNoSqlPersons()).collect(toList()));
        return addressNoSql;
    }

    private Function<Person, PersonNoSql> toNoSqlPersons() {
        return person -> {
            PersonNoSql personNoSql = new PersonNoSql();
            personNoSql.append("firstname", person.getFirstName());
            personNoSql.append("secondname", person.getSecondName());
            return personNoSql;
        };
    }
}
