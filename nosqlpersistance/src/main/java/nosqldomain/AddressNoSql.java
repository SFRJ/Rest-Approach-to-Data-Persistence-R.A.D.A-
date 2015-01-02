package nosqldomain;

import com.mongodb.BasicDBObject;

import java.io.Serializable;
import java.util.List;

public class AddressNoSql extends BasicDBObject implements Serializable {

    private String firstLine;

    private String secondLine;

    private String postcode;

    private List<PersonNoSql> persons;

    public AddressNoSql() {
    }

    public AddressNoSql(String firstLine, String secondLine, String postcode, List<PersonNoSql> persons) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postcode = postcode;
        this.persons = persons;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public List<PersonNoSql> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonNoSql> person) {
        this.persons = person;
    }

}
