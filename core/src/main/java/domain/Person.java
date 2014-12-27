package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;

import java.io.Serializable;

public class Person extends BasicDBObject implements Serializable {

    //For hibernate purpose
    private Long id;
    private Long  personToAddresFk;

    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("secondname")
    private String secondName;

    public Person() {
    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Long getPersonToAddresFk() {
        return personToAddresFk;
    }

    public void setPersonToAddresFk(Long personToAddresFk) {
        this.personToAddresFk = personToAddresFk;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!secondName.equals(person.secondName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        return result;
    }
}