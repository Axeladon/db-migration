package project.model;

import java.sql.Date;

public class Project {
    private final int clientId;
    private final Date startDate;
    private final Date finishDate;

    public Project(int clientId, Date startDate, Date finishDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getClientId() {
        return clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }
}