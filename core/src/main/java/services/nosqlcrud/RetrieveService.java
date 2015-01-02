package services.nosqlcrud;

import domain.Address;
import domain.Person;

public interface RetrieveService {

    public Person retrieve(Address address);
}
