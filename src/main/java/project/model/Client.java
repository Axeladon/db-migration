package project.model;

public class Client {
    private long id;
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public Client(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
