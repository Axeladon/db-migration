package project.databaseresult;

import java.util.Date;

public final class YoungestEldestWorkers {
    private final String type;
    private final String name;
    private final Date birthday;

    public YoungestEldestWorkers(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String type() {
        return type;
    }

    public String name() {
        return name;
    }

    public Date birthday() {
        return birthday;
    }
}
