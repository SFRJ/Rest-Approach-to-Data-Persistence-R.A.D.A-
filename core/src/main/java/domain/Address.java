package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;

import java.io.Serializable;
import java.util.List;

public class Address extends BasicDBObject implements Serializable {
    private Long id;//for hibernate purpose
    @JsonProperty("firstline")
    private String firstLine;
    @JsonProperty("secondline")
    private String secondLine;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("persons")
    private List<Person> person;

    public Address() {
    }

    public Address(String firstLine, String secondLine, String postcode, List<Person> person) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postcode = postcode;
        this.person = person;
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
        return person;
    }

    public void setPersons(List<Person> person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
