package com.testhamza.hamza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository repo1;

    public List<Client> listAll() {
        return repo1.findAll();
    }

    public void save(Client client) {
        repo1.save(client);
    }

    public Client get(int id) {
        return repo1.findById(id).get();
    }

}
