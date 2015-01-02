import domain.Address;
import domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import orm.ORMAddress;
import orm.ORMPerson;
import services.sqlcrud.CreateService;

import javax.inject.Inject;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

public class SqlAddressInsertAdapter implements CreateService {

    @Inject
    public SqlAddressInsertAdapter() {
    }

    private static SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    private Session session;

    @Override
    public void create(Address address) {
        session = SqlAddressInsertAdapter.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(new ORMAddress(address.getFirstLine(),
                address.getSecondLine(),address.getPostcode(), address.getPersons().stream().map(toOrmPersons()).collect(toSet())));
        session.getTransaction().commit();
    }

    @Override
    public void create(Person person) {
        //The way the Mapping is done, Persons cannot be created without address.
    }

    private Function<Person, ORMPerson> toOrmPersons() {
        return person -> new ORMPerson(person.getFirstName(),person.getSecondName());
    }
}
