package project.service;

import project.dao.ClientDao;
import project.model.Client;

import java.util.List;

public class ClientService {
    public long create(String name) {
        if (name == null || name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("The Client length name must be more than 1 but less than 1001 characters");
        }
        Client client = new Client(name);
        return ClientDao.create(client);
    }

    public String getById(long id) {
       return ClientDao.getById(id).getName();
    }

    public void setName(long id, String name) {
        ClientDao.update(new Client(id, name));
    }

    public void deleteById(long id) {
        ClientDao.deleteById(id);
    }

    public List<Client> listAll() {
        return ClientDao.getAll();
    }
}
