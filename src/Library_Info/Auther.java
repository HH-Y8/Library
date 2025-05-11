package Library_Info;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Auther {
    private String name;
    private int birthYear;
    private String nationality;

    public Auther(String name, String nationality, int birthYear) {
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return String.format("Auther[name=%s,nationality=%s,birthYear=%d]", name, nationality, birthYear);
    }
}