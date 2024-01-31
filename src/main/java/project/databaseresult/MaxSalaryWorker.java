package project.databaseresult;

public final class MaxSalaryWorker {
    private final String name;
    private final Integer salary;

    public MaxSalaryWorker(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String name() {
        return name;
    }

    public Integer salary() {
        return salary;
    }
}
