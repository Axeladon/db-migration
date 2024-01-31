package project.databaseresult;

public class LongestProject {
    private final Integer id;
    private final Integer monthCount;
    public LongestProject(int id, int monthCount) {
        this.id = id;
        this.monthCount = monthCount;
    }
    public Integer getId() { return id; }
    public Integer getMonthCount() { return monthCount; }
}
