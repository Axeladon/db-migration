package project.model;

import java.sql.Date;

public class Worker {
    String name;
    Date date;
    Level level;
    Integer salary;

    public Worker(String name, Date date, Level level, Integer salary) {
        this.name = name;
        this.date = date;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getLevel() {
        return level.getValue();
    }

    public Integer getSalary() {
        return salary;
    }
}
