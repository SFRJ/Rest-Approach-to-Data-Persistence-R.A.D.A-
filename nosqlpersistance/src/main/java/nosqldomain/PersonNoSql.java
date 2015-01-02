package nosqldomain;

import com.mongodb.BasicDBObject;

import java.io.Serializable;

public class PersonNoSql extends BasicDBObject implements Serializable {

    private String firstName;

    private String secondName;

    public PersonNoSql() {
    }

    public PersonNoSql(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonNoSql person = (PersonNoSql) o;

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

    @Override
    public String toString() {
        return super.toString();
    }
}