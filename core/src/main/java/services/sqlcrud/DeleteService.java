package services.sqlcrud;

import domain.Address;
import domain.Person;

public interface DeleteService {

    public void delete(Person person);

    public void delete(Address address);
}
