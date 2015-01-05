import domain.Address;
import domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import orm.ORMAddress;
import orm.ORMPerson;
import services.sqlcrud.CreateService;

import javax.inject.Inject;
import java.util.Set;
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


        Set<ORMPerson> ormPersons = address.getPersons().stream().map(toOrmPersons()).collect(toSet());

        ORMAddress ormAddress = new ORMAddress();
        ormAddress.setFirstLine(address.getFirstLine());
        ormAddress.setSecondLine(address.getSecondLine());
        ormAddress.setPostcode(address.getPostcode());
        ormAddress.setOrmPersons(ormPersons);


        session.save(ormAddress);

        session.getTransaction().commit();
    }

    @Override
    public void create(Person person) {
        //
    }

    private Function<Person, ORMPerson> toOrmPersons() {
        return person -> new ORMPerson(person.getFirstName(),person.getSecondName());
    }
}
