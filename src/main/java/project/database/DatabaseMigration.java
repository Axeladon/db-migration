package project.database;

import org.flywaydb.core.Flyway;

public class DatabaseMigration {
    private DatabaseMigration() {

    }

    public static void migrateDatabase(Database database) {
        Flyway flyway = Flyway.configure()
                .dataSource(database.getUrl(), database.getLogin(), database.getPassword())
                .load();
        flyway.migrate();
    }
}
