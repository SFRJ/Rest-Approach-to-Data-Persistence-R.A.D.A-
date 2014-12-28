package orm;

import java.io.Serializable;
import java.util.List;

public class ORMAddress implements Serializable {

    private Long id;
    private String firstLine;
    private String secondLine;
    private String postcode;

    public ORMAddress() {
    }

    public ORMAddress(String firstLine, String secondLine, String postcode) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ORMAddress that = (ORMAddress) o;

        if (!firstLine.equals(that.firstLine)) return false;
        if (!id.equals(that.id)) return false;
        if (!postcode.equals(that.postcode)) return false;
        if (!secondLine.equals(that.secondLine)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstLine.hashCode();
        result = 31 * result + secondLine.hashCode();
        result = 31 * result + postcode.hashCode();
        return result;
    }
}
