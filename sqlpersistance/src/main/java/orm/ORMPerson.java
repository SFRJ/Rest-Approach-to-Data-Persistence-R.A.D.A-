package orm;

import java.io.Serializable;

public class ORMPerson implements Serializable {

    private Long uniqueId;
    private String firstName;
    private String secondName;
    private Long fkAddress;

    public ORMPerson() {
    }

    public ORMPerson(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public ORMPerson(String firstName, String secondName, Long fkAddress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fkAddress = fkAddress;
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

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long id) {
        this.uniqueId = id;
    }

    public Long getFkAddress() {
        return fkAddress;
    }

    public void setFkAddress(Long fkAddress) {
        this.fkAddress = fkAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ORMPerson ORMPerson = (ORMPerson) o;

        if (!firstName.equals(ORMPerson.firstName)) return false;
        if (!secondName.equals(ORMPerson.secondName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        return result;
    }
}