package orm;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class ORMAddress implements Serializable {

    private Long uniqueId;
    private String firstLine;
    private String secondLine;
    private String postcode;
    private Set<ORMPerson> ormPersons;

    public ORMAddress() {
    }

    public ORMAddress(String firstLine, String secondLine, String postcode, Set<ORMPerson> ormPersons) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postcode = postcode;
        this.ormPersons = ormPersons;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long id) {
        this.uniqueId = id;
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

    public Set<ORMPerson> getOrmPersons() {
        return ormPersons;
    }

    public void setOrmPersons(Set<ORMPerson> ormPersons) {
        this.ormPersons = ormPersons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ORMAddress that = (ORMAddress) o;

        if (!firstLine.equals(that.firstLine)) return false;
        if (!uniqueId.equals(that.uniqueId)) return false;
        if (!postcode.equals(that.postcode)) return false;
        if (!secondLine.equals(that.secondLine)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uniqueId.hashCode();
        result = 31 * result + firstLine.hashCode();
        result = 31 * result + secondLine.hashCode();
        result = 31 * result + postcode.hashCode();
        return result;
    }
}
