package services.sqlcrud;

import domain.Address;
import domain.Person;

public interface RetrieveService {

    public Person retrieve(Person person);

    public Person retrieve(Address address);
}
