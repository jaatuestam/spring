package hello;

public class Greeting {

    private long id;
    private String name;

    public Greeting() {
    }

    public Greeting(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }


}
