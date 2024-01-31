package project.databaseresult;

public final class MaxProjectCountClient {
    private final String name;
    private final Integer projectCount;

    public MaxProjectCountClient(String name, Integer projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String name() {
        return name;
    }

    public Integer projectCount() {
        return projectCount;
    }
}
