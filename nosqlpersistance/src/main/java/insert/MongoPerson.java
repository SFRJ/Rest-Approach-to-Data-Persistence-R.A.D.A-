package insert;

import com.mongodb.BasicDBObject;

public class MongoPerson extends BasicDBObject {

    private String firstName;
    private String secondName;

    public MongoPerson() {
    }

    public MongoPerson(String firstName, String secondName) {
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
}
