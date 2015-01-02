package services.sqlcrud;

import domain.Address;
import domain.Person;

public interface UpdateService {

    public void update(Person person);

    public void update(Address address);

}
