import domain.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import orm.ORMPerson;
import services.AddressInsertService;

import javax.inject.Inject;

public class SqlAddressInsertAdapter implements AddressInsertService {

    @Inject
    public SqlAddressInsertAdapter() {
    }

    private static SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    private Session session;

    @Override
    public void insert(Address address) {
        session = SqlAddressInsertAdapter.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        address.getPersons().stream().forEach((person) -> {
            ORMPerson ormPerson = new ORMPerson(person.getFirstName(),
                    person.getSecondName());
            session.save(ormPerson);
        });
        session.save(address);
        session.getTransaction().commit();
    }
}
