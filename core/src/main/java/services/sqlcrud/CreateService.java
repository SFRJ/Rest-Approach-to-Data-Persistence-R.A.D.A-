package services.sqlcrud;

import domain.Address;
import domain.Person;

public interface CreateService {

    public void create(Person person);

    public void create(Address address);

}
