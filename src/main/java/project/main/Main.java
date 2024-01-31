package project.main;

import project.database.Database;
import project.database.DatabaseMigration;
import project.database.DatabaseQueryService;
import project.databaseresult.LongestProject;
import project.databaseresult.MaxProjectCountClient;
import project.databaseresult.MaxSalaryWorker;
import project.databaseresult.YoungestEldestWorkers;
import project.model.Client;
import project.service.ClientService;

import java.util.List;

@SuppressWarnings("java:S106")

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        DatabaseMigration.migrateDatabase(database);

        ClientService clientService = new ClientService();

        long newClientId = clientService.create("Britney Spears");
        System.out.println("the newly added client has an ID: " + newClientId);

        clientService.setName(3, "Eddie Murphy");

        int id = 6;
        System.out.println("Client ID " + id + " is " + clientService.getById(id));

        clientService.deleteById(2);

        for (Client client : clientService.listAll()) {
            System.out.println(client.getId() + ", " + client.getName());
        }

        /*printMaxProjectCountClients();
        printLongestProject();
        printMaxSalaryWorker();
        printYoungestEldestWorkers();*/
    }

    private static void printMaxProjectCountClients() {
        List<MaxProjectCountClient> mpccList = new DatabaseQueryService().findMaxProjectsClient();
        for (MaxProjectCountClient mpcc : mpccList) {
            System.out.print(mpcc.name() + " has " + mpcc.projectCount() + " projects\n");
        }
    }

    private static void printLongestProject() {
        List<LongestProject> lpList = new DatabaseQueryService().findLongestProject();
        for (LongestProject lp : lpList) {
            System.out.print("Project ID: " + lp.getId() + " has the longest time " + lp.getMonthCount() + " months\n");
        }
    }

    private static void printMaxSalaryWorker() {
        List<MaxSalaryWorker> msList = new DatabaseQueryService().findMaxSalaryWorker();
        for (MaxSalaryWorker lp : msList) {
            System.out.print(lp.name() + " has the biggest salary = " + lp.salary() + "\n");
        }
    }

    private static void printYoungestEldestWorkers() {
        List<YoungestEldestWorkers> yewList = new DatabaseQueryService().findYoungestEldestWorkers();
        for (YoungestEldestWorkers yew : yewList) {
            System.out.println("The " + yew.type() + " worker is " + yew.name() + " who has a birthday on " + yew.birthday());
        }
    }
}
