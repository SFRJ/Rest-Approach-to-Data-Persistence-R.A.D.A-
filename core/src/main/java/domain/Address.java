package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;

import java.io.Serializable;
import java.util.List;

public class Address implements Serializable {
    @JsonProperty("firstline")
    private String firstLine;
    @JsonProperty("secondline")
    private String secondLine;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("persons")
    private List<Person> persons;

    public Address() {
    }

    public Address(String firstLine, String secondLine, String postcode, List<Person> persons) {
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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> person) {
        this.persons = person;
    }

}
