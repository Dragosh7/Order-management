package org.example.businessLayer;
import org.example.businessLayer.Validators.EmailValidator;
import org.example.businessLayer.Validators.Validator;
import org.example.Model.Clients;
import org.example.dataAccessLayer.ClientDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {

    private ClientDAO clientDAO;//= new ClientDAO();

    private List<Validator<Clients>> validators;

    public ClientBLL() {
        validators = new ArrayList<Validator<Clients>>();
        validators.add(new EmailValidator());
        clientDAO = new ClientDAO();
    }

    /**
     *
     * @param id
     * @return
     */
    public Clients findClientById(int id) {
        Clients client = clientDAO.findById(id);
        if (client == null) {
            JOptionPane.showMessageDialog(null, "Client inexistent!");
            throw new NoSuchElementException("The client with clientID =" + id + " was not found!");
        }
        return client;
    }

    /**
     *
     * @return
     */
    public String[] getFieldNames(){
        String[] s = clientDAO.takeFieldNames();
        return s;
    }

    /**
     *
     * @return
     */
    public String[][] getListOfClients(){
        String[][] s = clientDAO.listOfObject(clientDAO.findAll());
        return s;
    }

    /**
     *
     * @param x
     * @return
     */
    public Clients insertClient(Clients x) {
        for (Validator<Clients> v : validators) {
            v.validate(x);
        }
        return clientDAO.insert(x);
    }

    /**
     *
     * @param clientID
     */
    public void deleteClient(int clientID) {
        clientDAO.delete(clientID);
    }

    /**
     *
     * @return
     */
    public List<Clients> findAllClients() {
        return clientDAO.findAll();
    }

    /**
     *
     * @param client
     * @return
     */
    public Clients updateClient(Clients client) {
        return clientDAO.update(client,client.getId());
    }
}