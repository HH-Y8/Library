package Library_Info;

public class publisher {
    private String name;
    private String address;
    private String contact;

    public publisher(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContact() { return contact; }

    @Override
    public String toString() {
        return String.format("Publisher[name=%s, address=%s, contact=%s]", name, address, contact);
    }
}
