import domain.Address;
import domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import orm.ORMAddress;
import orm.ORMPerson;
import services.sqlcrud.CreateService;

import javax.inject.Inject;

public class SqlAddressInsertAdapter implements CreateService {

    @Inject
    public SqlAddressInsertAdapter() {
    }

    private static SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    private Session session;

    public void insert(Address address) {
        session = SqlAddressInsertAdapter.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        address.getPersons().stream().forEach((person) -> {
            ORMPerson ormPerson = new ORMPerson(person.getFirstName(),
                    person.getSecondName());
            session.save(ormPerson);
        });
        session.save(new ORMAddress(address.getFirstLine(),
                address.getSecondLine(),address.getPostcode()));
        session.getTransaction().commit();
    }

    @Override
    public void create(Person person) {

    }

    @Override
    public void create(Address address) {

    }
}
